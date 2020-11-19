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
    EditText edtCheck;
    Button btnWrite;
    String fileName;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_check);
        setTitle("날짜별 동선");

        dp=(DatePicker) findViewById(R.id.datePicker1);
        edtCheck=(EditText)findViewById(R.id.edtCheck);
        btnWrite=(Button)findViewById(R.id.btnWrite);


        Calendar cal = java.util.Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay    = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            //파일 이름 생성
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year)+"_"+Integer.toString(monthOfYear+1)+"_"+Integer.toString(dayOfMonth)+".txt";

              //  Toast.makeText(TrackCheck.this,fileName,Toast.LENGTH_SHORT).show();

                String str = readCheck(fileName);
                edtCheck.setText(str);
                btnWrite.setEnabled(true);
            }
        });
        //저장하기 버튼
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str =edtCheck.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();

                    Toast.makeText(getApplicationContext(),fileName+"이 저장되었습니다.",Toast.LENGTH_SHORT).show();

                } catch (IOException e) {

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
//                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 2:
                Intent in = new Intent(this,TrackCheck.class);
                startActivity(in);
                return true;

            case 3:
                Intent un = new Intent(this,MainActivity.class);
                startActivity(un);

                return true;


        }
        return false;
    }


    // 다이어리 읽기
    private String readCheck(String fName) {
        String checkStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            checkStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");

        } catch (IOException e) {
            edtCheck.setHint("나의 동선을 적어주세요.");
            btnWrite.setText("새로 저장");
        }
        return checkStr;

    };



}