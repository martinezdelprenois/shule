package com.example.marto.my_school_revierwer_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class School_Info_Edit extends AppCompatActivity {

    private Button btn;
    private EditText description,po_box,address,tel_1,tel_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__info__edit);

        description = (EditText)findViewById(R.id.ed_description);
        po_box = (EditText)findViewById(R.id.po_box);
        address = (EditText)findViewById(R.id.ed_address);
        tel_1 = (EditText)findViewById(R.id.ed_tel_1);
        tel_2 = (EditText)findViewById(R.id.ed_tel_2);
        btn = (Button)findViewById(R.id.btn_save);
    }

    public void btn_upload(View v){
        save_infor();
    }

    private void save_infor(){
        //Here we will handle the http request to insert user to mysql db
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(SessionManager.HTTP) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RestAPI api = adapter.create(RestAPI.class);

        api.schools_information_upload(
                description.getText().toString(),
        po_box.getText().toString(),
        address.getText().toString(),
                tel_1.getText().toString(),
                tel_2.getText().toString(),

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
                        Toast.makeText(School_Info_Edit.this, output, Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(School_Info_Edit.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
