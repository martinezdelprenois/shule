package com.example.marto.my_school_revierwer_4.com.marto.reg;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.RestAPI;
import com.example.marto.my_school_revierwer_4.SessionManager;
import com.example.marto.my_school_revierwer_4.com.marto.home.Home_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by marto on 07-Feb-17.
 */

public class Signing_reviewer extends Activity implements View.OnClickListener{

    EditText firstname,lastname,username,email,pass;
    Button btn;


    SessionManager manager;

    private final String ROOT_URL = "http://192.168.43.102/";
    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.signing_up_reveiwer);

        manager = new SessionManager();


        firstname = (EditText)findViewById(R.id.ed_first_name);
        lastname = (EditText)findViewById(R.id.ed_last_name);
        username = (EditText)findViewById(R.id.account_reviewer);
        email = (EditText)findViewById(R.id.email_reveiwer);
        pass = (EditText)findViewById(R.id.password_reviewer);

        btn = (Button)findViewById(R.id.btn_next_reviewer);
        btn.setOnClickListener(this);

    }
    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RestAPI api = adapter.create(RestAPI.class);

        //Defining the method insertuser of our interface
        api.register_user(

                //Passing the values by getting it from editTexts
                firstname.getText().toString(),
                lastname.getText().toString(),
                username.getText().toString(),
                email.getText().toString(),
                pass.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(Signing_reviewer.this, output, Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(Signing_reviewer.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = manager.pref.edit();
        String u = email.getText().toString();
        String p = pass.getText().toString();
        editor.putString(manager.rev_email, u);
        editor.putString(manager.rev_pass, p);
        editor.commit();
insertUser();
        finish();
        startActivity(new Intent(this,Home_two.class));

    }
}
