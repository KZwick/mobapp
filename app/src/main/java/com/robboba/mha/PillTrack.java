package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PillTrack extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_track);

        Button back = findViewById(R.id.backButton);

        back.setOnClickListener(this);

        Spinner monthSpin = (Spinner) findViewById(R.id.monthSpinner);

        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);

        monthSpin.setAdapter(monthAdapter);

        Spinner daySpin = (Spinner) findViewById(R.id.daySpinner);

        ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_item);

        daySpin.setAdapter(dayAdapter);

        Spinner yearSpin = (Spinner) findViewById(R.id.yearSpinner);

        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);

        yearSpin.setAdapter(yearAdapter);

        Spinner medNameSpin = (Spinner) findViewById(R.id.medNameSpinner);

        ArrayAdapter<CharSequence> medNameAdapter = ArrayAdapter.createFromResource(this, R.array.medName, android.R.layout.simple_spinner_item);

        medNameSpin.setAdapter(medNameAdapter);

        Spinner dosTakenSpin = (Spinner) findViewById(R.id.dosageSpinner);

        ArrayAdapter<CharSequence> dosTakenAdapter = ArrayAdapter.createFromResource(this, R.array.dosTaken, android.R.layout.simple_spinner_item);

        dosTakenSpin.setAdapter(dosTakenAdapter);
    }

    public void onClick (View view){
        switch (view.getId()){
            case R.id.backButton:
                Intent intent = new Intent(this, MainMenu.class);
                startActivity(intent);
                break;
        }
    }
}
