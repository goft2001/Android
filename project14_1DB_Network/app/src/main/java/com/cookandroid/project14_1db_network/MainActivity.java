package com.cookandroid.project14_1db_network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.cookandroid.project14_1db_network.Network.NetworkGet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button refreshBtn, addBtn;
    private ListView listView;
    private Custom_Adaper adaper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView  = (ListView)findViewById(R.id.listView);
        adaper = new Custom_Adaper(MainActivity.this, R.layout.adapter_userinfo,new ArrayList<UserInfo>());
        listView.setAdapter(adaper);

        refreshBtn = (Button)findViewById(R.id.btnRefresh);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkGet((Custom_Adaper) listView.getAdapter()).execute("");

            }
        });
        addBtn = (Button)findViewById(R.id.btn_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = getLayoutInflater().inflate(R.layout.dialog_add,null);
                
            }
        });
    }
}

//6페이지 까지 했음