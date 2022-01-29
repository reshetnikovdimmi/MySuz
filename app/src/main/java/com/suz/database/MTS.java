package com.suz.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MTS implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;
    @ColumnInfo(name = "rainbow_rates")
    @SerializedName("rainbow_rates")
    private String rainbow_rates;
    @ColumnInfo(name = "MTS_tariffs")
    @SerializedName("MTS_tariffs")
    private String MTS_tariffs;
    @ColumnInfo(name = "Main_warehouse")
    @SerializedName("Main_warehouse")
    private String Main_warehouse;
    @ColumnInfo(name = "Main_SIM_Warehouse")
    @SerializedName("Main_SIM_Warehouse")
    private String Main_SIM_Warehouse;
    @ColumnInfo(name = "Zyvaevsk_DIV")
    @SerializedName("Zyvaevsk_DIV")
    private String Zyvaevsk_DIV;
    @ColumnInfo(name = "Znamenskoe")
    @SerializedName("Znamenskoe")
    private String Znamenskoe;
    @ColumnInfo(name = "Moskalenki")
    @SerializedName("Moskalenki")
    private String Moskalenki;
    @ColumnInfo(name = "Odessa")
    @SerializedName("Odessa")
    private String Odessa;
    @ColumnInfo(name = "Bolsherechye")
    @SerializedName("Bolsherechye")
    private String Bolsherechye;
    @ColumnInfo(name = "Big_Uki")
    @SerializedName("Big_Uki")
    private String Big_Uki;
    @ColumnInfo(name = "Muromtsevo")
    @SerializedName("Muromtsevo")
    private String Muromtsevo;
    @ColumnInfo(name = "Tavrichesky")
    @SerializedName("Tavrichesky")
    private String Tavrichesky;
    @ColumnInfo(name = "Zyvaevsk")
    @SerializedName("Zyvaevsk")
    private String Zyvaevsk;
    @ColumnInfo(name = "Ust_Ishim")
    @SerializedName("Ust_Ishim")
    private String Ust_Ishim;
    @ColumnInfo(name = "Cool")
    @SerializedName("Cool")
    private String Cool;
    @ColumnInfo(name = "Marianovka")
    @SerializedName("Marianovka")
    private String Marianovka;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRainbow_rates() {
        return rainbow_rates;
    }

    public void setRainbow_rates(String rainbow_rates) {
        this.rainbow_rates = rainbow_rates;
    }

    public String getMTS_tariffs() {
        return MTS_tariffs;
    }

    public void setMTS_tariffs(String MTS_tariffs) {
        this.MTS_tariffs = MTS_tariffs;
    }

    public String getMain_warehouse() {
        return Main_warehouse;
    }

    public void setMain_warehouse(String main_warehouse) {
        Main_warehouse = main_warehouse;
    }

    public String getMain_SIM_Warehouse() {
        return Main_SIM_Warehouse;
    }

    public void setMain_SIM_Warehouse(String main_SIM_Warehouse) {
        Main_SIM_Warehouse = main_SIM_Warehouse;
    }

    public String getZyvaevsk_DIV() {
        return Zyvaevsk_DIV;
    }

    public void setZyvaevsk_DIV(String zyvaevsk_DIV) {
        Zyvaevsk_DIV = zyvaevsk_DIV;
    }

    public String getZnamenskoe() {
        return Znamenskoe;
    }

    public void setZnamenskoe(String znamenskoe) {
        Znamenskoe = znamenskoe;
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

    public String getBolsherechye() {
        return Bolsherechye;
    }

    public void setBolsherechye(String bolsherechye) {
        Bolsherechye = bolsherechye;
    }

    public String getBig_Uki() {
        return Big_Uki;
    }

    public void setBig_Uki(String big_Uki) {
        Big_Uki = big_Uki;
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

    public String getZyvaevsk() {
        return Zyvaevsk;
    }

    public void setZyvaevsk(String zyvaevsk) {
        Zyvaevsk = zyvaevsk;
    }

    public String getUst_Ishim() {
        return Ust_Ishim;
    }

    public void setUst_Ishim(String ust_Ishim) {
        Ust_Ishim = ust_Ishim;
    }

    public String getCool() {
        return Cool;
    }

    public void setCool(String cool) {
        Cool = cool;
    }

    public String getMarianovka() {
        return Marianovka;
    }

    public void setMarianovka(String marianovka) {
        Marianovka = marianovka;
    }


}
