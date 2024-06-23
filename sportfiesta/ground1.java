package com.example.sportfiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class ground1 extends AppCompatActivity {

    Button book;
    EditText cdate;
    CheckBox sixam,eigam,tenam,tvelpm,twopm,fourpm,
            sixpm,eigpm,tenpm,tvelam,twoam,fouram;
    String viratground="";
    String getTime="";
    int id;
    String uname;

    int year,month,day;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground1);
        cdate = findViewById(R.id.et_date2);



        book = findViewById(R.id.btn_book);
        sixam = findViewById(R.id.cb_6t8am);
        eigam = findViewById(R.id.cb_8to10am);
        tenam = findViewById(R.id.cb_10to12ampm);
        tvelpm = findViewById(R.id.cb_12to2pm);
        twopm = findViewById(R.id.cb_2to4pm);
        fourpm = findViewById(R.id.cb_4to6pm);
        sixpm = findViewById(R.id.cb_6to8pm);
        eigpm = findViewById(R.id.cb_8to10pm);
        tenpm = findViewById(R.id.cb_10to12pmam);
        tvelam = findViewById(R.id.cb_12to2am);
        twoam = findViewById(R.id.cb_2to4am);
        fouram = findViewById(R.id.cb_4to6am);

        SharedPreferences sharedPreferences = getSharedPreferences("sportsF",MODE_PRIVATE);
        id = sharedPreferences.getInt("uID",0);
        uname = sharedPreferences.getString("uName",null);

        Intent i = getIntent();
        viratground = i.getStringExtra("Gvirat");

        Calendar cl = Calendar.getInstance();
        cdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                year = cl.get(Calendar.YEAR);
                month = cl.get(Calendar.MONTH);
                day = cl.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(ground1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        cdate.setText(dayOfMonth + "/" + (month+1) + "/" + year);

                    }
                },year,month,day);
                dpd.show();
            }
        });




        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(ground1.this);

                if (sixam.isChecked()) {
                    getTime = getTime + " / " + sixam.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);


                    startActivity(i);
                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (eigam.isChecked()) {

                    getTime = getTime + " / " + eigam.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);

                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (tenam.isChecked()) {

                    getTime = getTime + " / " + tenam.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);
                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (tvelpm.isChecked()) {

                    getTime = getTime + " / " + tvelpm.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);
                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (twopm.isChecked()) {
                    getTime = getTime + " / " + twopm.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);

                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (fourpm.isChecked()) {
                    getTime = getTime + " / " + fourpm.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);

                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (sixpm.isChecked()) {
                    getTime = getTime + " / " + sixpm.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);


                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (eigpm.isChecked()) {
                    getTime = getTime + " / " + eigpm.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);

                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (tenpm.isChecked()) {
                    getTime = getTime + " / " + tenpm.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);

                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (tvelam.isChecked()) {
                    getTime = getTime + " / " + tvelam.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);

                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (twoam.isChecked()) {
                    getTime = getTime + " / " + twoam.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);

                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                if (fouram.isChecked()) {

                    getTime = getTime + " / " + fouram.getText().toString();
                    Intent i = new Intent(getApplicationContext(), lastpage.class);
                    startActivity(i);
                    Toast.makeText(ground1.this, "Selected", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(ground1.this, "Plz select", Toast.LENGTH_LONG).show();
                }

                boolean status = db.insertGround(id,viratground.toString(),null,cdate.getText().toString(),getTime);
                if(status)
                    Toast.makeText(ground1.this, "Ground Confirm", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ground1.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

    }
}