package com.cookandroid.day03_exp01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.파라미터(속성)준비, 레이아웃 만들기 전에
        //2.레이아웃 만들기
        //3.레이아웃 속성 정하기
   //setContentView(R.layout.activity_main);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
   //Layout설정
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(0,255,0));
        setContentView(baseLayout,params); //찾아볼것 contentView
    // EditText
        edit = new EditText(this);
        edit.setBackgroundColor(Color.WHITE);
        edit.setHint("입력하세요");
        baseLayout.addView(edit);
    //Button
        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn);
     //TextView
        view = new TextView(this);
        view.setText("텍스트뷰입니다.");
        baseLayout.addView(view);
    //Button Event
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                view.setText(edit.getText());
            }





        });
    }
}