package com.suz.Entry_and_promotions.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.suz.database.MTS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MTSList implements Serializable {
    @SerializedName("data")

    private List<MTS> data = new ArrayList<>();
    @SerializedName("success")

    private String success;

    public  List<MTS> getData() {
        return data;
    }

    public void setData(ArrayList<MTS> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
