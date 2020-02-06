package com.example.user.odaiaoc2019;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE =1000 ;
    Button mCaptureBtn;
    ImageView mImageView;
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
                }

            }
        } 0     }
}



