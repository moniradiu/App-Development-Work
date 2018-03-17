package com.example.munira.notebooklist;

import java.util.Date;

/**
 * Created by Munira on 16-Feb-18.
 */

public class Item{

private String wishString;
private String  amountInteger;
private String  noteDate;

//default

    public Item() {

    }

    public Item(String wishString, String amountInteger, String  noteDate) {
        this.wishString = wishString;
        this.amountInteger = amountInteger;
        this.noteDate = noteDate;
    }

    public String getWishString() {
        return wishString;
    }

    public void setWishString(String wishString) {
        this.wishString = wishString;
    }

    public String getAmountInteger() {
        return amountInteger;
    }

    public void setAmountInteger(String amountInteger) {
        this.amountInteger = amountInteger;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }
}
