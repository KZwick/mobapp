package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MedInfo extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_info);

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
