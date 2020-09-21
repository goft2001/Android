package com.cookandroid.yangbangactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent  = getIntent();
//        final int hapValue =inIntent.getIntExtra("Num1",0)+inIntent.getIntExtra("Num2",0);

        String op = inIntent.getStringExtra("Operator");

        int hapValue=0;

        if(op.equals("+"))
        {
            hapValue = inIntent.getIntExtra("Num1", 0)
                    - inIntent.getIntExtra("Num2", 0);
        }
        else if(op.equals("-"))
        {
            hapValue = inIntent.getIntExtra("Num1", 0)
                    * inIntent.getIntExtra("Num2", 0);
        }
        else if(op.equals("*"))
        {
            hapValue = inIntent.getIntExtra("Num1", 0)
                    * inIntent.getIntExtra("Num2", 0);
        }
        else if(op.equals("/"))
        {
            hapValue = inIntent.getIntExtra("Num1", 0)
                    / inIntent.getIntExtra("Num2", 0);
        }

        Button btnReturn =(Button)findViewById(R.id.btnReturn);
        final int final_hap = hapValue;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class)   ;
                outIntent.putExtra("Hap",final_hap);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });

    }


}