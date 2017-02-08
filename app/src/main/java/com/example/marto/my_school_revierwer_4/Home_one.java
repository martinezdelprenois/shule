package com.example.marto.my_school_revierwer_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_one extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_one);
    }

    public void click(View v){
        if(v.getId() == R.id.btn_sign_in ){
            Intent i = new Intent(this, Home_two.class);
            startActivity(i);
        }

        else if (v.getId()== R.id.btn_sign_up ){
            Intent i = new Intent(this,Signing_up_class.class );
            startActivity(i);
        }


    }
}
