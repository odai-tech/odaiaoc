package com.example.user.odaiaoc2019;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE =1000 ;
    Button mCaptureBtn;
    ImageView mImageView;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mImageView = findViewById(R.id.image_view);
        mCaptureBtn = findViewById(R.id.capture_image_btn);

        mCaptureBtn.setOnClickListener(new View.OnClickListener()  {
        @Override
        public void onClick(View v) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(Manifest.permission.CAMERA) ==
                 PackageManager.PERMISSION_DENIED | |
                 checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                 PackageManager.PERMISSION_DENIED) {
               String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                requestPermissions(permission, PERMISSION_CODE);

                 }
                 else {
                    openCamera();
                }
                 else{
                    openCamera();
                 }

    private void openCamera() {
                    ContentValues values= new ContentValues();
                    values.put(MediaStore.Images.Media.TITLE,"New Picture");
                    values.put(MediaStore.Images.Media.DESCRIPTION,"From The Camera");
                    imageUri=getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                    Intent cameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);

                }
                @Override
                public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions, @NonNull int);
                switch (requestCode){
                    case PERMISSION_CODE:{
                        if (grantResults.length > 0 && grantResults[0]==
                                PackageManager.PERMISSION_GRANTED){
                            openCamera();
                        }
                        else{
                            Toast.makeText(this,"permission denied", Toast.LENGTH_SHORT).show();

                        }
                        }
                        }
                    }
            }
