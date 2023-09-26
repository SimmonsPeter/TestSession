package com.petersimmons.testsession.models;

import java.text.SimpleDateFormat;
import java.util.List;

public class Inscription {

    private String nas;
    private SimpleDateFormat date;
    private List<Cours> cours;


    //Getters & Setters

    public String getNas() {
        return nas;
    }

    public void setNas(String nas) {
        this.nas = nas;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
