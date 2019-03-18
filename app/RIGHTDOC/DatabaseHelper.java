package com.example.carlmatch.RIGHTDOC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CarlMatch on 08/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "myhidtory.db";
    public static final String TABLE_NAME = "history";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "CLINIC";
    public static final String COL4 = "CA";
    public static final String COL5 = "EMAIl";
    public static final String COL6 = "ADVICE";

    SQLiteDatabase db;

    public DatabaseHelper (Context context){
        super(context,DATABASE_NAME,null,1);
    }

    public final String TABLE_CREATE = "create table history(ID Integer primary key not null," +
            "NAME text not null, CLINIC text not null, CA text not null,EMAIL text not null,ADVICE text not null)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);


    }


    public boolean addData(String name, String clinic, String ca, String email, String advice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2,name );
        contentValues.put(COL3, clinic);
        contentValues.put(COL4, ca);
        contentValues.put(COL5, email);
        contentValues.put(COL6, advice);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
        public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return  data;
    }
    public void deleteHistory(String name){
        this.getWritableDatabase().delete("history","NAME='"+name+"'",null);

    }
    public void updateHistory(String old_advice, String new_advice){
           this.getWritableDatabase().execSQL("UPDATE history set ADVICE='"+new_advice+"' WHERE ADVICE='"+old_advice+"'");
         }

}
