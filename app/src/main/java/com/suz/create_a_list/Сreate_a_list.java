package com.suz.create_a_list;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.suz.AppDelegate;
import com.suz.R;
import com.suz.database.Stocks;
import com.suz.database.StocksDao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Сreate_a_list  {

    String url = "https://user357.000webhostapp.com/Android/Droid_Suz_bonus.php";
    public static List<Stocks> albums = new ArrayList<>();
    Stocks stocks;
    Executor myExecutor;

    List<Stocks> header3;

    public void create_a_list(Context applicationContext) {
        RequestQueue PQ = Volley.newRequestQueue(applicationContext);
        StringRequest SR = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  Log.d("array", response + "response");

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (sucess.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);
                            int id = object.getInt("id");
                            String brand = object.getString("brand");
                            String model = object.getString("model");
                            String beginning = object.getString("beginning");
                            String end = object.getString("end");
                            String price = object.getString("price");
                            stocks = new Stocks(id, brand, model, beginning, end, price);
                            albums.add(stocks);

                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                myExecutor = Executors.newSingleThreadExecutor();
                myExecutor.execute(() -> {
                    final StocksDao stocksDatabase = ((AppDelegate) applicationContext).getmStocksDatabase().getStocksDao();
                    stocksDatabase.insertStocks(albums);

                });

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(applicationContext.getApplicationContext(), R.string.Data_not_updated, Toast.LENGTH_LONG).show();
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

}
