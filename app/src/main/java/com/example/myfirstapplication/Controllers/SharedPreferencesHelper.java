package com.example.myfirstapplication.Controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPreferencesHelper {

    public static SharedPreferences sharedPreferences;
    private final String name= "SettingsInfo";
    public static SharedPreferences.Editor editor;


    public SharedPreferencesHelper(Context context)
    {
        sharedPreferences=context.getSharedPreferences(name,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void saveKey(String key,String value)
    {
        editor.putString(key, value);
        boolean push=editor.commit();
        Log.d("TAG_Store","Push = "+push);
    }

    public void saveKey(String key,int value)
    {
        editor.putInt(key,value);
        boolean push= editor.commit();
        Log.d("TAG_Store","Push = "+push);
    }

    public void saveKey(String key,boolean value)
    {
        editor.putBoolean(key,value);
        boolean push= editor.commit();
        Log.d("TAG_Store","Push = "+push);
    }

    public  String getStringKey(String key)
    {
        return sharedPreferences.getString(key,"no name");
    }

    public int getIntKey(String key)
    {
        return sharedPreferences.getInt(key,0);
    }

    public boolean getBoolKey(String key)
    {
        return sharedPreferences.getBoolean(key,false);
    }

    public void removeKey(String key)
    {
        editor.remove(key);
    }

    public void removeall()
   {
       editor.clear();
       editor.apply();
   }
}
