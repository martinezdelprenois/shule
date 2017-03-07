package com.example.marto.my_school_revierwer_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by marto on 07-Feb-17.
 */

public class Signing_reviewer extends Activity {

    EditText firstname,lastname,username,email,pass;


    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.signing_up_reveiwer);

        firstname = (EditText)findViewById(R.id.ed_first_name);
        lastname = (EditText)findViewById(R.id.ed_last_name);
        username = (EditText)findViewById(R.id.account_reviewer);
        email = (EditText)findViewById(R.id.email_reveiwer);
        pass = (EditText)findViewById(R.id.password_reviewer);

    }

    public void click_reviewer(View v){

        String First_Name = firstname.getText().toString();
        String Last_Name = lastname.getText().toString();
        String User_Name = username.getText().toString();
        String Email = email.getText().toString();
        String Password = pass.getText().toString();
        String type = "individual_registration";
        BackgroundTask task = new BackgroundTask(this);
        task.execute(type,First_Name,Last_Name,User_Name,Email,Password);
        finish();

        startActivity(new Intent(this,Home_two.class));

    }
}
