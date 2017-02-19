package com.example.marto.my_school_revierwer_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by marto on 07-Feb-17.
 */

@SuppressWarnings("ALL")
public class Signing_institution extends Activity {

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.signing_up_institution);

    }

    public void clicknext(View v) {
        if (v.getId() == R.id.btn_next) {
            Intent i = new Intent(Signing_institution.this, Insitution_home.class);
            startActivity(i);
        }
    }


}