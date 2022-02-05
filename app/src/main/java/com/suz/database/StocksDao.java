package com.suz.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.suz.StoksSuz.Employee;

import java.util.List;

@Dao
public interface StocksDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStocks(List<Stocks> stocks);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMTS(List<MTS> mts);

    @Query("SELECT * from mts")
    List<MTS> getMts();

//SELECT * FROM `stocks` WHERE `c` <= '2021-10-31' AND `do` >= '2021-10-31' ORDER BY `stocks`.`do` DESC
    @Query("select * from stocks where `end` >= :date and `beginning` <= :date order by `end`asc")
    List<Stocks> getAlbums(String date);

    @Query("select * from stocks where `end` <= :date order by `end`desc")
    List<Stocks> getPast_promos(String date);

    @Query("select * from stocks where `beginning` >= :date order by `end`desc")
   List<Stocks> getFuture_promos(String date);

    @Query("select * from stocks")
    List<Stocks> getFuture();

    @Query("select * from stocks where `end` >= :date and `beginning` <= :date GROUP by `price`")
    List<Stocks> getEndPromo(String date);
    //SELECT DISTINCT `Promo price` FROM `stocks` WHERE `c` <= '2021-11-09' AND `do` >= '2021-11-09' ORDER BY `do` ASC
}

