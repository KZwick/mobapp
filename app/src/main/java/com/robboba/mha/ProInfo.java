package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ProInfo extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_info);

        Button back = findViewById(R.id.backButton);

        back.setOnClickListener(this);

        Spinner proSpin = (Spinner) findViewById(R.id.proSpinner);

        ArrayAdapter<CharSequence> proAdapter = ArrayAdapter.createFromResource(this, R.array.proName, android.R.layout.simple_spinner_item);

        proSpin.setAdapter(proAdapter);
    }

    public void onClick (View view){
        switch (view.getId()){
            case R.id.backButton:
                Intent intent = new Intent(this, TestMainMenu.class);
                startActivity(intent);
                break;
        }
    }
}
