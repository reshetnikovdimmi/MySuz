package com.suz.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Stocks.class}, version = 1)
public abstract class StocksDatabase extends RoomDatabase {

    public abstract StocksDao getStocksDao();

}
