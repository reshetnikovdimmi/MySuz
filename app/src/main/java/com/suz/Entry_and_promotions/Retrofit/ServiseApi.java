package com.suz.Entry_and_promotions.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiseApi {


    @GET("/Android/Phone.php")
    Observable<PhoneList> getPhone();

    @GET("/Android/Segment_SIM_T2.php")
    Observable<SIMList> getMySIM();

    @GET("/Android/Segment_SIM_MTS.php")
    Observable<MTSList> getMyMTS();

    @GET("/Android/bonus_2022.php")
    Observable<StocksList> getMyStocks();

    @GET("/Android/RTC.php")
    Observable<RTCList> getMyRTC();

    @GET("/Android/Aksy.php")
    Observable<AksyList> getMyAksy();
}
