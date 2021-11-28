package com.suz.Entry_and_promotions.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetroClient {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://user357.000webhostapp.com";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ServiseApi getApiService() {
        return getRetrofitInstance().create(ServiseApi.class);
    }
}
