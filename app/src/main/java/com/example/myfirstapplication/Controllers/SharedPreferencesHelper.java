package com.example.myfirstapplication.Controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPreferencesHelper {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public SharedPreferencesHelper(Context context)
    {

    }

    public void saveKey(String key,String value)
    {
        editor.putString(key,value);
        boolean r=editor.commit();
        Log.d("TAG_Store","R= "+r);
    }

    public void saveKey(String key,int value)
    {
        editor.putInt(key,value);
        boolean r=editor.commit();
        Log.d("TAG_Store","R= "+r);
    }

    public String getKey (String key)
    {
        return sharedPreferences.getString(key,null);
    }


}
