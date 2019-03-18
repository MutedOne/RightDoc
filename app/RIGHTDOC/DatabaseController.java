package com.example.carlmatch.RIGHTDOC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Acer on 3/9/2017.
 */

public class DatabaseController extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Registration.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_AGE = "age";

    SQLiteDatabase db;

    public static final String TABLE_CREATE = "create table Users(id integer primary key not null, " +
            " name text not null,username text not null, password text not null, email text not null, age integer not null)";

    public DatabaseController(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


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

    public void addUser(RegisteredController r) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from Users";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, r.getName());
        values.put(COLUMN_USERNAME, r.getUsername());
        values.put(COLUMN_PASSWORD, r.getPassword());
        values.put(COLUMN_EMAIL, r.getEmail());
        values.put(COLUMN_AGE, r.getAge());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select username,password from " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(username)) {
                    b = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return b;
    }
    public boolean updateAccount(String email,String password){
          db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PASSWORD,password);
        String where =COLUMN_EMAIL + "= ?";

        db.update(TABLE_NAME,values,where ,new String[]{email} );
        return  true;

    }

    public boolean sameUser(String username){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE "
                        + COLUMN_USERNAME + "='" + username  + "'" ,  null);
        if (c.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
