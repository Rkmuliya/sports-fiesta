package com.example.sportfiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView reg;
    String user, pass,uname;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.ed_Username);
        password = findViewById(R.id.ed_password);
        login = findViewById(R.id.btn_login);
        reg = findViewById(R.id.tv_register);



/*
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBHelper db = new DBHelper(MainActivity.this);
                    user = username.getText().toString();
                    pass = password.getText().toString();
                    if(user.equals("") && pass.equals("") )
                    {
                        Boolean crsr = db.dataLogin(user,pass);

                        if(crsr == true) {
                            Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, grounds.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(getApplicationContext(), "Invalid ", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(), " Enter the Username And Password", Toast.LENGTH_SHORT).show();
                }
            });*/


    }

    public void GoToReg(View view) {
        Intent i = new Intent(MainActivity.this, registration.class);
        startActivity(i);
    }

    public void checkLoginData(View view) {
        DBHelper db = new DBHelper(MainActivity.this);

        user = username.getText().toString();
        pass = password.getText().toString();

        if (user.equals("") && pass.equals(""))
            Toast.makeText(getApplicationContext(), "Enter Data", Toast.LENGTH_SHORT).show();
        else {
            Cursor cursor = db.dataLogin(user, pass);
            if(cursor.moveToNext()) {
               id = cursor.getInt(0);
                uname = cursor.getString(3);
            }

            if (cursor.getCount() > 0) {
                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();

                SharedPreferences sp= getSharedPreferences("sportsF",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putInt("uID",id);
                editor.putString("uName",uname);
                editor.commit();

                Intent i = new Intent(MainActivity.this, grounds.class);
                startActivity(i);
            } else
                Toast.makeText(getApplicationContext(), "Invalid username or password ", Toast.LENGTH_SHORT).show();

        }

    }
   /* @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("do you want to exit ? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }*/
}
