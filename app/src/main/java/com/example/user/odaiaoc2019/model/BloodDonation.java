package com.example.user.odaiaoc2019.model;

public class BloodDonation {
    private int age;
    private String BloodType;
    private boolean isHealthy;
    private int imageId;
    private String ID;
    private String PhoneNumber;
    private String FullName;


    public BloodDonation(int age , String BloodType , boolean isHealthy , int imageId , String FullName, String PhoneNumber , String ID  ){
        this.age=age;
        this.BloodType=BloodType;
        this.isHealthy=isHealthy;
        this.imageId=imageId;
        this.ID=ID;
        this.PhoneNumber=PhoneNumber;
        this.FullName=FullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumner) {
        PhoneNumber = PhoneNumber;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @Override
    public String toString() {
        return "BloodDonation{" +
                "age=" + age +
                ", BloodType='" + BloodType + '\'' +
                ", isHealthy=" + isHealthy +
                ", ID='" + ID + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", FullName='" + FullName + '\'' +
                '}';
    }
}
