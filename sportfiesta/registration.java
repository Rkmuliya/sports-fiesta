package com.example.sportfiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    EditText fname,mobileno,fusername,fpassword;
    Button register;
    int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fname = findViewById(R.id.et_fname);
        mobileno = findViewById(R.id.et_mobileno);
        fusername = findViewById(R.id.et_reuname);
        fpassword = findViewById(R.id.et_password);
        register = findViewById(R.id.btn_register);

        SharedPreferences sharedPreferences = getSharedPreferences("sportsF",MODE_PRIVATE);
        id = sharedPreferences.getInt("uID",0);




       register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(registration.this);
                boolean stutas =  db.insertUser(fname.getText().toString(),mobileno.getText().toString(),fusername.getText().toString(),fpassword.getText().toString());

                if (stutas)
                    Toast.makeText(registration.this, "Inserted..", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(registration.this, "Not Inserted..", Toast.LENGTH_SHORT).show();


                if(fname.getText().toString().trim().length() > 0 && mobileno.getText().toString().trim().length() > 0 && fusername.getText().toString().trim().length() > 0 && fpassword.getText().toString().trim().length() > 0)
                {

                    Toast.makeText(registration.this, "Done", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(registration.this, "Enter Data", Toast.LENGTH_LONG).show();
                }

            }
        });







    }
}
