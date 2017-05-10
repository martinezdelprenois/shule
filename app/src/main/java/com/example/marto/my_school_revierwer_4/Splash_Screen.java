package com.example.marto.my_school_revierwer_4;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.marto.my_school_revierwer_4.SwipeViews.Introduction;
import com.example.marto.my_school_revierwer_4.com.marto.home.Institution_home;
import com.example.marto.my_school_revierwer_4.com.marto.home.Reviewer_Home;
import com.example.marto.my_school_revierwer_4.com.marto.signup.process.Home_one;

public class Splash_Screen extends AppCompatActivity {


   private SessionManager manager_rev;
    private SessionManager manager_insti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        manager_rev = new SessionManager();
        manager_insti = new SessionManager();

        manager_rev.pref = getSharedPreferences(SessionManager.preferences, Context.MODE_PRIVATE);
        manager_insti.PREF_INSTI = getSharedPreferences(SessionManager.pref_insti,Context.MODE_PRIVATE);


        checkconnection();
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

                    else if(manager_rev.pref.contains(manager_rev.rev_email)){
                        if(manager_rev.pref.contains(manager_rev.rev_pass)){

                            Intent i = new Intent(getApplicationContext(), Reviewer_Home.class);
                            startActivity(i);
                            finish();

                        }


                    }


                    else if(SessionManager.PREF_INSTI.contains(SessionManager.INSTI_INDEX)){
                        if(SessionManager.PREF_INSTI.contains(SessionManager.INSTI_PASS)){
                            Intent i = new Intent(getApplicationContext(), Institution_home.class);
                            startActivity(i);
                            finish();
                        }
                    }

                    else if(!SessionManager.PREF_INSTI.contains(SessionManager.INSTI_INDEX) | !manager_rev.pref.contains(manager_rev.rev_email)) {
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

    // checking for internet connection using the two methods just shown below
    protected boolean isonline(){
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();
        if(netinfo != null && netinfo.isConnectedOrConnecting() ){
            return true;
        }

        else{
            return false;
        }
    }

    public void checkconnection(){
        if(isonline()){
            Toast.makeText(this,"you are connected to the internet", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"you are not connected to the internet, some features of this application may not work",Toast.LENGTH_LONG).show();
        }
    }

    // METHOD RIGHT BELOW IS FOR SILENT LOGIN_REVIEWER

}
