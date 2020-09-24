package com.cookandroid.project11_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

        final String[] mid ={"히어로즈","24시","로스트","로스트룸","스몰빌","탐정몽크","빅뱅이론","" +
                "프렌즈","덱스터","글리","가쉽걸","테이큰","슈퍼내추럴","브이"};

        ListView list = (ListView)findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, //위치
                android.R.layout.simple_list_item_multiple_choice,  //디자인
                mid   //
                );
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, //포지션 - 위치
                                    long arg3) {

                Toast.makeText(MainActivity.this,mid[arg2],Toast.LENGTH_SHORT).show();
            }
        });
    }
}