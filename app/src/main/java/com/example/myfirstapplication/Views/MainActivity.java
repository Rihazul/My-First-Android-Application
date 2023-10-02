package com.example.myfirstapplication.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapplication.Controllers.SharedPreferencesHelper;
import com.example.myfirstapplication.R;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    Context context;
    private Button button1, button2, button3;
    private Button settings;
    private Button show_counts;
    TextView txt_display;
    int count = 0;
    int counter_1,counter_2,counter_3;
    String button1_name,button2_name,button3_name;
    int max_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        button3 = findViewById(R.id.btn_3);
        show_counts = findViewById(R.id.show);
        settings = findViewById(R.id.btn_settings);
        txt_display = findViewById(R.id.textlayout2);


//        sharedpreferences=getSharedPreferences("SettingsInfo", Context.MODE_PRIVATE);
//        button1_name=sharedpreferences.getString("buttonname1",null);
//        button2_name=sharedpreferences.getString("buttonname2",null);
//        button3_name=sharedpreferences.getString("buttonname3",null);
//        int max_count=sharedpreferences.getInt("MaxCounter",-1) ;

//        int max_count=10;


        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(MainActivity.this);
        button1_name=sharedPreferencesHelper.getStringKey("buttonname1");
        button2_name=sharedPreferencesHelper.getStringKey("buttonname2");
        button3_name= sharedPreferencesHelper.getStringKey("buttonname3");
        max_count=sharedPreferencesHelper.getIntKey("MaxCounter");


        button1.setText(button1_name);
        button2.setText(button2_name);
        button3.setText(button3_name);

        if(button1.getText().length()==0 && button2.getText().length()==0 && button3.getText().length()==0)
        {
            Intent intent=new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

//        event A
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counter_1++;
                txt_display.setText("Total clicks = " + count);
                sharedPreferencesHelper.saveKey("counterForMax",count);
                sharedPreferencesHelper.saveKey("counter1",counter_1);

                if(count==max_count)
                {
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    txt_display.setText("Max count reached "+ count);
                }
            }
        });

//        Event B
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counter_2++;
                txt_display.setText("Total clicks = " + count);
                sharedPreferencesHelper.saveKey("counterForMax",count);
                sharedPreferencesHelper.saveKey("counter2",counter_2);

                if(count==max_count)
                {
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    txt_display.setText("Max count reached " + count);
                }
            }
        });

//        Event C
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                counter_3++;
                txt_display.setText("Total clicks = " + count);
                sharedPreferencesHelper.saveKey("counterForMax",count);
                sharedPreferencesHelper.saveKey("counter3",counter_3);
                if(count==max_count)
                {
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    txt_display.setText("Max count reached " + count);
                }
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