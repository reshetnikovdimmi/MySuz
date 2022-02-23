package com.suz.StoksSuz;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {


    public ArrayList<String> countries;

    public ArrayList<String> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    public Employee(ArrayList<String> countries) {
        this.countries = countries;
    }


    private String id,shop,pas;
    private String brand, model, beginning, end, price;

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

    public Employee(String brand, String model, String beginning, String end, String price) {
        this.brand = brand;
        this.model = model;
        this.beginning = beginning;
        this.end = end;
        this.price = price;
    }

    public Employee(Employee employee) {
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public Employee(String item, String shop) {
        this.pas = shop;
        this.shop = item;
    }

    public Employee(String id, String shop, String pas) {
        this.id = id;
        this.shop = shop;
        this.pas = pas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getPasword() {
        return pas;
    }

    public void setPasword(String pasword) {
        this.pas = pasword;
    }
}
