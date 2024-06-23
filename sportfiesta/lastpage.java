package com.example.sportfiesta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

public class lastpage extends AppCompatActivity {

TextView data,data2;
int id;
String uname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastpage);
        data = findViewById(R.id.tv_data);
        data2 = findViewById(R.id.tv_data2);


        SharedPreferences sharedPreferences = getSharedPreferences("sportsF",MODE_PRIVATE);
        id = sharedPreferences.getInt("uID",0);
        uname = sharedPreferences.getString("uName",null);
        showUSER();
        showGData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_about: {

                Intent i = new Intent(lastpage.this, aboutus.class);
                startActivity(i);
                return true;
            }
            case R.id.menu_logout:{

                Intent i = new Intent(lastpage.this,MainActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void showUSER()
    {
        DBHelper db = new DBHelper(lastpage.this);
        Cursor cursor = db.showUserData(id);
        if(cursor.moveToNext())
        {
            data.setText(cursor.getString(1)+" \n "+ cursor.getString(2)+" \n "+cursor.getString(3)+" \n "+cursor.getString(4));
        }
    }
    public void showGData()
    {
        DBHelper db = new DBHelper(lastpage.this);
        Cursor cursor = db.showGroundData(id);
        while (cursor.moveToNext())
        {
            data2.setText(cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)+"\n"+cursor.getString(5));
        }
    }
}