package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TestMainMenu extends AppCompatActivity {

    GridLayout mainGrid;

    // Start of putting in code for Firebase ****************************
    private static final String TAG = "MainMenu";
    private static final int RC_SIGN_IN = 9001;
    //private static final int LIMIT = 50; Specific to example length of List

    private FirebaseAuth mAuth;
    //private Query mQuery;
    //private FilterDialogFragment mFilterDialog;
    //private MainActivityViewModel mViewModel;

    // End of Code for Firebase *****************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main_menu);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i=0; i<mainGrid.getChildCount(); i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
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
                            Intent intent14 = new Intent(getApplicationContext(), LogIn.class);
                            startActivity(intent14);
                            break;
                    }
                }
            });
        }
    }

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
}
