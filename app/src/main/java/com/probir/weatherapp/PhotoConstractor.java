package com.probir.weatherapp;

public class PhotoConstractor {
    private int img;

    //Constractor------------------
    public PhotoConstractor(int img) {
        this.img = img;
    }

    public PhotoConstractor() {
    }

    //getter method-----------------
    public int getImg() {
        return img;
    }

    //Setter method-------------------
    public void setImg(int img) {
        this.img = img;
    }
}
