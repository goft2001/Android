package com.cookandroid.Tracking_Check;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;import java.util.ArrayList;

public class RandomActivity extends AppCompatActivity {


        String[] array = {"koreaPic","chinaPic","westernPic"};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_random);
            setTitle("Random select");

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

    //옵션메뉴
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"지도 돌아가기");
        menu.add(0,2,0,"동선체크");
        menu.add(0,3,0,"코로나 실시간 현황");

        return  true;
    }

    //옵션메뉴 선택


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case 1:
                Intent on= new Intent(this,MapsActivity.class);
                startActivity(on);

                return true;
            case 2:
                Intent in = new Intent(this,TrackCheck.class);
                startActivity(in);

                return true;
            case 3:
                Intent ko = new Intent(this,MainActivity.class);
                startActivity(ko);

                return true;
        }
        return false;
    }


}
