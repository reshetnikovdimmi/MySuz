package com.suz.StoksSuz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.suz.R;
import com.suz.common.BaseView;
import com.suz.common.UpdateRv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class rv_promo_fragment extends Fragment implements BaseView.View, UpdateRv {

    private RecyclerView recyclerView,recyclerView_2;
    private StaticRvAdapter staticRvAdapter;
    ArrayList<DynamicRvModel> items = new ArrayList<>();
    DynamicRvAdapter dynamicRvAdapter;
    ArrayList<StaticRvModel> item = new ArrayList<>();
    String url = "https://user357.000webhostapp.com/Android/Droid_Suz.php";
    View view;

    public static Fragment newInstance() {
        return new rv_promo_fragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragment_1, container, false);



        RequestQueue PQ = Volley.newRequestQueue(getActivity());
        StringRequest SR = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
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
                            item.add(new StaticRvModel(shop));


                        }
                        RecyclerViews();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Error " +e.toString(), Toast.LENGTH_SHORT).show();
                }




            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

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





        return view;
    }
    public void RecyclerViews() {
        recyclerView = view.findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item, getActivity(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);

        items = new ArrayList<>();

        recyclerView_2 = view.findViewById(R.id.rv_2);

        dynamicRvAdapter = new DynamicRvAdapter(items);
        recyclerView_2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView_2.setAdapter(dynamicRvAdapter);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void callback(ArrayList<DynamicRvModel> items, StaticRvModel currentItem) {
        dynamicRvAdapter = new DynamicRvAdapter(items);
        dynamicRvAdapter.notifyDataSetChanged();
        recyclerView_2.setAdapter(dynamicRvAdapter);

    }
    @Override
    public void onStart() {
        super.onStart();

    }


}
