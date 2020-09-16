package com.example.exp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edit1,edit2;
    Button btnAdd,btnSub,btnMul,btnDiv,btnRem;
    TextView textResult;
    String num1,num2;
    Double result;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //바인딩
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);


        btnAdd=(Button) findViewById(R.id.BtnAdd); //바인딩 (위젯)
        btnSub=(Button) findViewById(R.id.BtnSub);
        btnMul=(Button) findViewById(R.id.BtnMul);
        btnDiv=(Button) findViewById(R.id.BtnDiv);
        btnRem=(Button) findViewById(R.id.BtnRem);

        textResult = (TextView) findViewById(R.id.TextResult);
        float v ;
        //이벤트 처리

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edit1.getText().toString().trim();
                num2=edit2.getText().toString().trim();

                if//둘 중 하나라도 공백이면
                (num1.equals("")||num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸 입력 됐음!",Toast.LENGTH_SHORT).show(); //(띄울위치,띄울말,뜨는길이
                }
                else//그렇지 않으면
                {
                    double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 :"+result);
                }

                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                textResult.setText("계산 결과 :"+result);


            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edit1.getText().toString().trim();
                num2=edit2.getText().toString().trim();


                double result = Double.parseDouble(num1) - Double.parseDouble(num2);
                textResult.setText("계산 결과 :"+result);

            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edit1.getText().toString().trim();
                num2=edit2.getText().toString().trim();

                if//둘 중 하나라도 공백이면
                (num1.equals("")||num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸 입력 됐음!",Toast.LENGTH_SHORT).show(); //(띄울위치,띄울말,뜨는길이
                }
                else//그렇지 않으면
                {
                    double result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 :"+result);
                }
                double result = Double.parseDouble(num1) * Double.parseDouble(num2);
                textResult.setText("계산 결과 :"+result);

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edit1.getText().toString().trim();
                num2=edit2.getText().toString().trim();

                if//둘 중 하나라도 공백이면
                (num1.equals("")||num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸 입력 됐음!",Toast.LENGTH_SHORT).show(); //(띄울위치,띄울말,뜨는길이
                }
                else//그렇지 않으면
                {
                    if(num2.equals("0")){
                        Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double result = Double.parseDouble(num1) / Double.parseDouble(num2);

                       result = (int)(result*100)/100.0;

                        textResult.setText("계산 결과 :" + result);
                    }
                }
                double result = Double.parseDouble(num1) / Double.parseDouble(num2);
                textResult.setText("계산 결과 :"+result);

            }
        });
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edit1.getText().toString().trim();
                num2=edit2.getText().toString().trim();

                if//둘 중 하나라도 공백이면
                (num1.equals("")||num2.equals("")){
                    Toast.makeText(MainActivity.this,"빈칸 입력 됐음!",Toast.LENGTH_SHORT).show(); //(띄울위치,띄울말,뜨는길이
                }
                else//그렇지 않으면
                {
                    double result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산 결과 :"+result);
                }
                double result = Double.parseDouble(num1) % Double.parseDouble(num2);
                textResult.setText("계산 결과 :"+result);

            }
        });



    }
}