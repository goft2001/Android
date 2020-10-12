package com.cookandroid.mid_b_002;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        String wants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox chk1 =(CheckBox)findViewById(R.id.chk1);
        final CheckBox chk2 =(CheckBox)findViewById(R.id.chk2);
        final CheckBox chk3 =(CheckBox)findViewById(R.id.chk3);
        final CheckBox chk4 =(CheckBox)findViewById(R.id.chk4);

        final EditText edt0 = (EditText)findViewById(R.id.edt0);

        final EditText edt1 =(EditText)findViewById(R.id.edt1);
        final EditText edt2 =(EditText)findViewById(R.id.edt2);
        final EditText edt3 =(EditText)findViewById(R.id.edt3);
        final EditText edt4 =(EditText)findViewById(R.id.edt4);

        Spinner spin = (Spinner)findViewById(R.id.spin);

        final TextView tv1 = (TextView)findViewById(R.id.tv1);
        final TextView tv2 = (TextView)findViewById(R.id.tv2);
        final TextView tv3 = (TextView)findViewById(R.id.tv3);

        Button btn1 = (Button)findViewById(R.id.btn1);

        ArrayAdapter<CharSequence>adapter =ArrayAdapter.createFromResource(this,R.array.wants_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               wants= parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

            chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(chk1.isChecked()){
                        edt1.setFocusableInTouchMode(true);

                    }else
                    {
                        edt1.setFocusable(false);
                        edt1.setText("");
                    }
                }
            });
            chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(chk2.isChecked()){
                        edt2.setFocusableInTouchMode(true);

                    }else
                    {
                        edt2.setFocusable(false);
                        edt2.setText("");
                    }
                }
            });

            chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(chk3.isChecked()){
                        edt3.setFocusableInTouchMode(true);

                    }else
                    {
                        edt3.setFocusable(false);
                        edt3.setText("");
                    }
                }
            });

            chk4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(chk4.isChecked()){
                        edt4.setFocusableInTouchMode(true);

                    }else
                    {
                        edt4.setFocusable(false);
                        edt4.setText("");
                    }
                }
            });



        btn1.setOnClickListener(new View.OnClickListener() {
            ArrayList<Integer> mid   =new ArrayList<Integer>();
            @Override
            public void onClick(View v) {
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0);
                int a0=0;//잠자기

                int a1=0;
                int a2=0;
                int a3=0;
                int a4=0;
                int sum=0;

                if(edt0.getText().toString().equals("")){
                    tv1.setText("1.나는 ?시간 잠을 잡니다!");

               new AlertDialog.Builder(MainActivity.this)
                            .setTitle("수면시간")
                            .setView(getLayoutInflater().inflate(R.layout.custom_layout,null)).show();

                }
                else{
                    String s0= edt0.getText().toString();
                    a0=Integer.parseInt(s0);
                    tv1.setText("1.나는 "+a0+" 시간 잠을 잡니다!");
                }

                if(chk1.isChecked()&&!edt1.getText().toString().equals("")) {
                    String s1 = edt1.getText().toString();
                    a1 = Integer.parseInt(s1);
                    mid.add(R.drawable.programming);

                }else a1=0;

                if(chk2.isChecked()&&!edt2.getText().toString().equals("")) {
                    String s2 = edt2.getText().toString();
                    a2 = Integer.parseInt(s2);
                    mid.add(R.drawable.book_reading);
                }else a2=0;

                if(chk3.isChecked()&&!edt3.getText().toString().equals("")) {
                    String s3 = edt3.getText().toString();
                    a3 = Integer.parseInt(s3);
                    mid.add(R.drawable.engligh_study);
                }else a3=0;

                if(chk4.isChecked()&&!edt4.getText().toString().equals("")) {
                    String s4 = edt4.getText().toString();
                    a4 = Integer.parseInt(s4);
                    mid.add(R.drawable.programming);
                }else a4=0;

                sum=a1+a2+a3+a4;

                tv2.setText("2.나는 꿈을 위해 " + sum + "시간 투자합니다");
                tv3.setText("3.나의 이상형은"+wants+" 입니다");

                GridView gv1=(GridView)findViewById(R.id.gridView);
                gv1.setAdapter(new ImageAdapter(MainActivity.this,mid));
            }
        });
    }
}