package com.example.myfirstapplication.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myfirstapplication.R;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    ListView list_view;
    TextView textView1,textView2,textView3,textViewcount;
    Button button1;

    int i=0;
    int j=0;
    int k=0;
    int counter=0;
    ArrayList<String> arrlist= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        list_view=findViewById(R.id.listview);

        textView1=findViewById(R.id.datatxtview1);
        textView2=findViewById(R.id.datatxtview2);
        textView3=findViewById(R.id.datatxtview3);
        textViewcount=findViewById(R.id.datatxtviewcount);



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.data_menu,menu);
        return true;
    }


}