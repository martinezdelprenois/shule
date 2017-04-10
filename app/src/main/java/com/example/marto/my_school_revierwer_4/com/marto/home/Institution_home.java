package com.example.marto.my_school_revierwer_4.com.marto.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.SessionManager;
import com.example.marto.my_school_revierwer_4.com.marto.signup.process.Home_one;

/**
 * Created by marto on 13-Feb-17.
 */

public class Institution_home extends AppCompatActivity {

    Intent intent_share; // share intent
    private String sharebody = "Download My School Review app at Google play store";
    BottomNavigationView vv;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.institution_home);

        // instantiating the toolbars
        bottom();

    }


    /*
    bottom toolbar as shown below
     */


    private void bottom(){
        vv = (BottomNavigationView)findViewById(R.id.navigation);
        vv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.share_institute:
                        intent_share = new Intent(android.content.Intent.ACTION_SEND);
                        intent_share.setType("text/plain");
                        intent_share.putExtra(Intent.EXTRA_SUBJECT, " Download My School Reviewer app");
                        intent_share.putExtra(Intent.EXTRA_TEXT, sharebody);
                        startActivity(Intent.createChooser(intent_share, "Share"));

                    case R.id.logou_school:
                        SharedPreferences pref = getSharedPreferences(SessionManager.preferences, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.clear();
                        editor.commit();
                        Institution_home.this.finish();
                        startActivity(new Intent(Institution_home.this, Home_one.class));
                }
                return false;
            }
        });
    }


}

