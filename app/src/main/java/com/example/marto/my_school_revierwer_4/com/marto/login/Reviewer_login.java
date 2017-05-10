package com.example.marto.my_school_revierwer_4.com.marto.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.RestAPI;
import com.example.marto.my_school_revierwer_4.SessionManager;
import com.example.marto.my_school_revierwer_4.com.marto.home.Reviewer_Home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Reviewer_login extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
  static  EditText ed_email, ed_pass;





    SessionManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewer_login);

        manager = new SessionManager();

        ed_email = (EditText)findViewById(R.id.ed_email_reviewer_login);
        ed_pass = (EditText)findViewById(R.id.ed_pass_reviewer_login);

        btn = (Button)findViewById(R.id.btn_reviewer_login);
        btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {


        if (ed_email.getText().toString() == " " || ed_pass.getText().toString() == " ") {
            Toast.makeText(Reviewer_login.this, "please fill all fields", Toast.LENGTH_LONG).show();

        }

        else {

            SharedPreferences.Editor editor = manager.pref.edit();
            String u = ed_email.getText().toString();
            String p = ed_pass.getText().toString();
            editor.putString(manager.rev_email, u);
            editor.putString(manager.rev_pass, p);
            editor.commit();

            logincredentials();
            startActivity(new Intent(this, Reviewer_Home.class));
            finish();
        }

    }


    private void logincredentials(){
        //Here we will handle the http request to insert user to mysql db
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(SessionManager.HTTP) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RestAPI api = adapter.create(RestAPI.class);

        //Defining the method insertuser of our interface
        api.individual_login(

                //Passing the values by getting it from editTexts
                ed_email.getText().toString(),
                ed_pass.getText().toString(),


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
                        Toast.makeText(Reviewer_login.this, output, Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(Reviewer_login.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



}
