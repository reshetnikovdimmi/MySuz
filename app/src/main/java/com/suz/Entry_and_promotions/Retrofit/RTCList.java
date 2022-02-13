package com.suz.Entry_and_promotions.Retrofit;


import com.google.gson.annotations.SerializedName;
import com.suz.database.RTC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RTCList implements Serializable {
    @SerializedName("data")

    private List<RTC> data = new ArrayList<>();
    @SerializedName("success")

    private String success;

    public List<RTC> getData() {
        return data;
    }

    public void setData(ArrayList<RTC> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
