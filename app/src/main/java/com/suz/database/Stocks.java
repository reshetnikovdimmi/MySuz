package com.suz.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Stocks {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "brand")
    private String brand;
    @ColumnInfo(name = "model")
    private String model;
    @ColumnInfo(name = "beginning")
    private String beginning;
    @ColumnInfo(name = "end")
    private String end;
    @ColumnInfo(name = "price")
    private String price;



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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Stocks() {
    }

    public Stocks(int id, String brand, String model, String beginning, String end, String price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.beginning = beginning;
        this.end = end;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "id=" + id +
                ", brand='" + brand +
                ", model='" + model +
                ", beginning='" + beginning +
                ", end='" + end +
                ", price='" + price +
                '}';
    }


}
