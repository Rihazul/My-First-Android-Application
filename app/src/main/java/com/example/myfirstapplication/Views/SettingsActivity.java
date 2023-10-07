package com.example.myfirstapplication.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.myfirstapplication.Controllers.SharedPreferencesHelper;
import com.example.myfirstapplication.R;

public class SettingsActivity extends AppCompatActivity {

    private Button button_settings;

    Context context;
     EditText editText1;
     EditText editText2;
     EditText editText3;
     EditText editTextcount;

     TextView respone;
     Button btn_save;
     SharedPreferences sharedpreferences;
    String editText_1Str,editText_2Str,editText_3Str;

    private boolean unsavedData;

    int max_length=20;

    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editText1=findViewById(R.id.counter_name1);
        editText2=findViewById(R.id.counter_name2);
        editText3=findViewById(R.id.counter_name3);
        editTextcount=findViewById(R.id.max_count);
        respone=findViewById(R.id.txtviewresponse);

        btn_save=findViewById(R.id.btn_save1);

        //checks the use case of the button names
        InputFilter[] filterArray=new InputFilter[1];
        filterArray[0]=new InputFilter.LengthFilter(max_length);

        editText1.setFilters(filterArray);
        editText2.setFilters(filterArray);
        editText3.setFilters(filterArray);


        //save all info by user
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setEnabled(false);
                editText2.setEnabled(false);
                editText3.setEnabled(false);
                editTextcount.setEnabled(false);


                String another_txt1=editText1.getText().toString();
                String another_txt2=editText2.getText().toString();
                String another_txt3=editText3.getText().toString();
                int another_txtcnt= Integer.parseInt(editTextcount.getText().toString());


                if(another_txt1.length()==0 ||another_txt2.length()==0 ||another_txt3.length()==0 || another_txtcnt<5 || another_txtcnt>200) {
                    editText1.setEnabled(true);
                    editText2.setEnabled(true);
                    editText3.setEnabled(true);
                    editTextcount.setEnabled(true);
                    respone.setText("Inputs not saved please reset them!");
                }
                save_data();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.settings_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
      if(item.getItemId()==R.id.edit_settings) //when pressing settings menu enable edit all info
      {
          editText1.setEnabled(true);
          editText1.setFocusableInTouchMode(true);
          editText1.requestFocus();

          editText2.setEnabled(true);
          editText2.setFocusableInTouchMode(true);
          editText2.requestFocus();

          editText3.setEnabled(true);
          editText3.setFocusableInTouchMode(true);
          editText3.requestFocus();

          editTextcount.setEnabled(true);
          editTextcount.setFocusableInTouchMode(true);
          editTextcount.requestFocus();

          return true;

      }
      return super.onOptionsItemSelected(item);
    }

    public void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

    public void save_data() //function that saves all data written to sharedpreference
    {
        editText_1Str =editText1.getText().toString();
        editText_2Str= editText2.getText().toString();
        editText_3Str= editText3.getText().toString();
        count=Integer.parseInt(editTextcount.getText().toString());


        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(SettingsActivity.this);
        sharedPreferencesHelper.saveKey("buttonname1",editText_1Str);
        sharedPreferencesHelper.saveKey("buttonname2",editText_2Str);
        sharedPreferencesHelper.saveKey("buttonname3",editText_3Str);
        sharedPreferencesHelper.saveKey("MaxCounter",count);

    }

}