package com.example.munira.notebooklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Munira on 02-Mar-18.
 */

public class ArgentDatabaseHelper extends SQLiteOpenHelper {

   final private String TABLE_NAME="argent_table";
   final private String ARGENT_ID="id";
   final private String ARGENT_TITLE="title";
   final private String ARGENT_AMOUNT="amount";
   final private String ARGENT_DATE="date";

    /*next time use for create context*/
    Context context;

    public ArgentDatabaseHelper(Context context) {
        //step:1 database,
        super(context,"argentDB", null, 1);
        // contxt, db_name, factory, db version
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //step:2 create table
        String sql= "CREATE TABLE " + TABLE_NAME + " (" +
                ARGENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ARGENT_TITLE + " TEXT," +
                ARGENT_AMOUNT + " TEXT," +
                ARGENT_DATE + " INTEGER)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //step:3 drop table
        String sql = "drop table if exists" + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }


    public void insertWish (String title,String amount){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ARGENT_TITLE, title);
        values.put(ARGENT_AMOUNT, amount);
        db.insert(TABLE_NAME, null, values);
        db.close();



    }


    public List<Item> getAllData(){

        List<Item> itemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()){

            while (cursor.moveToNext()){

                String title = cursor.getString(0);
                String amount = cursor.getString(1);
                String date = cursor.getString(1);

                Item item = new Item();
                item.setWishString(title);
                item.setAmountInteger(amount);
                item.setNoteDate(date);
                itemList.add(item);
            }
        }

        return itemList;
    }


    public void deleteRow(String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME+ " WHERE "+ ARGENT_TITLE+ "='" + value+ARGENT_TITLE+ "='" + value+"'");
        db.close();
    }
}
