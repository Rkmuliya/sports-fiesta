package com.example.sportfiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class grounds extends AppCompatActivity {

    Button gr1,gr2;
    String ground1="",ground2="";
    int id;
    String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grounds);

        gr1 = findViewById(R.id.btn_virat);
        gr2 = findViewById(R.id.btn_mahi);

        ground1 = gr1.getText().toString();
        ground2 = gr2.getText().toString();


        SharedPreferences sharedPreferences = getSharedPreferences("sportsF",MODE_PRIVATE);
        id = sharedPreferences.getInt("uID",0);
        uname = sharedPreferences.getString("uName",null);

        gr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(grounds.this,ground1.class);
                i.putExtra("Gvirat",ground1.toString());
                startActivity(i);
            }
        });

        gr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(grounds.this,ground2.class);
                i.putExtra("Gmahi",ground2.toString());
                startActivity(i);

            }
        });

    }
}
