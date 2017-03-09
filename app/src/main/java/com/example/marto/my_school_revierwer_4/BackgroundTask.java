package com.example.marto.my_school_revierwer_4;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by marto on 28-Feb-17.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {
    Context txt;

    BackgroundTask(Context context){
        this.txt = context;
    }
    @Override
    protected String doInBackground(String... params) {

        // URLS for the selections as shown right below
        String institution_reg = "http://192.168.1.105/MY_SCHOOL_REVIEWER/Institutions_signup.php";
        String individual_reg = "http://192.168.1.105/MY_SCHOOL_REVIEWER/Individuals_signup.php";

        String method = params[0];

        // CONDITION FOR INSTITUTION REGISTRATION WRITTEN JUST RIGHT BELOW
        if(method.equals("registration_institution")){
            String institution_name = params[1];
            String institution_personal_email =params[2];
            String institution_password = params[3];
            String institution_email = params[4];
            String institution_website = params[5];
            String institution_index = params[6];
            String spinning = params[7];

            try {

                URL url = new URL(institution_reg);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                Log.v("institutionsign","connection opened");
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                con.setDoInput(true);
                Log.v("institutionsign","input and ouput true");

                Log.v("institutionsign", "about to get outputstream");
                OutputStream os = con.getOutputStream();
                Log.v("institutionsign", "got output stream");

                BufferedWriter writing = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data =
                        URLEncoder.encode("Institution_Name", "UTF-8") + "=" +URLEncoder.encode(institution_name, "UTF-8") + "&" +
                        URLEncoder.encode("Personal_Email", "UTF-8")+ "=" + URLEncoder.encode(institution_personal_email, "UTF-8") + "&" +
                                URLEncoder.encode("Password", "UTF-8")+ "=" + URLEncoder.encode(institution_password, "UTF-8") + "&" +
                                URLEncoder.encode("WebSite_Link", "UTF-8") + "=" + URLEncoder.encode(institution_website, "UTF-8") + "&" +
                                URLEncoder.encode("School_Email", "UTF-8") + "=" + URLEncoder.encode(institution_email, "UTF-8") + "&"+
                                URLEncoder.encode("Institution_Index_Number", "UTF-8") + "=" +URLEncoder.encode(institution_index, "UTF-8") + "&" +
                                URLEncoder.encode("Category", "UTF-8") + "=" + URLEncoder.encode(spinning, "UTF-8");
                Log.v("institutionsign", "finished writing data");
                writing.write(data);
                writing.flush();
                Log.v("institutionsign", "data flushed");
                writing.close();
                os.close();

                InputStream is = con.getInputStream();
                is.close();
                con.connect();
                con.disconnect();
                return "registration successful";
            }


            catch(MalformedURLException e){
                e.printStackTrace();
            }

            catch(IOException e){
                e.printStackTrace();
            }
        }

        // CONDITION FOR INDIVIDUAL REGISTRATION WRITTEN JUST RIGHT BELOW
        else if(method.equals("individual_registration")){
            String First_Name = params[1];
            String Last_Name =params[2];
            String User_Name = params[3];
            String Email = params[4];
            String Password = params[5];


            try{
                URL url = new URL(individual_reg);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                con.setDoInput(true);
                OutputStream os = con.getOutputStream();
                BufferedWriter writing = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data =
                        URLEncoder.encode("First_Name", "UTF-8") + "=" +URLEncoder.encode(First_Name, "UTF-8") + "&" +
                                URLEncoder.encode("Last_Name", "UTF-8")+ "=" + URLEncoder.encode(Last_Name, "UTF-8") + "&" +
                                URLEncoder.encode("User_Name", "UTF-8")+ "=" + URLEncoder.encode(User_Name, "UTF-8") + "&" +
                                URLEncoder.encode("Email", "UTF-8") + "=" + URLEncoder.encode(Email, "UTF-8") + "&" +
                                URLEncoder.encode("Password", "UTF-8") + "=" + URLEncoder.encode(Password, "UTF-8");

                writing.write(data);
                writing.flush();
                writing.close();
                os.close();

                InputStream is = con.getInputStream();
                is.close();
                con.connect();
                con.disconnect();
                return "registration successful";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute(){

    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result){

    }
}
