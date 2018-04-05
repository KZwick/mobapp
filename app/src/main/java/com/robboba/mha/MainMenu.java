package com.robboba.mha;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Collections;

/******
package com.google.firebase.example.fireeats;
 import com.firebase.ui.auth.AuthUI;
 import com.google.firebase.auth.FirebaseAuth; ********************************Done
 import com.google.firebase.example.fireeats.adapter.RestaurantAdapter;
 import com.google.firebase.example.fireeats.model.Restaurant;
 import com.google.firebase.example.fireeats.util.RestaurantUtil;
 import com.google.firebase.example.fireeats.viewmodel.MainActivityViewModel;
 import com.google.firebase.firestore.CollectionReference;  firestore is project nickname.
 import com.google.firebase.firestore.DocumentSnapshot;
 import com.google.firebase.firestore.FirebaseFirestore;
 import com.google.firebase.firestore.FirebaseFirestoreException;
 import com.google.firebase.firestore.Query;
 //import com.google.firebase.MHA.Query;                    MHA is project nickname;
*/

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main_menu);

        //Firebase part
        mAuth = FirebaseAuth.getInstance();


        Button medInfo = findViewById(R.id.medInfoButton);
        Button moodEval = findViewById(R.id.moodEvalButton);
        Button medTrack = findViewById(R.id.medTrackButton);
        Button proInfo = findViewById(R.id.proInfoButton);
        Button userRep = findViewById(R.id.userRepButton);
        Button logOut = findViewById(R.id.logOutButton);

        medInfo.setOnClickListener(this);
        moodEval.setOnClickListener(this);
        medTrack.setOnClickListener(this);
        proInfo.setOnClickListener(this);
        userRep.setOnClickListener(this);
        logOut.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.medInfoButton:
                Intent intent9 = new Intent(this, MedInfo.class);
                startActivity(intent9);
                break;
            case R.id.moodEvalButton:
                Intent intent10 = new Intent(this, MoodEval.class);
                startActivity(intent10);
                break;
            case R.id.medTrackButton:
                Intent intent11 = new Intent(this, PillTrack.class);
                startActivity(intent11);
                break;
            case R.id.proInfoButton:
                Intent intent12 = new Intent(this, ProInfo.class);
                startActivity(intent12);
                break;
            case R.id.userRepButton:
                Intent intent13 = new Intent(this, UserReport.class);
                startActivity(intent13);
                break;
            case R.id.logOutButton:
                Intent intent14 = new Intent(this, LogIn.class);
                startActivity(intent14);
                break;
        }
    }


    // Firebase stuff added
    private void showLogin(View view) {
        Intent intent = new Intent(this,FireLogIn.class);
        startActivity(intent);
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