package com.example.marto.my_school_revierwer_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.marto.my_school_revierwer_4.SwipeViews.Introduction;

public class Splash_Screen extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Thread splash = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(3000);
                    Boolean isfirstRun = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("isfirstrun", true);

                    if(isfirstRun){
                        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isfirstrun",false).commit();
                        Intent i = new Intent(getApplicationContext(), Introduction.class);
                        startActivity(i);
                        finish();
                    }

                    else{
                        Intent i = new Intent(getApplicationContext(), Home_one.class);
                        startActivity(i);
                        finish();
                    }

                }

                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        splash.start();
    }


}
