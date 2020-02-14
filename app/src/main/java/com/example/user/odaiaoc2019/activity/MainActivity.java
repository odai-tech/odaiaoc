package com.example.user.odaiaoc2019.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.odaiaoc2019.R;
import com.example.user.odaiaoc2019.service.APIService;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1, properties definition
    EditText editTextEmail, editTextPassword;
    Button buttonLogIn, buttonSignUp;

    APIService service = APIService.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonLogIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogIn) {
            if (editTextEmail.getText().toString().equals("") || editTextPassword.getText().toString().equals("")) {
                Toast.makeText(this, "Empty Password or Email", Toast.LENGTH_LONG).show();
            } else {
//                Intent i = new Intent(this, HomePage.class);
//                i.putExtra("email", editTextEmail.getText().toString());
//                i.putExtra("password", editTextPassword.getText().toString());
//                startActivity(i);

                service.login(editTextEmail.getText().toString(), editTextPassword.getText().toString(), new APIService.Callbacks.LoginCallback() {
                    @Override
                    public void onLogin(FirebaseUser user) {
                        if (user != null) {
                            MainActivity.this.startActivity(new Intent(MainActivity.this, HomePage.class));
                        }
                    }
                });
            }

        } else {
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);

        }
    }
}