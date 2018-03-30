package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MoodEval extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_eval);

        Button back = findViewById(R.id.backButton);

        back.setOnClickListener(this);

        Spinner anxietySpin = (Spinner) findViewById(R.id.anxietySpinner);

        ArrayAdapter<CharSequence> anxietyAdapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);

        anxietySpin.setAdapter(anxietyAdapter);

        Spinner depressSpin = (Spinner) findViewById(R.id.depressionSpinner);

        ArrayAdapter<CharSequence> depressAdapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);

        depressSpin.setAdapter(depressAdapter);

        Spinner stressSpin = (Spinner) findViewById(R.id.stressSpinner);

        ArrayAdapter<CharSequence> stressAdapter = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);

        stressSpin.setAdapter(stressAdapter);
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
