package com.example.sportfiesta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DBHelper extends SQLiteOpenHelper {


    private SQLiteDatabase db;
    private int oldVersion;
    private int newVersion;

    public DBHelper(Context context) {
        super(context, "spofi", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE USER_DATA(UID INTEGER PRIMARY KEY,FULLNAME TEXT,MOBILENO TEXT,USERNAME TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE GROUND_DATA(ID INTEGER PRIMARY KEY,UID INTEGER,VIRATG TEXT,MAHIG TEXT,DATE TEXT,TIME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS USER_DATA");
        db.execSQL("DROP TABLE IF EXISTS GROUND_DATA");
        onCreate(db);
    }

    boolean insertUser(String fullname,String mobileno,String username,String passwors)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FULLNAME",fullname);
        cv.put("MOBILENO",mobileno);
        cv.put("USERNAME",username);
        cv.put("PASSWORD",passwors);


        long stutas = db.insert("USER_DATA",null,cv);

        if(stutas == -1)
            return false;
        else
            return true;
    }



   /* Cursor Search(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.query("member_data",null,"ID=?",new String[]{String.valueOf(id)})
    }*/

    Cursor dataLogin(String user,String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from USER_DATA where USERNAME=? and PASSWORD=?",new String[]{user,pass});
        return cursor;
    }

   boolean insertGround(int id,String gvirat,String gmahi,String date,String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("UID",id);
        cv.put("VIRATG",gvirat);
        cv.put("MAHIG",gmahi);
        cv.put("DATE",date);
        cv.put("TIME",time);
        long status = db.insert("GROUND_DATA",null,cv);
        if(status == -1)
            return false;
        else
            return true;
    }

    Cursor showUserData(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.query("USER_DATA",null,"UID=?",new String[]{String.valueOf(id)},null,null,null);
        return cursor;
    }
    Cursor showGroundData(int uid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("GROUND_DATA", null, "UID=?", new String[]{String.valueOf(uid)}, null,null,null);
        return cursor;
    }
}
