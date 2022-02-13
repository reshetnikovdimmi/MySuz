package com.suz.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class SIM implements Serializable {
    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @SerializedName("Nomenclature")
    @ColumnInfo(name = "Nomenclature")
    private String Nomenclature;
    @SerializedName("TMC")
    @ColumnInfo(name = "TMC")
    private String TMC;
    @SerializedName("Brand")
    @ColumnInfo(name = "Brand")
    private String Brand;
    @SerializedName("Main_SIM_Warehouse")
    @ColumnInfo(name = "Main_SIM_Warehouse")
    private String Main_SIM_Warehouse;
    @SerializedName("Bagration")
    @ColumnInfo(name = "Bagration")
    private String Bagration;
    @SerializedName("Beethoven")
    @ColumnInfo(name = "Beethoven")
    private String Beethoven;
    @SerializedName("Zyvaevsk")
    @ColumnInfo(name = "Zyvaevsk")
    private String Zyvaevsk;
    @SerializedName("Cool")
    @ColumnInfo(name = "Cool")
    private String Cool;
    @SerializedName("Moskalenki")
    @ColumnInfo(name = "Moskalenki")
    private String Moskalenki;
    @SerializedName("Odessa")
    @ColumnInfo(name = "Odessa")
    private String Odessa;
    @SerializedName("Znamenskoe")
    @ColumnInfo(name = "Znamenskoe")
    private String Znamenskoe;
    @SerializedName("Marianovka")
    @ColumnInfo(name = "Marianovka")
    private String Marianovka;
    @SerializedName("Muromtsevo")
    @ColumnInfo(name = "Muromtsevo")
    private String Muromtsevo;
    @SerializedName("Tavrichesky")
    @ColumnInfo(name = "Tavrichesky")
    private String Tavrichesky;
    @SerializedName("Container")
    @ColumnInfo(name = "Container")
    private String Container;
    @SerializedName("Kolosovka")
    @ColumnInfo(name = "Kolosovka")
    private String Kolosovka;
    @SerializedName("Sedelnikovo")
    @ColumnInfo(name = "Sedelnikovo")
    private String Sedelnikovo;
    @SerializedName("Tevriz")
    @ColumnInfo(name = "Tevriz")
    private String Tevriz;
    @SerializedName("Ust_Ishim")
    @ColumnInfo(name = "Ust_Ishim")
    private String Ust_Ishim;
    @SerializedName("Neftezavodskaya")
    @ColumnInfo(name = "Neftezavodskaya")
    private String Neftezavodskaya;
    @SerializedName("Zavertyaeva")
    @ColumnInfo(name = "Zavertyaeva")
    private String Zavertyaeva;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomenclature() {
        return Nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        Nomenclature = nomenclature;
    }

    public String getTMC() {
        return TMC;
    }

    public void setTMC(String TMC) {
        this.TMC = TMC;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getMain_SIM_Warehouse() {
        return Main_SIM_Warehouse;
    }

    public void setMain_SIM_Warehouse(String main_SIM_Warehouse) {
        Main_SIM_Warehouse = main_SIM_Warehouse;
    }

    public String getBagration() {
        return Bagration;
    }

    public void setBagration(String bagration) {
        Bagration = bagration;
    }

    public String getBeethoven() {
        return Beethoven;
    }

    public void setBeethoven(String beethoven) {
        Beethoven = beethoven;
    }

    public String getZyvaevsk() {
        return Zyvaevsk;
    }

    public void setZyvaevsk(String zyvaevsk) {
        Zyvaevsk = zyvaevsk;
    }

    public String getCool() {
        return Cool;
    }

    public void setCool(String cool) {
        Cool = cool;
    }

    public String getMoskalenki() {
        return Moskalenki;
    }

    public void setMoskalenki(String moskalenki) {
        Moskalenki = moskalenki;
    }

    public String getOdessa() {
        return Odessa;
    }

    public void setOdessa(String odessa) {
        Odessa = odessa;
    }

    public String getZnamenskoe() {
        return Znamenskoe;
    }

    public void setZnamenskoe(String znamenskoe) {
        Znamenskoe = znamenskoe;
    }

    public String getMarianovka() {
        return Marianovka;
    }

    public void setMarianovka(String marianovka) {
        Marianovka = marianovka;
    }

    public String getMuromtsevo() {
        return Muromtsevo;
    }

    public void setMuromtsevo(String muromtsevo) {
        Muromtsevo = muromtsevo;
    }

    public String getTavrichesky() {
        return Tavrichesky;
    }

    public void setTavrichesky(String tavrichesky) {
        Tavrichesky = tavrichesky;
    }

    public String getContainer() {
        return Container;
    }

    public void setContainer(String container) {
        Container = container;
    }

    public String getKolosovka() {
        return Kolosovka;
    }

    public void setKolosovka(String kolosovka) {
        Kolosovka = kolosovka;
    }

    public String getSedelnikovo() {
        return Sedelnikovo;
    }

    public void setSedelnikovo(String sedelnikovo) {
        Sedelnikovo = sedelnikovo;
    }

    public String getTevriz() {
        return Tevriz;
    }

    public void setTevriz(String tevriz) {
        Tevriz = tevriz;
    }

    public String getUst_Ishim() {
        return Ust_Ishim;
    }

    public void setUst_Ishim(String ust_Ishim) {
        Ust_Ishim = ust_Ishim;
    }

    public String getNeftezavodskaya() {
        return Neftezavodskaya;
    }

    public void setNeftezavodskaya(String neftezavodskaya) {
        Neftezavodskaya = neftezavodskaya;
    }

    public String getZavertyaeva() {
        return Zavertyaeva;
    }

    public void setZavertyaeva(String zavertyaeva) {
        Zavertyaeva = zavertyaeva;
    }


}
