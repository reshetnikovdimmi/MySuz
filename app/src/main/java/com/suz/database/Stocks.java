package com.suz.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stocks implements Serializable{
    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @SerializedName("brand")
    @ColumnInfo(name = "brand")
    private String brand;
    @SerializedName("model")
    @ColumnInfo(name = "model")
    private String model;
    @SerializedName("price")
    @ColumnInfo(name = "price")
    private String price;
    @SerializedName("promo")
    @ColumnInfo(name = "promo")
    private String promo;
    @SerializedName("beginning")
    @ColumnInfo(name = "beginning")
    private String beginning;
    @SerializedName("end")
    @ColumnInfo(name = "end")
    private String end;
    @SerializedName("marwel")
    @ColumnInfo(name = "marwel")
    private String marwel;
    @SerializedName("tfn")
    @ColumnInfo(name = "tfn")
    private String tfn;
    @SerializedName("vvp")
    @ColumnInfo(name = "vvp")
    private String vvp;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getMarwel() {
        return marwel;
    }

    public void setMarwel(String marwel) {
        this.marwel = marwel;
    }

    public String getTfn() {
        return tfn;
    }

    public void setTfn(String tfn) {
        this.tfn = tfn;
    }

    public String getVvp() {
        return vvp;
    }

    public void setVvp(String vvp) {
        this.vvp = vvp;
    }



}
