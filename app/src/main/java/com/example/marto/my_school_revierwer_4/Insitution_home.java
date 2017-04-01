package com.example.marto.my_school_revierwer_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by marto on 13-Feb-17.
 */

public class Insitution_home extends AppCompatActivity {

    BottomBar bottomtb;
    Intent intent_share; // share intent
    private String sharebody = "Download My School Review app at Google play store";

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.institution_home);

        // instantiating the toolbars
        bottombars();

    }


    /*
    bottom toolbar as shown below
     */


    public void bottombars() {
        bottomtb = (BottomBar) findViewById(R.id.bottomBar);
        bottomtb.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.share_institute) {
                    intent_share = new Intent(android.content.Intent.ACTION_SEND);
                    intent_share.setType("text/plain");
                    intent_share.putExtra(Intent.EXTRA_SUBJECT, " Download My School Reviewer app");
                    intent_share.putExtra(Intent.EXTRA_TEXT, sharebody);
                    startActivity(Intent.createChooser(intent_share, "Share"));
                }

            }
        });

    }
}

