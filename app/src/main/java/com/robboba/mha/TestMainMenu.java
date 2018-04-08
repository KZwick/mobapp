package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.robboba.mha.model.SimpleUser;

import java.util.Collections;

public class TestMainMenu extends AppCompatActivity {

    GridLayout mainGrid;

    // Start of putting in code for Firebase ****************************
    private static final String TAG = "MainMenu";
    private static final int RC_SIGN_IN = 9001;
    //private static final int LIMIT = 50; //Specific to example length of List

    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;
    private FirebaseUser mUser;
    private Query mQuery;
    private SimpleUser sUser = new SimpleUser();
    //private FilterDialogFragment mFilterDialog;
    //private MainActivityViewModel mViewModel;
    //private TestMainMenuViewModel mViewModel;

    // End of Code for at start *****************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main_menu);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

        // init firebase
        mAuth = FirebaseAuth.getInstance();
        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);
        // Getting the firebase user, puttting data in (SimpleUser) sUser
        getUser();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUser();
    }

    private void getUser(){
        mUser=FirebaseAuth.getInstance().getCurrentUser();
        if (mUser != null) {
            String UserName = mUser.getDisplayName();
            sUser.setName(UserName);
            String UserEmail = mUser.getEmail();
            sUser.setEmail(UserEmail);
            TextView UserTextView = findViewById(R.id.textViewUser);
            // update the Text View
            UserTextView.setText(UserEmail);
            // add the user to the database.
            //addUser();
        }
    }

    private void addUser(){
        // Get a reference to the Users collection
        CollectionReference Users = mFirestore.collection("Users");

        // Add a new document to the restaurants collection
        Users.add(sUser);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // Start sign in if necessary
        if (shouldStartSignIn()) {
            startSignIn();
            return;
        }
    }

    private boolean shouldStartSignIn() {
        //return (!mViewModel.getIsSigningIn() && FirebaseAuth.getInstance().getCurrentUser() == null);
        return (FirebaseAuth.getInstance().getCurrentUser() == null);
    }

    private void startSignIn() {
        // Sign in with FirebaseUI
        Intent intent = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(Collections.singletonList(
                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                .setIsSmartLockEnabled(false)
                .build();

        startActivityForResult(intent, RC_SIGN_IN);
        //mViewModel.setIsSigningIn(true);
    }

    public void onClickTextUser(View view){
        //Toast.makeText(this, "Started Click User", Toast.LENGTH_SHORT).show();
        startSignIn();
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent = new Intent(getApplicationContext(), MedInfo.class);
                    startActivity(intent);*/
                    switch (v.getId()) {
                        case R.id.medInfoButton:
                            Intent intent9 = new Intent(getApplicationContext(), MedInfo.class);
                            startActivity(intent9);
                            break;
                        case R.id.moodEvalButton:
                            Intent intent10 = new Intent(getApplicationContext(), MoodEval.class);
                            startActivity(intent10);
                            break;
                        case R.id.medTrackButton:
                            Intent intent11 = new Intent(getApplicationContext(), PillTrack.class);
                            startActivity(intent11);
                            break;
                        case R.id.proInfoButton:
                            Intent intent12 = new Intent(getApplicationContext(), ProInfo.class);
                            startActivity(intent12);
                            break;
                        case R.id.userRepButton:
                            Intent intent13 = new Intent(getApplicationContext(), UserReport.class);
                            startActivity(intent13);
                            break;
                        case R.id.logOutButton:
                            //Intent intent14 = new Intent(getApplicationContext(), LogIn.class);
                            //startActivity(intent14);
                            startSignIn();
                            break;
                        case R.id.textViewUser:
                            startSignIn();
                            break;
                    }
                }
            });
        }


    }
}
//**************************************************************************************************
// in OnStart()
/* // Apply filters
        onFilter(mViewModel.getFilters());

        // Start listening for Firestore updates
        if (mAdapter != null) {
            mAdapter.startListening();
        } */

    /* this is from the example Friendly Eats ie Fire Store
    private boolean shouldStartSignIn() {
        return (!mViewModel.getIsSigningIn() && FirebaseAuth.getInstance().getCurrentUser() == null);
    }

    private void startSignIn() {
        // Sign in with FirebaseUI
        Intent intent = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(Collections.singletonList(
                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                .setIsSmartLockEnabled(false)
                .build();

        startActivityForResult(intent, RC_SIGN_IN);
        mViewModel.setIsSigningIn(true);
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
                    user.getEmail(), user.isEmailVerified()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
            findViewById(R.id.email_password_fields).setVisibility(View.GONE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.VISIBLE);

            findViewById(R.id.verify_email_button).setEnabled(!user.isEmailVerified());
        } else {
            mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.GONE);
        }
    }*/

/*  @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }*/
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_items:
                onAddItemsClicked();
                break;
            case R.id.menu_sign_out:
                AuthUI.getInstance().signOut(this);
                startSignIn();
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

 /*
    private void initFirestore() {
        // Done(developer): Implement
        mFirestore = FirebaseFirestore.getInstance();

        // Get the 50 highest rated restaurants
        mQuery = mFirestore.collection("restaurants")
                .orderBy("avgRating", Query.Direction.DESCENDING)
                .limit(LIMIT);
    }*/

// Enable Firestore logging
//FirebaseFirestore.setLoggingEnabled(true);

//initFirestore();
//initRecyclerView();
