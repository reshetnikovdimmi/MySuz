package com.suz.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Covers {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "Model_allocation")
    private String Model_allocation;
    @ColumnInfo(name = "TMC")
    private String TMC;
    @ColumnInfo(name = "Bagration")
    private String Bagration;
    @ColumnInfo(name = "Beethoven")
    private String Beethoven;
    @ColumnInfo(name = "Zavertyaeva")
    private String Zavertyaeva;
    @ColumnInfo(name = "Zyvaevsk")
    private String Zyvaevsk;
    @ColumnInfo(name = "Neftezavodskaya")
    private String Neftezavodskaya;
    @ColumnInfo(name = "Bolsherechye")
    private String Bolsherechye;
    @ColumnInfo(name = "Cool")
    private String Cool;
    @ColumnInfo(name = "Moskalenki")
    private String Moskalenki;
    @ColumnInfo(name = "Marianovka")
    private String Marianovka;
    @ColumnInfo(name = "Muromtsevo")
    private String Muromtsevo;
    @ColumnInfo(name = "Tavrichesky")
    private String Tavrichesky;
    @ColumnInfo(name = "Container")
    private String Container;

    public Covers() {
    }

    public Covers(int id, String model_allocation, String TMC, String bagration, String beethoven, String zavertyaeva, String zyvaevsk, String neftezavodskaya, String bolsherechye, String cool, String moskalenki, String marianovka, String muromtsevo, String tavrichesky, String container) {
        this.id = id;
        this.Model_allocation = model_allocation;
        this.TMC = TMC;
        this.Bagration = bagration;
        this.Beethoven = beethoven;
        this.Zavertyaeva = zavertyaeva;
        this.Zyvaevsk = zyvaevsk;
        this.Neftezavodskaya = neftezavodskaya;
        this.Bolsherechye = bolsherechye;
        this.Cool = cool;
        this.Moskalenki = moskalenki;
        this.Marianovka = marianovka;
        this.Muromtsevo = muromtsevo;
        this.Tavrichesky = tavrichesky;
        this.Container = container;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel_allocation() {
        return Model_allocation;
    }

    public void setModel_allocation(String Model_allocation) {
        this.Model_allocation = Model_allocation;
    }

    public String getTMC() {
        return TMC;
    }

    public void setTMC(String TMC) {
        this.TMC = TMC;
    }

    public String getBagration() {
        return Bagration;
    }

    public void setBagration(String bagration) {
        this.Bagration = bagration;
    }

    public String getBeethoven() {
        return Beethoven;
    }

    public void setBeethoven(String beethoven) {
        this.Beethoven = beethoven;
    }

    public String getZavertyaeva() {
        return Zavertyaeva;
    }

    public void setZavertyaeva(String zavertyaeva) {
        this.Zavertyaeva = zavertyaeva;
    }

    public String getZyvaevsk() {
        return Zyvaevsk;
    }

    public void setZyvaevsk(String zyvaevsk) {
        this.Zyvaevsk = zyvaevsk;
    }

    public String getNeftezavodskaya() {
        return Neftezavodskaya;
    }

    public void setNeftezavodskaya(String neftezavodskaya) {
        this.Neftezavodskaya = neftezavodskaya;
    }

    public String getBolsherechye() {
        return Bolsherechye;
    }

    public void setBolsherechye(String bolsherechye) {
        this.Bolsherechye = bolsherechye;
    }

    public String getCool() {
        return Cool;
    }

    public void setCool(String cool) {
        this.Cool = cool;
    }

    public String getMoskalenki() {
        return Moskalenki;
    }

    public void setMoskalenki(String moskalenki) {
        this.Moskalenki = moskalenki;
    }

    public String getMarianovka() {
        return Marianovka;
    }

    public void setMarianovka(String marianovka) {
        this.Marianovka = marianovka;
    }

    public String getMuromtsevo() {
        return Muromtsevo;
    }

    public void setMuromtsevo(String muromtsevo) {
        this.Muromtsevo = muromtsevo;
    }

    public String getTavrichesky() {
        return Tavrichesky;
    }

    public void setTavrichesky(String tavrichesky) {
        this.Tavrichesky = tavrichesky;
    }

    public String getContainer() {
        return Container;
    }

    public void setContainer(String container) {
        this.Container = container;
    }

    @Override
    public String toString() {
        return "Covers{" +
                "id=" + id +
                ", model_allocation='" + Model_allocation + '\'' +
                ", TMC='" + TMC + '\'' +
                ", bagration='" + Bagration + '\'' +
                ", beethoven='" + Beethoven + '\'' +
                ", zavertyaeva='" + Zavertyaeva + '\'' +
                ", zyvaevsk='" + Zyvaevsk + '\'' +
                ", neftezavodskaya='" + Neftezavodskaya + '\'' +
                ", bolsherechye='" + Bolsherechye + '\'' +
                ", cool='" + Cool + '\'' +
                ", moskalenki='" + Moskalenki + '\'' +
                ", marianovka='" + Marianovka + '\'' +
                ", muromtsevo='" + Muromtsevo + '\'' +
                ", tavrichesky='" + Tavrichesky + '\'' +
                ", container='" + Container + '\'' +
                '}';
    }
}
