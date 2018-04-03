package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button logIn = findViewById(R.id.submitButton);
        logIn.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.submitButton:
                Intent intent = new Intent(this, TestMainMenu.class);
                startActivity(intent);
        }
    }
}
