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
import com.example.marto.my_school_revierwer_4.com.marto.home.Institution_home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Institution_login extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    EditText ed_email,ed_pass;


   private SessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_login);

        manager = new SessionManager();

        btn = (Button)findViewById(R.id.btn_institution_login);
        btn.setOnClickListener(this);

        ed_email = (EditText)findViewById(R.id.ed_personal_email_institution_login);
        ed_pass = (EditText)findViewById(R.id.ed_pass_institution_login);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = manager.PREF_INSTI.edit();
        String p = ed_email.getText().toString();
        String q = ed_pass.getText().toString();
        editor.putString(manager.INSTI_EMAIL, p);
        editor.putString(manager.INSTI_PASS,q);
        editor.commit();
        logincredentials();
        startActivity(new Intent(this,Institution_home.class));
        finish();
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
        api.institutions_login(

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
                        Toast.makeText(Institution_login.this, output, Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(Institution_login.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
