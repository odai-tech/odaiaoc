package com.example.user.odaiaoc2019.service;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.user.odaiaoc2019.activity.HomePage;
import com.example.user.odaiaoc2019.activity.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class APIService {

    private static APIService service = new APIService();

    public static APIService getInstance() {
        return service;
    }

    private FirebaseAuth mAuth;

    private FirebaseFirestore db;

    private APIService() {
        this.mAuth = FirebaseAuth.getInstance();
        this.db = FirebaseFirestore.getInstance();
    }

    public void login(String email, String password, final Callbacks.LoginCallback callback) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    callback.onLogin(user);
                } else {
                    callback.onLogin(null);
                }
            }
        });
    }

    public void signUp(String email, String password, final String fullname, final String bloodType, final Callbacks.SignUpCallback callback) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {
                    callback.onFinishSignUp(null, "Something went wrong.");
                    return;
                }

                UserProfileChangeRequest r = new UserProfileChangeRequest
                        .Builder()
                        .setDisplayName(fullname)
                        .build();

                task.getResult().getUser().updateProfile(r);

                updateBloodType(bloodType);

                callback.onFinishSignUp(task.getResult().getUser(), null);
            }
        });
    }

    public void updateBloodType(String bloodType) {

        Log.d("APIService", "updateBloodType");
        if (mAuth.getCurrentUser() == null) {
            return;
        }

        Map<String, Object> obj = new HashMap<>();
        obj.put("blood_type", bloodType);
        obj.put("last_updated", new Date());


        String docId = "id_" + mAuth.getCurrentUser().getUid();

        db.collection("user_data")
                .document(docId)
                .set(obj);
    }

    public final static class Callbacks {

        public interface LoginCallback {
            void onLogin(FirebaseUser user);
        }

        public interface SignUpCallback {
            void onFinishSignUp(FirebaseUser user, String message);
        }
    }
}
