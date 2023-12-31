package com.example.myfirstapplication.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myfirstapplication.Controllers.SharedPreferencesHelper;
import com.example.myfirstapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    ListView list_view;
    TextView textView1,textView2,textView3,textViewcount;
    Button button1;

    int i=0;
    int j=0;
    int k=0;
    int counter=0;
    List<String> arrlist= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        list_view=findViewById(R.id.listview);

        textView1=findViewById(R.id.datatxtview1);
        textView2=findViewById(R.id.datatxtview2);
        textView3=findViewById(R.id.datatxtview3);
        textViewcount=findViewById(R.id.datatxtviewcount);

        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(DataActivity.this);

        //showing all the counted buttons pressed
        textView1.setText(sharedPreferencesHelper.getStringKey("buttonname1") + " : " + sharedPreferencesHelper.getIntKey("counter1") + " events" );
        textView2.setText(sharedPreferencesHelper.getStringKey("buttonname2") + " : " + sharedPreferencesHelper.getIntKey("counter2") + " events" );
        textView3.setText(sharedPreferencesHelper.getStringKey("buttonname3") + " : " + sharedPreferencesHelper.getIntKey("counter3") + " events" );
        textViewcount.setText("Total events after clicks :"+ sharedPreferencesHelper.getIntKey("counterForMax"));

        //put all the button pressed on list view
        String temporary = sharedPreferencesHelper.getStringKey("button_name_holder");
        if(sharedPreferencesHelper.getStringKey("button_name_holder")!=null)
        {
            String[] name_holder=temporary.split(",");
            for(int i=0;i<name_holder.length;i++)
            {
                arrlist.add(name_holder[i]);
            }
        }

//        sharedPreferencesHelper.removeKey("button_name_holder");
//
        ArrayAdapter adapter= new ArrayAdapter<String>(this,R.layout.activity_listview,arrlist);
        list_view.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.data_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.edit_toggle) //if toggle is pressed change the list view
        {
            SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(DataActivity.this);
            String string1=sharedPreferencesHelper.getStringKey("buttonname1");
            String string2=sharedPreferencesHelper.getStringKey("buttonname2");
            String string3=sharedPreferencesHelper.getStringKey("buttonname3");

            for (int i = 0; i < arrlist.size(); i++) {
                if (arrlist.get(i).equals(string1)) {

                    arrlist.set(i, " 1 ");
                }
                if (arrlist.get(i).equals(string2))
                {
                   arrlist.set(i," 2 ");
                }
                if (arrlist.get(i).equals(string3))
                {
                    arrlist.set(i," 3 ");
                }
            }
            ArrayAdapter adapter= new ArrayAdapter<String>(this,R.layout.activity_listview,arrlist);
            list_view.setAdapter(adapter);

            return true;
        }

        else if(item.getItemId()==R.id.clear_everything) //another menu created to reset all data from sharedpreference and bring back to settings
        {
            SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(DataActivity.this);
            sharedPreferencesHelper.removeall();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}