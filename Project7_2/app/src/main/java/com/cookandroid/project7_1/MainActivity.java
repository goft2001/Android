package com.cookandroid.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
        LinearLayout baseLayout;
        Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);
        button1 =(Button)findViewById(R.id.button1);

    }
 //   1.옵션메뉴 만들기(create) -방법 1: xml로 디자인(추천방법)

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
//1. 옵션메뉴만들기(create) - 방법 2 :java로 디자인 (비선호)
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0,1,0,"배경색(빨강)");
//        menu.add(0,2,0,"배경색(파랑)");
//        menu.add(0,3,0,"배경색(초록)");
//
//        SubMenu sMenu = menu.addSubMenu("버튼변경");
//        sMenu.add(0,4,0,"크기2배");
//        sMenu.add(0,5,0,"회전45도");
//
//        return super.onCreateOptionsMenu(menu);
//    }






    //2.옵션메뉴 이벤트 처리
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch  (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.subRotate:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
                button1.setScaleX(2);
                return true;
        }
            return false;

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch  (item.getItemId()) {
//            case 1:
//                baseLayout.setBackgroundColor(Color.RED);
//                return true;
//            case 2:
//                baseLayout.setBackgroundColor(Color.BLUE);
//                return true;
//            case  3:
//                baseLayout.setBackgroundColor(Color.GREEN);
//                return true;
//            case 4:
//                button1.setRotation(45);
//                return true;
//            case  5:
//                button1.setScaleX(2);
//                return true;
//        }
//        return false;
//


    }
}
