package com.robboba.mha;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class PillTrack extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener{

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_track);

        Button back = findViewById(R.id.backButton);

        back.setOnClickListener(this);

        mTextView = findViewById(R.id.textView5);

        Button button = (Button) findViewById(R.id.remindButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker =  new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        /*Spinner monthSpin = (Spinner) findViewById(R.id.monthSpinner);

        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);

        monthSpin.setAdapter(monthAdapter);

        Spinner daySpin = (Spinner) findViewById(R.id.daySpinner);

        ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_item);

        daySpin.setAdapter(dayAdapter);

        Spinner yearSpin = (Spinner) findViewById(R.id.yearSpinner);

        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);

        yearSpin.setAdapter(yearAdapter);*/

        Spinner medNameSpin = (Spinner) findViewById(R.id.medNameSpinner);

        ArrayAdapter<CharSequence> medNameAdapter = ArrayAdapter.createFromResource(this, R.array.medName, android.R.layout.simple_spinner_item);

        medNameSpin.setAdapter(medNameAdapter);

        Spinner dosTakenSpin = (Spinner) findViewById(R.id.dosageSpinner);

        ArrayAdapter<CharSequence> dosTakenAdapter = ArrayAdapter.createFromResource(this, R.array.dosTaken, android.R.layout.simple_spinner_item);

        dosTakenSpin.setAdapter(dosTakenAdapter);

        Button buttonCancelRem = findViewById(R.id.cancelRem);

        buttonCancelRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }

    public void onClick (View view){
        switch (view.getId()){
            case R.id.backButton:
                Intent intent = new Intent(this, TestMainMenu.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
    }

    private void updateTimeText(Calendar c){
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }

    private void startAlarm(Calendar c){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm Cancelled");
    }
}
