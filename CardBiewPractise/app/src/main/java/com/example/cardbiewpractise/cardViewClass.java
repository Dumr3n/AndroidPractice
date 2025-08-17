package com.example.cardbiewpractise;

import android.widget.ImageView;
import android.widget.TextView;

public class cardViewClass {
    String title;
    int sportImg;
    public cardViewClass(int sportImg, String title) {
        this.sportImg = sportImg;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSportImg() {
        return sportImg;
    }

    public void setSportImg(int sportImg) {
        this.sportImg = sportImg;
    }
}
