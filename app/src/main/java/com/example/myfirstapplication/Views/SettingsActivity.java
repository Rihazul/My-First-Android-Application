package com.example.myfirstapplication.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfirstapplication.R;

public class SettingsActivity extends AppCompatActivity {

    private Button button_settings;

     EditText editText1;
     EditText editText2;
     EditText editText3;
     EditText editTextcount;

     Button btn_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editText1=findViewById(R.id.counter_name1);
        editText2=findViewById(R.id.counter_name2);
        editText3=findViewById(R.id.counter_name3);
        editTextcount=findViewById(R.id.max_count);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

    }

//   public boolean onOptionsItemSelected(MenuItem item)
//   {
//       switch (item.getItemId()) {
//
//           case R.id.edit_settings:
//
//               return true;
//           default:
//               return super.onOptionsItemSelected(item);
//       }
//   }

    public void saveData()
    {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.settings_menu,menu);
        return true;
    }


}