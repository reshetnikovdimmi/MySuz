package com.suz.Entry_and_promotions.Retrofit;

import com.suz.database.Stocks;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiseApi {
    @GET("/Android/Matrix_of_covers.php")
    Call<CoversList> getMyJSON();

    @GET("/Android/Matrix_of_covers.php")
    Observable<CoversList> getMyCovers();

    @GET("/Android/Segment_SIM_T2.php")
    Call<SIMList> getMySIM();

    @GET("/Android/Segment_SIM_MTS.php")
    Observable<MTSList> getMyMTS();

   // @GET("/Android/Droid_Suz.php")
   // Observable<EmploeeList> getMyEmploee();

    @GET("/Android/bonus_2022.php")
    Observable<StocksList> getMyStocks();
}
