package com.cookandroid.project_midtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String[] array = {"koreaPic","chinaPic","westernPic"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("랜덤 점심 게임");

        Button btnPrev,btnNext;
        final ViewFlipper koreaPic,chinaPic,westernPic;


        //시작하기 , 스탑
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);

        //뷰 플리퍼 버튼 바인딩
         koreaPic = (ViewFlipper)findViewById((R.id.koreaPic));
         chinaPic = (ViewFlipper) findViewById((R.id.chinaPic));
         westernPic = (ViewFlipper) findViewById((R.id.westernPic));

        // 라디오 버튼 바인딩
        RadioGroup rdoG1=(RadioGroup)findViewById(R.id.rdoG1);
        final RadioButton korea = (RadioButton) findViewById(R.id.korea);
        final RadioButton china = (RadioButton) findViewById(R.id.china);
        final RadioButton western = (RadioButton) findViewById(R.id.western);




        rdoG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(korea.isChecked()) {
                    koreaPic.setVisibility(View.VISIBLE);
                    chinaPic.setVisibility(View.INVISIBLE);
                    westernPic.setVisibility(View.INVISIBLE);

               }
                if(china.isChecked()){
                    koreaPic.setVisibility(View.INVISIBLE);
                    chinaPic.setVisibility(View.VISIBLE);
                    westernPic.setVisibility(View.INVISIBLE);

                }

                if(western.isChecked()){
                    koreaPic.setVisibility(View.INVISIBLE);
                    chinaPic.setVisibility(View.INVISIBLE);
                    westernPic.setVisibility(View.VISIBLE);

                }
            }
        });

        //플리퍼 재생, 스탑
        btnPrev.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(korea.isChecked()) {
                    koreaPic.startFlipping();
                    koreaPic.setFlipInterval(10);
                }
                if(china.isChecked()) {
                    chinaPic.startFlipping();
                    chinaPic.setFlipInterval(10);
                }
                if(western.isChecked()) {
                    westernPic.startFlipping();
                    westernPic.setFlipInterval(10);
                }
            }

        }));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(korea.isChecked()) {
                    koreaPic.stopFlipping();
                }
                if(china.isChecked()) {
                    chinaPic.stopFlipping();
                }
                if(western.isChecked()) {
                    westernPic.stopFlipping();
                }
            }
        });
        }

    }


