package com.cookandroid.yangbangactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");


        final RadioGroup rg1 =(RadioGroup)findViewById(R.id.rg1);

        //radio 바인딩
//        Button btnAdd = (Button)findViewById(R.id.btnAdd);
//        Button btnMul = (Button)findViewById(R.id.btnMul );
//        Button btnDiv = (Button)findViewById(R.id.btnDiv);
//        Button btnSub = (Button)findViewById(R.id.btnSub);
        //버튼 바인딩
        Button btnNewActivity = (Button)findViewById(R.id.btnNewActivity);


        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNum1=(EditText)findViewById(R.id.edtNum1);
                EditText edtNum2=(EditText)findViewById(R.id.edtNum2);
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));

                switch (rg1.getCheckedRadioButtonId())
                {
                    case R.id.btnAdd :
                        intent.putExtra("Operator","+");
                        break;
                    case R.id.btnMul :
                        intent.putExtra("Operator","-");
                        break;

                    case R.id.btnDiv :
                        intent.putExtra("Operator","*");
                        break;

                    case R.id.btnSub :
                        intent.putExtra("Operator","/");
                        break;
                }

                startActivityForResult(intent,0);

            }
        });

//
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap",0);
            Toast.makeText(getApplicationContext(), "합계"+hap,Toast.LENGTH_SHORT).show();
        }
    }
}

