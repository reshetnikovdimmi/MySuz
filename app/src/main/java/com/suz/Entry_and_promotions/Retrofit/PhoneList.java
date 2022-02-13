package com.suz.Entry_and_promotions.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.suz.database.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {
    @SerializedName("data")
    @Expose
    private ArrayList<Phone> data = new ArrayList<>();
    @SerializedName("success")
    @Expose
    private String success;

    public List<Phone> getData() {
        return data;
    }

    public void setData(ArrayList<Phone> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }






}
