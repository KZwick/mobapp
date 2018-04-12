package com.robboba.mha;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.robboba.mha.model.Mood;

import java.util.Date;

public class MoodEval extends AppCompatActivity /*implements View.OnClickListener*/{

    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_eval);

        //Button back = findViewById(R.id.backButton);

        //back.setOnClickListener(this);

        Spinner anxietySpin = (Spinner) findViewById(R.id.anxietySpinner);

        ArrayAdapter<CharSequence> anxietyAdapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);

        anxietySpin.setAdapter(anxietyAdapter);

        Spinner depressSpin = (Spinner) findViewById(R.id.depressionSpinner);

        ArrayAdapter<CharSequence> depressAdapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);

        depressSpin.setAdapter(depressAdapter);

        Spinner stressSpin = (Spinner) findViewById(R.id.stressSpinner);

        ArrayAdapter<CharSequence> stressAdapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);

        stressSpin.setAdapter(stressAdapter);

        // Init FireStore
        mFirestore = FirebaseFirestore.getInstance();
    }

    /*public void onClick (View view){
        switch (view.getId()){
            case R.id.backButton:
                Intent intent = new Intent(this, TestMainMenu.class);
                startActivity(intent);
                break;
        }
    }*/

    public void clear(View v){

    }

    public void clickSubmit(View view){
        submitData(view);
    }

    private void submitData(View view){
        //Log.v("Mood","Started the sumbitData");
        // Convert input data to Strings and java.util.Date
        java.util.Date dateCurrent = new Date(); // gets the current time.
        Spinner spinAnxiety =(Spinner) findViewById(R.id.anxietySpinner);
        String sAnxiety = spinAnxiety.getSelectedItem().toString();
        Spinner spinStress=(Spinner) findViewById(R.id.stressSpinner);
        String sStress = spinStress.getSelectedItem().toString();
        Spinner spinDepress=(Spinner) findViewById(R.id.depressionSpinner);
        String sDepress = spinDepress.getSelectedItem().toString();
        String sRadio = "";

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.goodRadioButton){
            sRadio = "Good"; }
        if (checkedRadioButtonId == R.id.medRadioButton){
            sRadio = "Fair"; }
        if (checkedRadioButtonId == R.id.badRadioButton){
            sRadio = "Bad"; }
        //Log.v("Mood","Got the Data including Radio Button");

        // get the current user and their email
        FirebaseUser mUser= FirebaseAuth.getInstance().getCurrentUser();
        String mUserEmail = mUser.getEmail();

        // put the input data into the Model
        Mood oMood = new Mood();
        oMood.setDate(dateCurrent);
        oMood.setMoodlvl(sRadio);
        oMood.setAnxietylvl(sAnxiety);
        oMood.setStresslvl(sStress);
        oMood.setDepressionlvl(sDepress);
        Log.v("Mood","Moved the data to the Mood Object: "+oMood);

        // the document using their email, then collection "Moods"
        CollectionReference UserMoods = mFirestore.collection("Users")
                .document(mUserEmail).collection("Moods");
        Log.v("Mood","Moved the data to the Mood Object: "+oMood+" email: "+mUserEmail+ " ColRef: "+UserMoods);

        // add the data to the above sub collection
        UserMoods.add(oMood);

        Toast.makeText(this, "Mood Added", Toast.LENGTH_LONG).show();
    }

}
