package com.suz.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity
public class Phone implements Serializable {
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;
    @SerializedName("brend")
    @ColumnInfo(name = "brend")
    private String brend;
    @SerializedName("Main_warehouse")
    @ColumnInfo(name = "Main_warehouse")
    private String mainWarehouse;
    @SerializedName("Main_warehouse_Т2")
    @ColumnInfo(name = "Main_warehouse_Т2")
    private String mainWarehouseТ2;
    @SerializedName("Bagration")
    @ColumnInfo(name = "Bagration")
    private String bagration;
    @SerializedName("Beethoven")
    @ColumnInfo(name = "Beethoven")
    private String beethoven;
    @SerializedName("Zavertyaeva")
    @ColumnInfo(name = "Zavertyaeva")
    private String zavertyaeva;
    @SerializedName("ZyvaevskDIV")
    @ColumnInfo(name = "ZyvaevskDIV")
    private String zyvaevskDIV;
    @SerializedName("ZyvaevskT2")
    @ColumnInfo(name = "ZyvaevskT2")
    private String zyvaevskT2;
    @SerializedName("Neftezavodskaya")
    @ColumnInfo(name = "Neftezavodskaya")
    private String neftezavodskaya;
    @SerializedName("Bolsherechye")
    @ColumnInfo(name = "Bolsherechye")
    private String bolsherechye;
    @SerializedName("ZnamenskoyeMTS")
    @ColumnInfo(name = "ZnamenskoyeMTS")
    private String znamenskoyeMTS;
    @SerializedName("ZnamenskoMeg")
    @ColumnInfo(name = "ZnamenskoMeg")
    private String znamenskoMeg;
    @SerializedName("KrutinkaT2")
    @ColumnInfo(name = "KrutinkaT2")
    private String krutinkaT2;
    @SerializedName("Cool")
    @ColumnInfo(name = "Cool")
    private String cool;
    @SerializedName("MoskalenkiMTS")
    @ColumnInfo(name = "MoskalenkiMTS")
    private String moskalenkiMTS;
    @SerializedName("MoskalenkiT2")
    @ColumnInfo(name = "MoskalenkiT2")
    private String moskalenkiT2;
    @SerializedName("OdesskoDiv")
    @ColumnInfo(name = "OdesskoDiv")
    private String odesskoDiv;
    @SerializedName("BolsherecheMTS")
    @ColumnInfo(name = "BolsherecheMTS")
    private String bolsherecheMTS;
    @SerializedName("BigUki")
    @ColumnInfo(name = "BigUki")
    private String bigUki;
    @SerializedName("ZnamenskoeT2")
    @ColumnInfo(name = "ZnamenskoeT2")
    private String znamenskoeT2;
    @SerializedName("LuzinoT2")
    @ColumnInfo(name = "LuzinoT2")
    private String luzinoT2;
    @SerializedName("MarianovkaDIV")
    @ColumnInfo(name = "MarianovkaDIV")
    private String marianovkaDIV;
    @SerializedName("MarianovkaT2")
    @ColumnInfo(name = "MarianovkaT2")
    private String marianovkaT2;
    @SerializedName("MuromtsevoT2")
    @ColumnInfo(name = "MuromtsevoT2")
    private String muromtsevoT2;
    @SerializedName("MuromtsevoMTS")
    @ColumnInfo(name = "MuromtsevoMTS")
    private String muromtsevoMTS;
    @SerializedName("TavricheskoeT2")
    @ColumnInfo(name = "TavricheskoeT2")
    private String tavricheskoeT2;
    @SerializedName("TavricheskoyeMTS")
    @ColumnInfo(name = "TavricheskoyeMTS")
    private String tavricheskoyeMTS;
    @SerializedName("Container")
    @ColumnInfo(name = "Container")
    private String container;
    @SerializedName("Sherbakul_Biline")
    @ColumnInfo(name = "Sherbakul_Biline")
    private String sherbakulBiline;
    @SerializedName("KolosovkaT2")
    @ColumnInfo(name = "KolosovkaT2")
    private String kolosovkaT2;
    @SerializedName("ZyvaevskMTS")
    @ColumnInfo(name = "ZyvaevskMTS")
    private String zyvaevskMTS;
    @SerializedName("SedelnikovoT2")
    @ColumnInfo(name = "SedelnikovoT2")
    private String sedelnikovoT2;
    @SerializedName("Tevriz")
    @ColumnInfo(name = "Tevriz")
    private String tevriz;
    @SerializedName("Ust_iShim")
    @ColumnInfo(name = "Ust_iShim")
    private String ustIshim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getMainWarehouse() {
        return mainWarehouse;
    }

    public void setMainWarehouse(String mainWarehouse) {
        this.mainWarehouse = mainWarehouse;
    }

    public String getMainWarehouseТ2() {
        return mainWarehouseТ2;
    }

    public void setMainWarehouseТ2(String mainWarehouseТ2) {
        this.mainWarehouseТ2 = mainWarehouseТ2;
    }

    public String getBagration() {
        return bagration;
    }

    public void setBagration(String bagration) {
        this.bagration = bagration;
    }

    public String getBeethoven() {
        return beethoven;
    }

    public void setBeethoven(String beethoven) {
        this.beethoven = beethoven;
    }

    public String getZavertyaeva() {
        return zavertyaeva;
    }

    public void setZavertyaeva(String zavertyaeva) {
        this.zavertyaeva = zavertyaeva;
    }

    public String getZyvaevskDIV() {
        return zyvaevskDIV;
    }

    public void setZyvaevskDIV(String zyvaevskDIV) {
        this.zyvaevskDIV = zyvaevskDIV;
    }

    public String getZyvaevskT2() {
        return zyvaevskT2;
    }

    public void setZyvaevskT2(String zyvaevskT2) {
        this.zyvaevskT2 = zyvaevskT2;
    }

    public String getNeftezavodskaya() {
        return neftezavodskaya;
    }

    public void setNeftezavodskaya(String neftezavodskaya) {
        this.neftezavodskaya = neftezavodskaya;
    }

    public String getBolsherechye() {
        return bolsherechye;
    }

    public void setBolsherechye(String bolsherechye) {
        this.bolsherechye = bolsherechye;
    }

    public String getZnamenskoyeMTS() {
        return znamenskoyeMTS;
    }

    public void setZnamenskoyeMTS(String znamenskoyeMTS) {
        this.znamenskoyeMTS = znamenskoyeMTS;
    }

    public String getZnamenskoMeg() {
        return znamenskoMeg;
    }

    public void setZnamenskoMeg(String znamenskoMeg) {
        this.znamenskoMeg = znamenskoMeg;
    }

    public String getKrutinkaT2() {
        return krutinkaT2;
    }

    public void setKrutinkaT2(String krutinkaT2) {
        this.krutinkaT2 = krutinkaT2;
    }

    public String getCool() {
        return cool;
    }

    public void setCool(String cool) {
        this.cool = cool;
    }

    public String getMoskalenkiMTS() {
        return moskalenkiMTS;
    }

    public void setMoskalenkiMTS(String moskalenkiMTS) {
        this.moskalenkiMTS = moskalenkiMTS;
    }

    public String getMoskalenkiT2() {
        return moskalenkiT2;
    }

    public void setMoskalenkiT2(String moskalenkiT2) {
        this.moskalenkiT2 = moskalenkiT2;
    }

    public String getOdesskoDiv() {
        return odesskoDiv;
    }

    public void setOdesskoDiv(String odesskoDiv) {
        this.odesskoDiv = odesskoDiv;
    }

    public String getBolsherecheMTS() {
        return bolsherecheMTS;
    }

    public void setBolsherecheMTS(String bolsherecheMTS) {
        this.bolsherecheMTS = bolsherecheMTS;
    }

    public String getBigUki() {
        return bigUki;
    }

    public void setBigUki(String bigUki) {
        this.bigUki = bigUki;
    }

    public String getZnamenskoeT2() {
        return znamenskoeT2;
    }

    public void setZnamenskoeT2(String znamenskoeT2) {
        this.znamenskoeT2 = znamenskoeT2;
    }

    public String getLuzinoT2() {
        return luzinoT2;
    }

    public void setLuzinoT2(String luzinoT2) {
        this.luzinoT2 = luzinoT2;
    }

    public String getMarianovkaDIV() {
        return marianovkaDIV;
    }

    public void setMarianovkaDIV(String marianovkaDIV) {
        this.marianovkaDIV = marianovkaDIV;
    }

    public String getMarianovkaT2() {
        return marianovkaT2;
    }

    public void setMarianovkaT2(String marianovkaT2) {
        this.marianovkaT2 = marianovkaT2;
    }

    public String getMuromtsevoT2() {
        return muromtsevoT2;
    }

    public void setMuromtsevoT2(String muromtsevoT2) {
        this.muromtsevoT2 = muromtsevoT2;
    }

    public String getMuromtsevoMTS() {
        return muromtsevoMTS;
    }

    public void setMuromtsevoMTS(String muromtsevoMTS) {
        this.muromtsevoMTS = muromtsevoMTS;
    }

    public String getTavricheskoeT2() {
        return tavricheskoeT2;
    }

    public void setTavricheskoeT2(String tavricheskoeT2) {
        this.tavricheskoeT2 = tavricheskoeT2;
    }

    public String getTavricheskoyeMTS() {
        return tavricheskoyeMTS;
    }

    public void setTavricheskoyeMTS(String tavricheskoyeMTS) {
        this.tavricheskoyeMTS = tavricheskoyeMTS;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getSherbakulBiline() {
        return sherbakulBiline;
    }

    public void setSherbakulBiline(String sherbakulBiline) {
        this.sherbakulBiline = sherbakulBiline;
    }

    public String getKolosovkaT2() {
        return kolosovkaT2;
    }

    public void setKolosovkaT2(String kolosovkaT2) {
        this.kolosovkaT2 = kolosovkaT2;
    }

    public String getZyvaevskMTS() {
        return zyvaevskMTS;
    }

    public void setZyvaevskMTS(String zyvaevskMTS) {
        this.zyvaevskMTS = zyvaevskMTS;
    }

    public String getSedelnikovoT2() {
        return sedelnikovoT2;
    }

    public void setSedelnikovoT2(String sedelnikovoT2) {
        this.sedelnikovoT2 = sedelnikovoT2;
    }

    public String getTevriz() {
        return tevriz;
    }

    public void setTevriz(String tevriz) {
        this.tevriz = tevriz;
    }

    public String getUstIshim() {
        return ustIshim;
    }

    public void setUstIshim(String ustIshim) {
        this.ustIshim = ustIshim;
    }
}
