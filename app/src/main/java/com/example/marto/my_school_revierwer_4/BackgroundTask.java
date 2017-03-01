package com.example.marto.my_school_revierwer_4;

import android.os.AsyncTask;

/**
 * Created by marto on 28-Feb-17.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
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
