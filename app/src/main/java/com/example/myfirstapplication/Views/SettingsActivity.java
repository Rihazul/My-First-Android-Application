package com.example.myfirstapplication.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapplication.R;

public class SettingsActivity extends AppCompatActivity {

    private Button button_settings;

     TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.settings_menu,menu);
        return true;

    }
}