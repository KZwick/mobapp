package com.robboba.mha;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

/**
 * Created by kevin on 2018-04-10.
 */

public class MedsList extends AppCompatActivity {

    // for Firestore
    private FirebaseFirestore mFirestore;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private Query mQuery;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        // Initialize Firebase
        mAuth = FirebaseAuth.getInstance();
        // Initialize Firestore
        mFirestore = FirebaseFirestore.getInstance();
        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);
        // Getting the firebase user
        mUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}
