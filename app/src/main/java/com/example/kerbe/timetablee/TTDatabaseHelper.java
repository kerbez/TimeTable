package com.example.kerbe.timetablee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kerbe on 30.11.2017.
 */

public class TTDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "tt";
    private static final int DB_VERSION = 2;

    TTDatabaseHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        Log.d("constructor", "hey");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DANDW  ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "DESCRIPTION TEXT, "
                + "DAY TEXT, "
                + "HOUR TEXT, "
                + "C TEXT )"
        );
        Log.d("hey", "onC");
           // updateMyDatabase(db, 0, DB_VERSION);


    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int dbVersion) {
        /*if (oldVersion < 1) {
            Log.d("hey", "oldV < 1");
            db.execSQL("CREATE TABLE DANDW  ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "DESCRIPTION TEXT, "
                    + "DAY TEXT, "
                    + "HOUR TEXT, "
                    + "C TEXT )"
            );
            //insertTT("web", "Monday", "10:00", "1");
        }*/
        /*insertTT("lala", "Monday", "10:00", "1");
        if(oldVersion < 2){

            Log.d("hey", "oldV < 2");
            //db.execSQL("DROP TABLE IF EXISTS " + "DANDW");
        }*/
    }

    public void insertTT(String des, String day, String hour, String c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ttValues = new ContentValues();
        ttValues.put("DESCRIPTION", des);
        ttValues.put("DAY", day);
        ttValues.put("HOUR", hour);
        ttValues.put("C", c);
        db.insert("DANDW", null, ttValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("hey", "onU");
        //updateMyDatabase(db, oldVersion, newVersion);
        //db.execSQL("DROP TABLE IF EXISTS " + "DANDW");
        //onCreate(db);

    }
    public void delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("DANDW",
                "_id = ?",
                new String[] {id});

        db.close();
    }
    public DandW getDandW(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("DANDW", new String[] { "_id",
                        "DESCRIPTION", "DAY", "HOUR", "C" }, "_id = ?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        DandW contact = new DandW(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

        return contact;
    }

    public List<DandW> getAllDandW() {
        List<DandW> DWList = new ArrayList<DandW>();
// Select All Query
        String selectQuery = "SELECT * FROM DANDW";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DandW dw = new DandW();
                dw.setId(Integer.parseInt(cursor.getString(0)));
                dw.setDes(cursor.getString(1));
                dw.setDay(cursor.getString(2));
                dw.setHour(cursor.getString(3));
                dw.setC(cursor.getString(4));
// Adding contact to list
                DWList.add(dw);
            } while (cursor.moveToNext());
        }
// return contact list
        return DWList;
    }
    public int getDWCount() {
        String countQuery = "SELECT * FROM DANDW";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int c = cursor.getCount();
        cursor.close();
// return count
        return c;
    }
}
