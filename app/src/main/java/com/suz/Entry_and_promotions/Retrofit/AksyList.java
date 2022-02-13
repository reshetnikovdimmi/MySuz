package com.suz.Entry_and_promotions.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.suz.database.Aksy;

import java.util.ArrayList;
import java.util.List;

public class AksyList {
    @SerializedName("data")
    @Expose
    private ArrayList<Aksy> data = new ArrayList<>();
    @SerializedName("success")
    @Expose
    private String success;

    public List<Aksy> getData() {
        return data;
    }

    public void setData(ArrayList<Aksy> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
