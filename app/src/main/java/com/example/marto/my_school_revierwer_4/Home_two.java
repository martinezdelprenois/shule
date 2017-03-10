package com.example.marto.my_school_revierwer_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by marto on 07-Feb-17.
 */

public class Home_two extends AppCompatActivity {

    Spinner spin_category, spin_education_level;
    ArrayAdapter<CharSequence> array_category, array_education_level;
   private Toolbar tb_top,tb_bottom;
    Menu menu;



    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.home_two);

// methods for spinners as shown below
        category();
        education();

        // methods fort the bars as shown below
        topbar();
        bottombar();
    }



    /*
    below is the method for the top toolbar in the
    reviwer's home screen

     */

    private void topbar(){
        tb_top = (Toolbar)findViewById(R.id.tb_top_reviewer);
        tb_top.inflateMenu(R.menu.top_bar_menu_reviewer_home);
    }

    /*
    below is the method for the bottom toolbar in the reviewer's home screen

     */
    private void bottombar(){
        tb_bottom = (Toolbar)findViewById(R.id.tb_bottom_reviewer);
        tb_bottom.inflateMenu(R.menu.bottom_bar_menu_reviewer_home);
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
