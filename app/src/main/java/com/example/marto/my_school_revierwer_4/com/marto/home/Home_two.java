package com.example.marto.my_school_revierwer_4.com.marto.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.Splash_Screen;

/**
 * Created by marto on 07-Feb-17.
 */

public class Home_two extends AppCompatActivity {

    Splash_Screen sr = new Splash_Screen();


    Spinner spin_category, spin_education_level;
    ArrayAdapter<CharSequence> array_category, array_education_level;
    Intent share;
    String sharebody = "Dowload My School Reviewer App";

    ViewFlipper flipper;
    ImageView v1,v2;

    BottomNavigationView v;



    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.home_two);

// methods for spinners as shown below
        category();
        education();


        v = (BottomNavigationView)findViewById(R.id.navigation2);
        bottombar();

        // the view flipper
        flipper = (ViewFlipper)findViewById(R.id.flipper_individual);
        v1 = (ImageView)findViewById(R.id.img_1);
        v2 = (ImageView)findViewById(R.id.img_2);

        //method
        flip();

    }



    //method for the view flipper below

    private void flip(){
        flipper.setAutoStart(true);
        flipper.setFlipInterval(3000);

        String urlimage = "http://10.3.3.208/MY_SCHOOL_REVIEWER/IMAGES/snake.png";
        String urlimage2 = "http://10.3.3.208/MY_SCHOOL_REVIEWER/IMAGES/webstar.png";

        Glide.with(Home_two.this).load(urlimage).into(v1);
        Glide.with(Home_two.this).load(urlimage2).into(v2);

    }
    /*
    below is the method for the bottom toolbar in the reviewer's home screen

     */
    private void bottombar(){
     v.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             switch (item.getItemId()){
                 case R.id.share_reviwer:
                     share = new Intent(android.content.Intent.ACTION_SEND);
                     share.setType("text/plain");
                     share.putExtra(Intent.EXTRA_SUBJECT, " Download My School Reviewer app");
                     share.putExtra(Intent.EXTRA_TEXT, sharebody);
                     startActivity(Intent.createChooser(share, "Share"));

             }
             return false;
         }
     });
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
