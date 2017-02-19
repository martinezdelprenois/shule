package com.example.marto.my_school_revierwer_4;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by marto on 18-Feb-17.
 */

public class Intro_tutorial_Manager {

    SharedPreferences pref; // for storing small chunks of data
    SharedPreferences.Editor editor; // editing preferences
    Context context;

    public Intro_tutorial_Manager(Context context){
        this.context = context;
        pref = context.getSharedPreferences("first", 0);
        editor = pref.edit();
    }

    // opening the app for the first time
    public void setfirst(boolean isfirst){
        editor.putBoolean("check", isfirst);
        editor.commit();
    }

    // opened up before
    public boolean check(){
        return pref.getBoolean("check", true);
    }
}
