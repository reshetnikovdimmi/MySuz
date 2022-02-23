package com.suz.common;

import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.suz.StoksSuz.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FragmentPresenter implements  BaseView.Presenter, BaseView.extracted, BaseView.Create_a_list, BaseView.Create_countries{

    FragmentActivity presenter;
    ArrayList<String> countries = new ArrayList<>();

    public FragmentPresenter(FragmentActivity presenter) {
        this.presenter = presenter;

    }

    BaseView.extracted extracted;

    public FragmentPresenter(BaseView.extracted extracted) {
        this.extracted = extracted;
    }

    BaseView.Create_countries create_countries;

    public FragmentPresenter(BaseView.Create_countries create_countries) {
        this.create_countries = create_countries;
    }

    BaseView.View view;

    public FragmentPresenter(BaseView.View view) {
        this.view = view;
    }

    public FragmentPresenter(BaseView.Create_a_list create_a_list) {
        this.create_a_list = create_a_list;
    }

    BaseView.Create_a_list create_a_list;

    @Override
    public void doLogin(String URL, String login, String password, Context context) {

            RequestQueue PQ = Volley.newRequestQueue(context);
            StringRequest SR = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (sucess.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name");
                                    String email = object.getString("email");
                                    inextracted(email,name, context);

                                }

                            }else{

                                Toast.makeText(context, "Error " + response, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error " +e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    MainActivity activity = (MainActivity) context;
                    activity.onSuccess();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    MainActivity activity = (MainActivity) context;
                    activity.onError();


                }
            }) {
                @Override
                public Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<>();

                            map.put("login", login);
                            map.put("password", password);

                    return map;

                }

            };
            PQ.add(SR);


        }




    @Override
    public void inCreate_a_list(String URL, Context context) {
        RequestQueue PQ = Volley.newRequestQueue(context);
        StringRequest SR = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {

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

                        inCreate_countries(countries,context);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Error " +e.toString(), Toast.LENGTH_SHORT).show();
                }
                MainActivity activity = (MainActivity) context;
                activity.onSuccess();



            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                MainActivity activity = (MainActivity) context;
                activity.onError();
            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();

                // map.put("login", item);
                // map.put("password", ETP.getText().toString());

                return map;

            }

        };
        PQ.add(SR);
    }
    @Override
    public void inextracted(String s, String b, Context context) {
        MainActivity activity = (MainActivity) context;
        activity.inextracted(s,b,context);

    }


    @Override
    public void inCreate_countries(ArrayList<String> countries,Context context) {
        MainActivity activity = (MainActivity) context;
        activity.inCreate_countries(countries,context);

    }
}
