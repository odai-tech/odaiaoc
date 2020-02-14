package com.example.user.odaiaoc2019.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.odaiaoc2019.adapters.CustomAdapterHospital;
import com.example.user.odaiaoc2019.R;
import com.example.user.odaiaoc2019.model.BloodDonation;
import com.example.user.odaiaoc2019.model.Hospital;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<BloodDonation> bloodDonations1 = new ArrayList<>();
    ArrayList<BloodDonation> bloodDonations2 = new ArrayList<>();
    ArrayList<Hospital> hospitals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listView = findViewById(R.id.hospitalList);

        bloodDonations1.add(new BloodDonation(33, "AB", true, R.drawable.ic_launcher_background, "first", "123", "123"));
        bloodDonations1.add(new BloodDonation(33, "OO", true, R.drawable.ic_launcher_background, "first", "123", "123"));

        bloodDonations2.add(new BloodDonation(33, "OO", true, R.drawable.ic_launcher_background, "first", "123", "123"));
        bloodDonations2.add(new BloodDonation(33, "A+", true, R.drawable.ic_launcher_background, "first", "123", "123"));


        hospitals.add(new Hospital(23.45, 2.36, bloodDonations1, R.drawable.bloodlogo, "Odais Hospital1"));
        hospitals.add(new Hospital(19.5, 4.66, bloodDonations2, R.drawable.bloodotype, "Odais Hospital2"));

        CustomAdapterHospital adapterHospital = new CustomAdapterHospital(this, R.layout.hospital_item, hospitals);
        listView.setAdapter(adapterHospital);

        listView.setOnItemClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
        }


    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToNextActivity;

        switch (item.getItemId()) {

            case R.id.profile:
                goToNextActivity = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(goToNextActivity);
                break;

            case R.id.logout:
                goToNextActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToNextActivity);
                break;


        }
        return true;
    }

    @Override

        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){

                Intent i = new Intent(this, HospitalUI.class);
                startActivity(i);
            }
        }
