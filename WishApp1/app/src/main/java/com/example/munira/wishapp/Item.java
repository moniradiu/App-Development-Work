package com.example.munira.wishapp;

import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Munira on 24-Jan-18.
 */

public class Item {
    private String headText;
    private  String wiseText;


    public Item ()
    {

    }

    public Item(String headText, String wiseText) {
        this.headText = headText;
        this.wiseText = wiseText;
    }

    public String getHeadText() {
        return headText;
    }

    public void setHeadText(String headText) {
        this.headText = headText;
    }

    public String getWiseText() {
        return wiseText;
    }

    public void setWiseText(String wiseText) {
        this.wiseText = wiseText;
    }
}
