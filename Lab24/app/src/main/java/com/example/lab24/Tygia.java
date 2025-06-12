package com.example.lab24;

import android.graphics.Bitmap;

public class Tygia {
    private String type;
    private String imageurl;
    private Bitmap bitmap;
    private String buyCash;
    private String buyCheck;
    private String sellCash;
    private String sellCheck;

    public Tygia() {
    }

    public Tygia(String type, String imageurl, Bitmap bitmap, String buyCash, String buyCheck, String sellCash, String sellCheck) {
        this.type = type;
        this.imageurl = imageurl;
        this.bitmap = bitmap;
        this.buyCash = buyCash;
        this.buyCheck = buyCheck;
        this.sellCash = sellCash;
        this.sellCheck = sellCheck;
    }

    public String getType() {
        return type;
    }

    public String getImageurl() {
        return imageurl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getBuyCash() {
        return buyCash;
    }

    public String getBuyCheck() {
        return buyCheck;
    }

    public String getSellCash() {
        return sellCash;
    }

    public String getSellCheck() {
        return sellCheck;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setBuyCash(String buyCash) {
        this.buyCash = buyCash;
    }

    public void setBuyCheck(String buyCheck) {
        this.buyCheck = buyCheck;
    }

    public void setSellCash(String sellCash) {
        this.sellCash = sellCash;
    }

    public void setSellCheck(String sellCheck) {
        this.sellCheck = sellCheck;
    }
}