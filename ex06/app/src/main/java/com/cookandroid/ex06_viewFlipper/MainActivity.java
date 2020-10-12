package com.cookandroid.ex06_viewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrev,btnNext;
        final ViewFlipper vFlipper;

        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnNext = (Button)findViewById(R.id.btnNext);

        vFlipper = (ViewFlipper)findViewById((R.id.viewFilpper1));



        btnPrev.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.startFlipping();
                vFlipper.setFlipInterval(1000);
            }
        }));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });
    }
}