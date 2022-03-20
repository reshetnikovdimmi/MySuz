package com.suz.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StocksDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStocks(List<Stocks> stocks);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMTS(List<MTS> mts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSIM(List<SIM> sim);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRTC(List<RTC> rtc);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhone(List<Phone> phone);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAksy(List<Aksy> aksy);

    @Query("SELECT * from mts")
    List<MTS> getMts();

    @Query("SELECT * from rtc")
    List<RTC> getRTC();

    @Query("SELECT * from phone")
    List<Phone> getPhone();

    @Query("SELECT * from aksy")
    List<Aksy> getAksy();



//SELECT * FROM `stocks` WHERE `c` <= '2021-10-31' AND `do` >= '2021-10-31' ORDER BY `stocks`.`do` DESC
    @Query("select * from stocks where `end` >= :date and `beginning` <= :date order by `end`asc")
    List<Stocks> getAlbums(String date);

    @Query("select * from stocks where `end` <= :date order by `end`desc")
    List<Stocks> getPast_promos(String date);

    @Query("select * from stocks where `beginning` >= :date order by `end`desc")
   List<Stocks> getFuture_promos(String date);

    @Query("select * from stocks")
    List<Stocks> getFuture();

    @Query("select * from sim")
    List<SIM> getSIM();

    @Query("select * from stocks where `end` >= :date and `beginning` <= :date GROUP by `price`")
    List<Stocks> getEndPromo(String date);
    //SELECT DISTINCT `Promo price` FROM `stocks` WHERE `c` <= '2021-11-09' AND `do` >= '2021-11-09' ORDER BY `do` ASC
}

