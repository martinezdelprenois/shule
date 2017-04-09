package com.example.marto.my_school_revierwer_4.com.marto.reg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marto.my_school_revierwer_4.com.marto.home.Institution_home;
import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.RestAPI;

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

@SuppressWarnings("ALL")
public class Signing_institution extends Activity implements View.OnClickListener{

    EditText ed_institution_name, ed_personal_email, ed_password, ed_institution_email, ed_institution_websitelink, ed_institution_number;
    Spinner spin,spin_cat;
    ArrayAdapter<CharSequence> institution_category, institution_level;
    private final String ROOT_URL = "http://192.168.43.102/";
   private Button btn;
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.signing_up_institution);

        btn = (Button)findViewById(R.id.btn_signin_institution);
        btn.setOnClickListener(this);

        // instantiating the edittexts
        ed_institution_name = (EditText)findViewById(R.id.ed_institution_insti_2);
        ed_personal_email = (EditText)findViewById(R.id.ed_email_insti);
        ed_password = (EditText)findViewById(R.id.ed_password_insti);
        ed_institution_websitelink = (EditText)findViewById(R.id.ed_website_insti);
        ed_institution_number = (EditText)findViewById(R.id.ed_index_insti);


        // instatiating the spinner
        spin = (Spinner) findViewById(R.id.Spinner_institution);
        institution_level= ArrayAdapter.createFromResource(this, R.array.Education_level,android.R.layout.simple_spinner_dropdown_item);
        institution_level.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(institution_level);

        spin_cat = (Spinner) findViewById(R.id.spinner_cat);
        institution_category = ArrayAdapter.createFromResource(this,R.array.Category,android.R.layout.simple_spinner_dropdown_item);
        institution_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_cat.setAdapter(institution_category);

    }


    @Override
    public void onClick(View v) {

        insertInstitution();
        finish();
        startActivity(new Intent(this,Institution_home.class));
    }

    private void insertInstitution(){
        //Here we will handle the http request to insert user to mysql db
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RestAPI api = adapter.create(RestAPI.class);

        //Defining the method insertuser of our interface
        api.register_school(

                //Passing the values by getting it from editTexts
                ed_institution_name.getText().toString(),
                ed_personal_email.getText().toString(),
                ed_password.getText().toString(),
                ed_institution_websitelink.getText().toString(),
                ed_institution_number.getText().toString(),
                spin.getSelectedItem().toString(),
                spin_cat.getSelectedItem().toString(),


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
                        Toast.makeText(Signing_institution.this, output, Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(Signing_institution.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}