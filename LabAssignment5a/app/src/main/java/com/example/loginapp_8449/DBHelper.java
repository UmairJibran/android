package com.example.loginapp_8449;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
    MyDB.execSQL("create table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
    MyDB.execSQL("Drop table if exists users");
    }

    public Boolean insertData(String username, String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDB.insert("users",null, contentValues);
        return result != -1;
    }

    public boolean check_username(String username)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ?",new String[]{username});
        return cursor.getCount() > 0;
    }

    public boolean check_username_password(String username, String password)
    {
        SQLiteDatabase MyDb = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDb.rawQuery("Select * from users where username = ? and password = ?", new String[]{username,password});
        return cursor.getCount() > 0;
    }
}
