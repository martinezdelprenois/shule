package com.example.marto.my_school_revierwer_4.com.marto.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.marto.my_school_revierwer_4.R;

public class Login_as extends AppCompatActivity {

    Button insti,rev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);

        rev = (Button)findViewById(R.id.btn_institution_login_as);
        insti = (Button)findViewById(R.id.btn_reviewer_login_as);
    }


    public void click_login_as(View v){
        if(v.getId() == R.id.btn_institution_login_as){

            startActivity(new Intent(this,Institution_login.class));
        }

        else if(v.getId() == R.id.btn_reviewer_login_as){

            startActivity(new Intent(this,Reviewer_login.class ));
        }

    }
}
