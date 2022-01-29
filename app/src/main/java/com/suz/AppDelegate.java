package com.suz;

import android.app.Application;

import androidx.room.Room;

import com.suz.database.StocksDatabase;

public class AppDelegate extends Application {


    private StocksDatabase mStocksDatabase;




    @Override
    public void onCreate() {
        super.onCreate();

        mStocksDatabase = Room.databaseBuilder(getApplicationContext(), StocksDatabase.class, "stocks_database").fallbackToDestructiveMigration().build();

    }

    public StocksDatabase getmStocksDatabase() {
        return mStocksDatabase;
    }

}
