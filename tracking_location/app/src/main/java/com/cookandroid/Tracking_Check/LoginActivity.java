package com.cookandroid.Tracking_Check;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cookandroid.Tracking_Check.Network.JoinInsert;
import com.cookandroid.Tracking_Check.Network.loginSelect;

public class LoginActivity extends AppCompatActivity {

    private Button Join_Btn,login_Btn;
    private EditText edtID, edtPw;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Here!");

        edtID = (EditText)findViewById  (R.id.edt_id);
        edtPw = (EditText)findViewById  (R.id.edt_pw);


        //회원가입 버튼!!

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
                                String phone = ((EditText)v.findViewById(R.id.edt_phone)).getText().toString();
                                String pwd = ((EditText)v.findViewById  (R.id.edt_pw)).getText().toString();

                                new JoinInsert(LoginActivity.this).execute(id,name,phone,pwd);
                                 }
                               })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                        .setCancelable(false)
                        .show();
            }
        });

        //로그인 버튼!!
        login_Btn=(Button)findViewById(R.id.btn_login);
        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new loginSelect(LoginActivity.this).execute(edtID.getText().toString(), edtPw.getText().toString());

//             if(id.equals()) {
//                 Intent in = new Intent(LoginActivity.this,
//                         MapsActivity.class);
//                 startActivity(in);
//             }else {
//                 Toast.makeText(LoginActivity.this, "ID, PWD 를 확인해 주세요.", Toast.LENGTH_SHORT).show();
//             }
            }
        });


    }


}