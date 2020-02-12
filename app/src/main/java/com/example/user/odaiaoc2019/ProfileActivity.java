package com.example.user.odaiaoc2019;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
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
    private static final int CAMERA_PIC_REQUEST = 0;

    private static final int CAMERA_REQUEST = 0;
    Button buttonCam;
    ImageView imageViewA;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonCam = findViewById(R.id.buttonCam);
        buttonCam.setOnClickListener(this);

    }

    public void onClick(View view) {
        if(view == buttonCam){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, CAMERA_REQUEST);
        }else{
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if ((requestCode == CAMERA_REQUEST) &
                (resultCode == Activity.RESULT_OK)){
            bitmap = (Bitmap) data.getExtras().get( "data");
            imageViewA.setImageBitmap(bitmap);
        }
    }
}
