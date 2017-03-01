package com.example.marto.my_school_revierwer_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by marto on 07-Feb-17.
 */

@SuppressWarnings("ALL")
public class Signing_institution extends Activity {

    EditText ed_institution_name, ed_personal_email, ed_password, ed_institution_email, ed_institution_websitelink, ed_institution_number;
    Spinner spin;
    ArrayAdapter<CharSequence> institution_category;
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.signing_up_institution);

        // instantiating the edittexts
        ed_institution_name = (EditText)findViewById(R.id.ed_institution);
        ed_personal_email = (EditText)findViewById(R.id.ed_personal_email);
        ed_password = (EditText)findViewById(R.id.ed_password_institution);
        ed_institution_email = (EditText)findViewById(R.id.ed_institution_email);
        ed_institution_websitelink = (EditText)findViewById(R.id.ed_instution_website);
        ed_institution_number = (EditText)findViewById(R.id.ed_index_number);

        // instatiating the spinner
        spin = (Spinner) findViewById(R.id.Spinner_institution);
        institution_category= ArrayAdapter.createFromResource(this, R.array.Institution_category,android.R.layout.simple_spinner_dropdown_item);
        institution_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(institution_category);


    }

    public void clicknext(View v) {

        String institution_name = ed_institution_name.getText().toString();
        String institution_personal_email = ed_personal_email.getText().toString();
        String institution_password = ed_password.getText().toString();
        String institution_email = ed_institution_email.getText().toString();
        String institution_website = ed_institution_websitelink.getText().toString();
        String institution_index = ed_institution_number.getText().toString();
        String spinning = spin.getSelectedItem().toString();


                finish();
            Intent i = new Intent(Signing_institution.this, Insitution_home.class);
            startActivity(i);


    }


}