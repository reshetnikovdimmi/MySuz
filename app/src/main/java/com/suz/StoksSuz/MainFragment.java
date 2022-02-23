package com.suz.StoksSuz;

import static android.R.layout.simple_spinner_item;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
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

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.suz.R;
import com.suz.common.BaseView;
import com.suz.common.FragmentPresenter;
import com.suz.common.NotifResiver;
import com.suz.common.SharedPreferencesHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MainFragment extends Fragment implements BaseView.View, BaseView.Create_countries,BaseView.extracted {
    Context context;
    ProgressBar tvProgressCircle;
    Button BT;
    EditText ETP;
    String item;
    String url = "https://user357.000webhostapp.com/Android/Droid_Suz.php";
    String url_authorization = "https://user357.000webhostapp.com/Android/Droid_Suz_authorization.php";
    private SharedPreferencesHelper mSharedPreferencesHelper;
    NotifResiver notifResiver = new NotifResiver();
    BaseView.Presenter presenter;
    BaseView.Create_a_list create_a_list;
    Spinner spinner;
    public static androidx.fragment.app.Fragment newInstance() {

        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
        }

    public static MainFragment newInstance(Bundle args) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main,container, false);

        presenter = new FragmentPresenter(getActivity());
        create_a_list = new FragmentPresenter(getActivity());
        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        BT=v.findViewById(R.id.ButVhod);
        ETP=v.findViewById(R.id.ETP);
        tvProgressCircle = v.findViewById(R.id.progressBar);

        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = getActivity();
                presenter.doLogin(url_authorization,item,ETP.getText().toString(),context );
             /* getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, MainFragment.newInstance())
                        .addToBackStack(MainFragment.class.getName())
                        .commit();*/
            }
        });
        spinner = (Spinner) v.findViewById(R.id.spinner);
         return v;
    }
    public void Spinner(ArrayList<String> countries) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//
        spinner.setAdapter(adapter);
        spinner.setPrompt("Title");
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = (String)parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    private void showMessage(@StringRes int string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStart() {
        super.onStart();

        if (mSharedPreferencesHelper.isLoggin())  {
            context = getActivity();
            HashMap<String, String> user = mSharedPreferencesHelper.getUserDetail();
            presenter.doLogin(
                    url_authorization,
                    user.get(mSharedPreferencesHelper.NAME),
                    user.get(mSharedPreferencesHelper.EMAIL),
                    context );
        } else {
            context = getActivity();
            create_a_list.inCreate_a_list(url,context);
        }
    }

    @Override
    public void onSuccess() {
        tvProgressCircle.setVisibility(View.GONE);
    }

    @Override
    public void onError() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        getActivity().registerReceiver(notifResiver,filter);
    }


    @Override
    public void inCreate_countries(ArrayList<String> countriess, Context context) {
        Spinner(countriess);
    }

    @Override
    public void inextracted(String s, String b, Context context) {
        Intent startProfileIntent =
                new Intent(getActivity(), MainActivityMenu.class);
        startProfileIntent.putExtra(MainActivityMenu.USER_KEY,
                new Employee(s,b));
        getActivity().startActivity(startProfileIntent);
        getActivity().finish();
    }
}
