package com.example.marto.my_school_revierwer_4.com.marto.accounts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.School_Account_Edit;
import com.example.marto.my_school_revierwer_4.School_Info_Edit;
import com.example.marto.my_school_revierwer_4.UploadImages;

public class Institutions_Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutions__account);
    }

    public void click_school_account(View v){
        if(v.getId() == R.id.btn_edit_school_account){
            startActivity(new Intent(this, School_Account_Edit.class));
        }

        else if(v.getId() == R.id.btn_edit_school_info){
            startActivity(new Intent(this, School_Info_Edit.class));
        }

        else if(v.getId() == R.id.btn_image_upload){
            startActivity(new Intent(this, UploadImages.class));
        }
    }
}
