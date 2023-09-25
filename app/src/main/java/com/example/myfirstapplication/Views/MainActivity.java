package com.example.myfirstapplication.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapplication.R;


public class MainActivity extends AppCompatActivity {
    private Button botton1, botton2, botton3;
    private Button settings;
    private Button show_counts;
    TextView txt_display;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botton1 = findViewById(R.id.btn_1);
        botton2 = findViewById(R.id.btn_2);
        botton3 = findViewById(R.id.btn_3);
        show_counts = findViewById(R.id.show);
        settings = findViewById(R.id.btn_settings);
        txt_display = findViewById(R.id.textlayout2);


//        event A
        botton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                txt_display.setText("Total clicks = " + count);
            }
        });

//        Event B
        botton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                txt_display.setText("Total clicks = " + count);
            }
        });

//        Event C
        botton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                txt_display.setText("Total clicks = " + count);
            }
        });

        // settings page button
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        //data page button
        show_counts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });



    }


}