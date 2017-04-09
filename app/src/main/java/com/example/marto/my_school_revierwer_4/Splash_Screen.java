package com.example.marto.my_school_revierwer_4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.marto.my_school_revierwer_4.SwipeViews.Introduction;
import com.example.marto.my_school_revierwer_4.com.marto.home.Home_two;
import com.example.marto.my_school_revierwer_4.com.marto.signup.process.Home_one;

public class Splash_Screen extends AppCompatActivity {


   private SessionManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        manager.pref = getSharedPreferences(SessionManager.preferences, Context.MODE_PRIVATE);

        manager = new SessionManager();

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

                    else if(manager.pref.contains(manager.rev_email)){
                        if(manager.pref.contains(manager.rev_pass)){
                            Intent i = new Intent(getApplicationContext(), Home_two.class);
                            startActivity(i);
                            finish();

                        }

                        {

                        }
                    }

                    else{
                        startActivity(new Intent(getApplicationContext(), Home_one.class));
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
