package com.example.marto.my_school_revierwer_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by marto on 13-Feb-17.
 */

public class Insitution_home extends AppCompatActivity {

    Toolbar toptb, bottomtb;
    Intent intent_share; // share intent
   private String sharebody = "Download My School Review app at Google play store";

    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.institution_home);

        // instantiating the toolbars

       topbar();
        bottombar();

    }

    public  void topbar(){
         /*
        instanstiating the top tool bar
         */
        toptb = (Toolbar)findViewById(R.id.tb_insti_1);
        toptb.inflateMenu(R.menu.menu_for_institution);
        toptb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {


                return false;
            }
        });
    }

    /*
    bottom toolbar as shown below
     */
    public void bottombar(){
         /*
        instantiating the bottom tool bar
         */
        bottomtb = (Toolbar)findViewById(R.id.tb_insti_2);
        bottomtb.inflateMenu(R.menu.bottom_menu_institution);
        bottomtb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.share_institute:
                        intent_share = new Intent(android.content.Intent.ACTION_SEND);
                        intent_share.setType("text/plain");
                        intent_share.putExtra(Intent.EXTRA_SUBJECT," Download My School Reviewer app");
                        intent_share.putExtra(Intent.EXTRA_TEXT,sharebody);
                        startActivity(Intent.createChooser(intent_share,"Share"));
                        return true;


                }

                return false;
            }
        });

    }



}
