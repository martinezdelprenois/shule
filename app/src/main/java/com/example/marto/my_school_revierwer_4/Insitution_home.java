package com.example.marto.my_school_revierwer_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Created by marto on 13-Feb-17.
 */

public class Insitution_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.institution_home);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu men){
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu_for_institution,men);
        return true;
    }
}
