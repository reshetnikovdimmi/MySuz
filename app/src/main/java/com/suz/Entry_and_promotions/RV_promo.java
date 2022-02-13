package com.suz.Entry_and_promotions;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.suz.AppDelegate;

import com.suz.Entry_and_promotions.Retrofit.RetroClient;
import com.suz.Entry_and_promotions.Retrofit.StocksList;
import com.suz.R;
import com.suz.StoksSuz.ListAdapter;

import com.suz.database.Stocks;
import com.suz.database.StocksDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RV_promo extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    ListView listView;

    SwipeRefreshLayout refreshLayout;
    View tvProgressCircle;
    HashMap<String, List<Stocks>> listChild;
    List<String> listHeader;
    ListAdapter listAdapter;

    private ExpandableListView mExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rv_promo);


        refreshLayout = findViewById(R.id.sRL);
        refreshLayout.setColorSchemeColors(Color.BLACK);
        refreshLayout.setOnRefreshListener(this);
        tvProgressCircle = findViewById(R.id.vf_progressbar);
        mExpandableListView = findViewById(R.id.expandable_listview);

        RetroClient.getApiService().getMyStocks()
                .subscribeOn(Schedulers.io())
                .doOnNext(Stocks->getMusicDao().insertStocks(Stocks.getData()))
                .onErrorReturn(new Function<Throwable, StocksList>() {
                    @Override
                    public StocksList apply(@NonNull Throwable throwable) throws Exception {

                        if (RetroClient.NETWORK_EXCEPTIONS.contains(throwable.getClass())) {

                            StocksList response = new StocksList();
                            response.setData((ArrayList<Stocks>) getMusicDao().getFuture());
                            return response;
                        } else return null;
                    }



                })


                .subscribe(
                        Stocks -> {

                           // contactList = MTS.getData();
                            //Log.d("array", contactList + "contactList");
                          //  GeneratingЕable(contactList);

                             },
                              throwable -> {

                        })
        ;

        listData(); // call method


        listAdapter = new ListAdapter(this, getApplicationContext(), listChild, listHeader);

        // setting list adapter
        mExpandableListView.setAdapter(listAdapter);
//mExpandableListView.expandGroup(2);

// ListView Child Click listener
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(getApplicationContext(), listHeader.get(groupPosition) + " : " + listChild.get(listHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();


                return false;
            }
        });

        // ListView Group Click listener
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                Toast.makeText(getApplicationContext(), listHeader.get(groupPosition), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        // ListView Group Expand listener
        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                Toast.makeText(getApplicationContext(), listHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();


            }
        });

        //List Group collapsed listener
        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                Toast.makeText(getApplicationContext(), listHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();

            }
        });

        // mExpandableListView.expandGroup(1);
    }




    private void listData() {
        final StocksDao stocksDatabase = ((AppDelegate) getApplicationContext()).getmStocksDatabase().getStocksDao();

        listHeader = new ArrayList<String>();
        listChild = new HashMap<String, List<Stocks>>();

        listHeader.add("Текущие Promo");
        listHeader.add("Прошедшие Promo");
        listHeader.add("Будующие Promo");


        // Adding child data
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> {

            List<Stocks> header3 = stocksDatabase.getAlbums(datess());

            List<Stocks> header1 = stocksDatabase.getPast_promos(datess());

            List<Stocks> header2 = stocksDatabase.getFuture_promos(datess());



            listChild.put(listHeader.get(0), header3);
            listChild.put(listHeader.get(1), header1);
            listChild.put(listHeader.get(2), header2);
            //
        });

        tvProgressCircle.setVisibility(View.GONE);


        //  Toast.makeText(getApplicationContext(), stocksDatabase.getAlbums(datess()).get(2).toString(), Toast.LENGTH_LONG).show();
        if(refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);

        }

    }

    @Override
    public void onRefresh() {

        listData();



    }
    public static String datess(){
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        return date;
    }
    private StocksDao getMusicDao() {
        return ((AppDelegate) getApplicationContext()).getmStocksDatabase().getStocksDao();
    }
}
