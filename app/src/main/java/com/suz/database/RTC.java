package com.suz.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
@Entity
public class RTC implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;
    @ColumnInfo(name = "TMC")
    @SerializedName("TMC")
    private String tmc;
    @ColumnInfo(name = "Model")
    @SerializedName("Model")
    private String model;
    @ColumnInfo(name = "Main_warehouse")
    @SerializedName("Main_warehouse")
    private String mainWarehouse;
    @SerializedName("Beethoven")
    @ColumnInfo(name = "Beethoven")
    private String beethoven;
    @SerializedName("Zyvaevsk")
    @ColumnInfo(name = "Zyvaevsk")
    private String zyvaevsk;
    @SerializedName("Bolsherechye")
    @ColumnInfo(name = "Bolsherechye")
    private String bolsherechye;
    @SerializedName("Cool")
    @ColumnInfo(name = "Cool")
    private String cool;
    @SerializedName("Moskalenki")
    @ColumnInfo(name = "Moskalenki")
    private String moskalenki;
    @SerializedName("Marianovka")
    @ColumnInfo(name = "Marianovka")
    private String marianovka;
    @SerializedName("Muromtsevo")
    @ColumnInfo(name = "Muromtsevo")
    private String muromtsevo;
    @SerializedName("Tavrichesky")
    @ColumnInfo(name = "Tavrichesky")
    private String tavrichesky;
    @SerializedName("Container")
    @ColumnInfo(name = "Container")
    private String container;
    @SerializedName("Bagration")
    @ColumnInfo(name = "Bagration")
    private String bagration;
    @SerializedName("Zavertyaeva")
    @ColumnInfo(name = "Zavertyaeva")
    private String zavertyaeva;
    @SerializedName("Neftezavodskaya")
    @ColumnInfo(name = "Neftezavodskaya")
    private String neftezavodskaya;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTmc() {
        return tmc;
    }

    public void setTmc(String tmc) {
        this.tmc = tmc;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMainWarehouse() {
        return mainWarehouse;
    }

    public void setMainWarehouse(String mainWarehouse) {
        this.mainWarehouse = mainWarehouse;
    }

    public String getBeethoven() {
        return beethoven;
    }

    public void setBeethoven(String beethoven) {
        this.beethoven = beethoven;
    }

    public String getZyvaevsk() {
        return zyvaevsk;
    }

    public void setZyvaevsk(String zyvaevsk) {
        this.zyvaevsk = zyvaevsk;
    }

    public String getBolsherechye() {
        return bolsherechye;
    }

    public void setBolsherechye(String bolsherechye) {
        this.bolsherechye = bolsherechye;
    }

    public String getCool() {
        return cool;
    }

    public void setCool(String cool) {
        this.cool = cool;
    }

    public String getMoskalenki() {
        return moskalenki;
    }

    public void setMoskalenki(String moskalenki) {
        this.moskalenki = moskalenki;
    }

    public String getMarianovka() {
        return marianovka;
    }

    public void setMarianovka(String marianovka) {
        this.marianovka = marianovka;
    }

    public String getMuromtsevo() {
        return muromtsevo;
    }

    public void setMuromtsevo(String muromtsevo) {
        this.muromtsevo = muromtsevo;
    }

    public String getTavrichesky() {
        return tavrichesky;
    }

    public void setTavrichesky(String tavrichesky) {
        this.tavrichesky = tavrichesky;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getBagration() {
        return bagration;
    }

    public void setBagration(String bagration) {
        this.bagration = bagration;
    }

    public String getZavertyaeva() {
        return zavertyaeva;
    }

    public void setZavertyaeva(String zavertyaeva) {
        this.zavertyaeva = zavertyaeva;
    }

    public String getNeftezavodskaya() {
        return neftezavodskaya;
    }

    public void setNeftezavodskaya(String neftezavodskaya) {
        this.neftezavodskaya = neftezavodskaya;
    }
}
