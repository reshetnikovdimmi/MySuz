package com.suz.Entry_and_promotions.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.suz.database.Stocks;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StocksList implements Serializable{

        @SerializedName("data")

        private List<Stocks> data = new ArrayList<>();
        @SerializedName("success")

        private String success;

        public List<Stocks> getData() {
            return data;
        }

        public void setData(ArrayList<Stocks> data) {
            this.data = data;
        }

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }
    }

