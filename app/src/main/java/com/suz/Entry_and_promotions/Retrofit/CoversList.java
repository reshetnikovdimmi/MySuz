package com.suz.Entry_and_promotions.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.suz.database.Covers;

import java.util.ArrayList;
import java.util.List;

//@Generated("jsonschema2pojo")

public class CoversList {
    @SerializedName("data")
    @Expose
    private ArrayList<Covers> data = new ArrayList<>();
    @SerializedName("success")
    @Expose
    private String success;

    public  ArrayList<Covers> getData() {
        return data;
    }

    public void setData(ArrayList<Covers> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }






}
