package com.suz.Entry_and_promotions.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.suz.database.SIM;

import java.util.ArrayList;
import java.util.List;

public class SIMList {
    @SerializedName("data")
    @Expose
    private List<SIM> data = new ArrayList<>();
    @SerializedName("success")
    @Expose
    private String success;

    public List<SIM> getData() {
        return data;
    }

    public void setData(List<SIM> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
