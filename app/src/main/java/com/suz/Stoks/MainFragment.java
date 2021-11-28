package com.suz.Stoks;

import static android.R.layout.simple_spinner_item;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.suz.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainFragment extends Fragment {
    ProgressBar tvProgressCircle;
    Button BT;
    EditText ETP;
    ArrayList<String> countries ;
    public  static ArrayList<String> employeeArrayList = new ArrayList<>();
    Employee employee;
    String item;
    String url = "https://user357.000webhostapp.com/Android/Droid_Suz.php";
    HashMap<String, String> passports = new HashMap<>();
    private SharedPreferencesHelper mSharedPreferencesHelper;
    private Handler handler = new Handler();

    public static androidx.fragment.app.Fragment newInstance() {



        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
        }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main,
                container, false);



        countries = new ArrayList<>();
       countries.add("");

        create_a_list();

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        BT=v.findViewById(R.id.ButVhod);
        ETP=v.findViewById(R.id.ETP);
        tvProgressCircle = v.findViewById(R.id.progressBar);
       // progressBar2.setIndeterminate(false);


        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





             if (ETP.getText().toString().equals(passports.get(item))) {

                 extracted(item, passports.get(item));

             /* getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, MainFragment.newInstance())
                        .addToBackStack(MainFragment.class.getName())
                        .commit();*/
                   // Log.d("array", employeeArrayList + "mai");
                }
                else {
                    showMessage(R.string.login_register_success);
                }

            }

        });

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), simple_spinner_item, countries);

        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//
        // Применяем адаптер к элементу spinner

        spinner.setAdapter(adapter);
        spinner.setPrompt("Title");
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект

                item = (String)parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
        return v;
    }

    private void extracted(String s, String b) {

        Intent startProfileIntent =
                 new Intent(getActivity(), MainActivityMenu.class);
        startProfileIntent.putExtra(MainActivityMenu.USER_KEY,
                new Employee(s,b));
        startActivity(startProfileIntent);
        getActivity().finish();
    }

    public void create_a_list(){
        RequestQueue PQ = Volley.newRequestQueue(getContext());
        StringRequest SR = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {

                employeeArrayList.clear();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if(sucess.equals("1")){

                        for(int i=0;i<jsonArray.length();i++){

                            JSONObject object = jsonArray.getJSONObject(i);

                            String  id = object.getString("id");
                            String  shop = object.getString("shop");
                            String  pas = object.getString("pas");
                            countries.add(shop);
                         employee = new Employee(shop,pas);
                         passports.put(shop,pas);
                        }

                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();

                }
                tvProgressCircle.setVisibility(View.GONE);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

                showMessage(R.string.no_connection);
            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                //map.put("phone", ET.getText().toString());
                return map;

            }

        };
        PQ.add(SR);
    }
    private void showMessage(@StringRes int string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStart() {
        super.onStart();

        if (mSharedPreferencesHelper.SP())  {

            extracted(mSharedPreferencesHelper.getUser().get(0), mSharedPreferencesHelper.getUser().get(1));

        } else {
            showMessage(R.string.Enter_your_username_password);

        }

    }

}
