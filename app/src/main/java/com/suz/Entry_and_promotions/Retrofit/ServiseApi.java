package com.suz.Entry_and_promotions.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiseApi {
    @GET("/Android/Matrix_of_covers.php")
    Call<CoversList> getMyJSON();
}
