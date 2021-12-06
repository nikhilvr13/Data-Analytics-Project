package com.project.recommenderapp;

import com.google.gson.annotations.SerializedName;

public class Restaurant {

    String name;
    String cuisines;
    String rate;
    String type;
    String cost;
    String url;

    public Restaurant(String name, String url, String cuisines, String rate, String cost, String type) {
        this.name = name;
        this.cuisines = cuisines;
        this.rate = rate;
        this.type = type;
        this.cost = cost;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
