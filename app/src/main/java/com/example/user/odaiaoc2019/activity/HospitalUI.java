package com.example.user.odaiaoc2019.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.odaiaoc2019.R;

public class HospitalUI extends AppCompatActivity implements View.OnClickListener {

    Button RequestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_ui);

        RequestList = findViewById(R.id.buttonRequest);
        RequestList.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v == RequestList) {
            Intent i;
            i = new Intent(this, PatientList.class);
            startActivity(i);
        }
    }
}
