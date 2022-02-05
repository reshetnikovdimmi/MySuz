package com.suz.StoksSuz;

import static android.R.layout.simple_spinner_item;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
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
    String item;
    String url = "https://user357.000webhostapp.com/Android/Droid_Suz.php";
    String url_authorization = "https://user357.000webhostapp.com/Android/Droid_Suz_authorization.php";
    private SharedPreferencesHelper mSharedPreferencesHelper;


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



        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        BT=v.findViewById(R.id.ButVhod);
        ETP=v.findViewById(R.id.ETP);
        tvProgressCircle = v.findViewById(R.id.progressBar);
       // progressBar2.setIndeterminate(false);


        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                create_a_list(url_authorization);



             /* getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, MainFragment.newInstance())
                        .addToBackStack(MainFragment.class.getName())
                        .commit();*/


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

    public void create_a_list(String URL){
        RequestQueue PQ = Volley.newRequestQueue(getContext());
        StringRequest SR = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                    if(URL.equals(url)) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if (sucess.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String shop = object.getString("shop");

                                    countries.add(shop);
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Error " +e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (sucess.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name");
                                    String email = object.getString("email");
                                    extracted(email,name);
                                }

                            }else{

                                Toast.makeText(getActivity(), "Error " + response, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(), "Error " +e.toString(), Toast.LENGTH_SHORT).show();
                        }
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
                if (URL.equals(url_authorization)) {
                    if(mSharedPreferencesHelper.isLoggin()){
                        HashMap<String, String> user = mSharedPreferencesHelper.getUserDetail();

                        map.put("login", user.get(mSharedPreferencesHelper.NAME));
                        map.put("password", user.get(mSharedPreferencesHelper.EMAIL));

                    }else {


                        map.put("login", item);
                        map.put("password", ETP.getText().toString());
                    }
                }else {

                }
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

        if (mSharedPreferencesHelper.isLoggin())  {
create_a_list(url_authorization);


        } else {

            create_a_list(url);
        }

    }

}
