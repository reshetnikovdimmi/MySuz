package com.suz.Entry_and_promotions;

import com.google.gson.annotations.SerializedName;

public class Data<T> {
    @SerializedName("data")
    public T response;
}
