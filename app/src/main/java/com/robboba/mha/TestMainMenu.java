package com.robboba.mha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class TestMainMenu extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main_menu);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i=0; i<mainGrid.getChildCount(); i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent = new Intent(getApplicationContext(), MedInfo.class);
                    startActivity(intent);*/
                    switch (v.getId()) {
                        case R.id.medInfoButton:
                            Intent intent9 = new Intent(getApplicationContext(), MedInfo.class);
                            startActivity(intent9);
                            break;
                        case R.id.moodEvalButton:
                            Intent intent10 = new Intent(getApplicationContext(), MoodEval.class);
                            startActivity(intent10);
                            break;
                        case R.id.medTrackButton:
                            Intent intent11 = new Intent(getApplicationContext(), PillTrack.class);
                            startActivity(intent11);
                            break;
                        case R.id.proInfoButton:
                            Intent intent12 = new Intent(getApplicationContext(), ProInfo.class);
                            startActivity(intent12);
                            break;
                        case R.id.userRepButton:
                            Intent intent13 = new Intent(getApplicationContext(), UserReport.class);
                            startActivity(intent13);
                            break;
                        case R.id.logOutButton:
                            Intent intent14 = new Intent(getApplicationContext(), LogIn.class);
                            startActivity(intent14);
                            break;
                    }
                }
            });
        }
    }
}
