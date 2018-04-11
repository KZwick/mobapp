package com.robboba.mha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class UserReport extends AppCompatActivity /*implements View.OnClickListener*/{

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView, dateView2;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_report);

        dateView = (TextView) findViewById(R.id.textView5);
        dateView2 = (TextView) findViewById(R.id.textView4);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        showDate2(year, month+1, day);

        //Button back = findViewById(R.id.backButton);

        //back.setOnClickListener(this);

        Spinner userSpin = (Spinner) findViewById(R.id.userSpinner);

        ArrayAdapter<CharSequence> userAdapter = ArrayAdapter.createFromResource(this, R.array.userName, android.R.layout.simple_spinner_item);

        userSpin.setAdapter(userAdapter);

        Spinner reportSpin = (Spinner) findViewById(R.id.reportSpinner);

        ArrayAdapter<CharSequence> reportAdapter = ArrayAdapter.createFromResource(this, R.array.report, android.R.layout.simple_spinner_item);

        reportSpin.setAdapter(reportAdapter);

        /*Spinner toMonthSpin = (Spinner) findViewById(R.id.toMonthSpinner);

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

        fromYearSpin.setAdapter(fromYearAdapter);*/
    }

    /*public void onClick (View view){
        switch (view.getId()){
            case R.id.backButton:
                Intent intent = new Intent(this, TestMainMenu.class);
                startActivity(intent);
                break;
        }
    }*/

    @SuppressWarnings("deprecation")
    public void setDate(View view){
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("deprecation")
    public void setDate2(View view){
        showDialog(998);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==999){
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        else if(id==998){
            return new DatePickerDialog(this, myDateListener2, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate(year, month, dayOfMonth);
        }
    };

    private DatePickerDialog.OnDateSetListener myDateListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate2(year, month, dayOfMonth);
        }
    };

    private void showDate(int year, int month, int day){
        dateView.setText(new StringBuilder().append(day).append("/").append(month+1).append("/").append(year));
    }

    private void showDate2(int year, int month, int day){
        dateView2.setText(new StringBuilder().append(day).append("/").append(month+1).append("/").append(year));
    }
}
