package com.example.marto.my_school_revierwer_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by marto on 07-Feb-17.
 */

public class Home_two extends AppCompatActivity {

    Spinner spin_category, spin_education_level;
    ArrayAdapter<CharSequence> array_category, array_education_level;



    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.home_two);

        category();
        education();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu men){
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu_home_two,men);
        return true;
    }



    private void category(){
        spin_category = (Spinner) findViewById(R.id.spinner_categories);
        array_category = ArrayAdapter.createFromResource(this, R.array.Category,android.R.layout.simple_spinner_dropdown_item);
        array_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_category.setAdapter(array_category);

    }

    private void education(){
        spin_education_level = (Spinner)findViewById(R.id.spinner2);
        array_education_level = ArrayAdapter.createFromResource(this, R.array.Education_level,android.R.layout.simple_spinner_dropdown_item);
        array_education_level.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_education_level.setAdapter(array_education_level);
    }
}
