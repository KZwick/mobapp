package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class UserReport extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_report);

        Button back = findViewById(R.id.backButton);

        back.setOnClickListener(this);

        Spinner userSpin = (Spinner) findViewById(R.id.userSpinner);

        ArrayAdapter<CharSequence> userAdapter = ArrayAdapter.createFromResource(this, R.array.userName, android.R.layout.simple_spinner_item);

        userSpin.setAdapter(userAdapter);

        Spinner reportSpin = (Spinner) findViewById(R.id.reportSpinner);

        ArrayAdapter<CharSequence> reportAdapter = ArrayAdapter.createFromResource(this, R.array.report, android.R.layout.simple_spinner_item);

        reportSpin.setAdapter(reportAdapter);

        Spinner toMonthSpin = (Spinner) findViewById(R.id.toMonthSpinner);

        ArrayAdapter<CharSequence> toMonthAdapter = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);

        toMonthSpin.setAdapter(toMonthAdapter);

        Spinner toDaySpin = (Spinner) findViewById(R.id.toDaySpinner);

        ArrayAdapter<CharSequence> toDayAdapter = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_item);

        toDaySpin.setAdapter(toDayAdapter);

        Spinner toYearSpin = (Spinner) findViewById(R.id.toYearSpinner);

        ArrayAdapter<CharSequence> toYearAdapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);

        toYearSpin.setAdapter(toYearAdapter);

        Spinner fromMonthSpin = (Spinner) findViewById(R.id.fromMonthSpinner);

        ArrayAdapter<CharSequence> fromMonthAdapter = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);

        fromMonthSpin.setAdapter(fromMonthAdapter);

        Spinner fromDaySpin = (Spinner) findViewById(R.id.fromDaySpinner);

        ArrayAdapter<CharSequence> fromDayAdapter = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_item);

        fromDaySpin.setAdapter(fromDayAdapter);

        Spinner fromYearSpin = (Spinner) findViewById(R.id.fromYearSpinner);

        ArrayAdapter<CharSequence> fromYearAdapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);

        fromYearSpin.setAdapter(fromYearAdapter);
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
