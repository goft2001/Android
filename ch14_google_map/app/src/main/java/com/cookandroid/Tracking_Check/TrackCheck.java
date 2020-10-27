package com.cookandroid.Tracking_Check;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class TrackCheck extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_check);
        setTitle("간단 일기장");

        dp=(DatePicker) findViewById(R.id.datePicker1);
        edtDiary=(EditText)findViewById(R.id.edtDiary);
        btnWrite=(Button)findViewById(R.id.btnWrite);


        Calendar cal = java.util.Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay    = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year)+"_"+Integer.toString(monthOfYear+1)+"_"+Integer.toString(dayOfMonth)+".txt";

                Toast.makeText(TrackCheck.this,fileName,Toast.LENGTH_SHORT).show();

                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str =edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();

                    Toast.makeText(getApplicationContext(),fileName+"이 저장됨",Toast.LENGTH_SHORT).show();

                } catch (IOException e) {

                }

            }
        });

    }

    //옵션메뉴
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"위성지도");
        menu.add(0,2,0,"일반지도");
        menu.add(0,3,0,"동선체크");


        return  true;
    }

    //옵션메뉴 선택


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                Intent in = new Intent(this,TrackCheck.class);
                startActivity(in);

                return true;
        }
        return false;
    }


    // 다이어리 읽기
    private String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");

        } catch (IOException e) {
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;

    };



}