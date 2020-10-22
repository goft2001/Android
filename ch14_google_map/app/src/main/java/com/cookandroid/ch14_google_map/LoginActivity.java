package com.cookandroid.ch14_google_map;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cookandroid.ch14_google_map.Network.JoinInsert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private EditText id,pwd,phone,name;
    private Button Join_Btn,login;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Join_Btn=(Button)findViewById(R.id.btn_join);
        Join_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = getLayoutInflater().inflate(R.layout.activity_join,null);
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("회원 가입")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String id = ((EditText)v.findViewById   (R.id.edt_id)).getText().toString();
                                String name = ((EditText)v.findViewById (R.id.edt_name)).getText().toString();
                                String phone = ((EditText)v.findViewById(R.id.edt_number)).getText().toString();
                                String pwd = ((EditText)v.findViewById  (R.id.edt_pw)).getText().toString();

                                new JoinInsert(id,pwd,name,phone).execute(id,name,phone,pwd);
                            }
                        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                        .setCancelable(false)
                        .show();
            }
        });


        login=(Button)findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             if(id!=null&&pwd!=null) {
                 Intent in = new Intent(LoginActivity.this,
                         MapsActivity.class);
                 startActivity(in);
             }else{
                 Toast.makeText(LoginActivity.this, "id,pwd를 확인해 주세요.", Toast.LENGTH_SHORT).show();
             }
            }
        });


    }


}