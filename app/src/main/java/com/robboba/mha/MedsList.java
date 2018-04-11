package com.robboba.mha;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
//import com.google.api.core.ApiFutures;

/**
 * Created by kevin on 2018-04-10.
 */

public class MedsList extends AppCompatActivity {

    // for Firestore
    private FirebaseFirestore mFirestore;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private Query mQuery;
    private static int LIMIT = 30;

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

    private void GetMedListQuery(){
        FirebaseUser mUser= FirebaseAuth.getInstance().getCurrentUser();
        String mUserEmail = mUser.getEmail();

        // Create a reference to the Medications collection
        CollectionReference UserMeds = mFirestore.collection("Users")
                .document(mUserEmail).collection("Medications");

        mQuery = UserMeds.orderBy("medname", Query.Direction.DESCENDING)
                .limit(LIMIT);

        //ApiFuture<QuerySnapshot> querySnapshot = mQuery.get();

        Log.v("potato",mQuery.);

        // Get the 50 highest rated restaurants
        /*
        mQuery = mFirestore.collection("restaurants")
                .orderBy("avgRating", Query.Direction.DESCENDING)
                .limit(LIMIT); */

    }
}
