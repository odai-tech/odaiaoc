package com.example.user.odaiaoc2019.model;

import com.example.user.odaiaoc2019.model.BloodDonation;

import java.util.ArrayList;

public class Hospital {
    private double longT;
    private double latT;
    private int image;
    private String name;


    private ArrayList<BloodDonation> bloodDonations;

    public Hospital() {


    }

    public Hospital(double longT, double latT, ArrayList<BloodDonation> bloodDonations, int image, String name) {
        this.longT = longT;
        this.latT = latT;
        this.bloodDonations = bloodDonations;
        this.image=image;
        this.name = name;
    }

    public int getImage( ) {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getLongT() {
        return longT;
    }

    public void setLongT(double longT) {
        this.longT = longT;
    }

    public double getLatT() {
        return latT;
    }

    public void setLatT(double latT) {
        this.latT = latT;
    }

    public ArrayList<BloodDonation> getBloodDonations() {
        return bloodDonations;
    }

    public void setBloodDonations(ArrayList<BloodDonation> bloodDonations) {
        this.bloodDonations = bloodDonations;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "longT=" + longT +
                ", latT=" + latT +
                ", bloodDonations=" + bloodDonations +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
