package com.mirea.kt.datastorageapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlantDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "plants.db";
    private static final int DATABASE_VERSION = 1;

    public PlantDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE plants (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "variety TEXT, " +
                "isGreenhousePlant INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS plants");
        onCreate(db);
    }
}