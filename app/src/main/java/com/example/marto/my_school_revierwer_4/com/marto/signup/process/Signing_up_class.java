package com.example.marto.my_school_revierwer_4.com.marto.signup.process;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.com.marto.reg.Signing_institution;
import com.example.marto.my_school_revierwer_4.com.marto.reg.Signing_reviewer;

/**
 * Created by marto on 07-Feb-17.
 */

public class Signing_up_class extends Activity {

    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.signing_up);
    }

    public void clicking(View v){
        if (v.getId()== R.id.btn_institution){
            Intent i = new Intent(Signing_up_class.this,Signing_institution.class );
            startActivity(i);
        }

        else if(v.getId() == R.id.btn_reviewer){
            Intent i = new Intent(Signing_up_class.this, Signing_reviewer.class );
            startActivity(i);
        }
    }

}
