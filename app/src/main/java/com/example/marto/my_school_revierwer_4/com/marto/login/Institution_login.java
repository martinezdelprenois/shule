package com.example.marto.my_school_revierwer_4.com.marto.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.marto.my_school_revierwer_4.R;
import com.example.marto.my_school_revierwer_4.com.marto.home.Institution_home;

public class Institution_login extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_login);

        btn = (Button)findViewById(R.id.btn_institution_login);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,Institution_home.class));
        finish();
    }
}
