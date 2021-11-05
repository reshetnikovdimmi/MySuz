package com.suz.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Dao
public interface StocksDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStocks(List<Stocks> stocks);

//SELECT * FROM `stocks` WHERE `c` <= '2021-10-31' AND `do` >= '2021-10-31' ORDER BY `stocks`.`do` DESC
    @Query("select * from stocks where `end` >= :date and `beginning` <= :date order by `end`desc")
    List<Stocks> getAlbums(String date);

    @Query("select * from stocks where `end` <= :date order by `end`desc")
    List<Stocks> getPast_promos(String date);

    @Query("select * from stocks where `beginning` >= :date order by `end`desc")
    List<Stocks> getFuture_promos(String date);



}

