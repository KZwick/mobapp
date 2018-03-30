package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

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

    public void onClick(View view){
        switch (view.getId()){
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
}
