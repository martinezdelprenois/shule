package com.example.marto.my_school_revierwer_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by marto on 13-Feb-17.
 */

public class Insitution_home extends AppCompatActivity {

    Toolbar toptb, bottomtb;

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
    }

    public void bottombar(){
         /*
        instantiating the bottom tool bar
         */
        bottomtb = (Toolbar)findViewById(R.id.tb_insti_2);
        bottomtb.inflateMenu(R.menu.bottom_menu_institution);

    }


}
