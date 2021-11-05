package com.suz;

import static com.suz.rv_promo_fragment.*;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

public class MainActivityMenu extends AppCompatActivity {
TextView shopTV;
ImageButton stocksBUT, bonusesBUT;
    private Employee mUser;
    public static final String USER_KEY = "USER_KEY";
    private SharedPreferencesHelper mSharedPreferencesHelper;
    String url = "https://user357.000webhostapp.com/Android/Droid_Suz_bonus.php";
    public static List<Stocks> albums = new ArrayList<>();
    Stocks stocks;
    View tvProgressCircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
        mSharedPreferencesHelper = new SharedPreferencesHelper(this);
        shopTV=findViewById(R.id.shopTV);
        stocksBUT=findViewById(R.id.stocksBUT);
        Bundle bundle = getIntent().getExtras();
        mUser = (Employee) bundle.get(USER_KEY);
        tvProgressCircle = findViewById(R.id.vf_progressbar);


        shopTV.setText(mUser.getShop());
        tvProgressCircle.setVisibility(View.GONE);

        stocksBUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_a_list();
                tvProgressCircle.setVisibility(View.VISIBLE);
/*
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, rv_promo_fragment.newInstance())
                        .addToBackStack(rv_promo_fragment.class.getName())
                        .commit();
                final Intent intent = new Intent(getApplicationContext(), RV_promo.class);

              startActivity(intent);
*/


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu, menu);
        menu.findItem(R.id.auto_input).setChecked(mSharedPreferencesHelper.SP());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionLogout:

                mSharedPreferencesHelper.addUser("0","0");

                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.auto_input:

                if (item.isChecked()){
                    item.setChecked(false);
                    mSharedPreferencesHelper.addUser("0","0");

                }else {
                    item.setChecked(true);
                    mSharedPreferencesHelper.addUser(mUser.getShop(),mUser.getPas());
                }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showMessage(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    public void create_a_list(){
        RequestQueue PQ = Volley.newRequestQueue(this);
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
                            stocks = new Stocks(id,brand,model,beginning,end,price);
                            albums.add(stocks);

                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Executor myExecutor = Executors.newSingleThreadExecutor();
                myExecutor.execute(() -> {
                    final StocksDao stocksDatabase = ((AppDelegate) getApplicationContext()).getmStocksDatabase().getStocksDao();
                    stocksDatabase.insertStocks(albums);


                });
                final Intent intent = new Intent(getApplicationContext(), RV_promo.class);
                startActivity(intent);
                tvProgressCircle.setVisibility(View.GONE);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                showMessage(R.string.no_connection);
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

