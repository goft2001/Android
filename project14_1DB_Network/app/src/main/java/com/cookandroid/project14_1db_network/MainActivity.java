package com.cookandroid.project14_1db_network;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.cookandroid.project14_1db_network.Network.NetworkGet;
import com.cookandroid.project14_1db_network.Network.NetworkInsert;

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
                                  public void onClick(View view) {
                                      new NetworkGet((Custom_Adaper) listView.getAdapter()).execute("");
                                  }
                              });
        addBtn=(Button)findViewById(R.id.btn_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = getLayoutInflater().inflate(R.layout.dialog_add, null);
                new AlertDialog.Builder(MainActivity.this).setTitle("멤버추가")
                        .setView(v).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String id = ((EditText)v.findViewById(R.id.edtID)).getText().toString();
                        String name = ((EditText)v.findViewById(R.id.edtName)).getText().toString();
                        String phone = ((EditText)v.findViewById(R.id.edtPhone)).getText().toString();
                        String grade = ((EditText)v.findViewById(R.id.edtGrade)).getText().toString();

                        new NetworkInsert(adaper).execute(id,name, phone, grade);

                    }
                }).
                   setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                  .setCancelable(false).show();
            }
        });

        new NetworkGet((Custom_Adaper)listView.getAdapter()).execute("");       //전체불러오기

    }
}


