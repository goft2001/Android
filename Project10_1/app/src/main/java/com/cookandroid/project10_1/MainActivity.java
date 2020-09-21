package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button btn1 = (Button) findViewById(R.id.btn1);
//        Button btn2 = (Button) findViewById(R.id.btn2);

        final RadioButton rdo1 = (RadioButton) findViewById(R.id.rdo1);

        Button btn0 = (Button) findViewById(R.id.btn0);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rdo1.isChecked() ==true)
                {
                    Intent in = new Intent(MainActivity.this,
                            MainActivity2.class);

                    startActivity(in);
                }
                else
                {
                    Intent in = new Intent(MainActivity.this,
                            MainActivity3.class);

                    startActivity(in);
                }

            }
        });


//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(MainActivity.this,
//                        MainActivity2.class);
//
//                startActivity(in);
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(MainActivity.this,
//                        MainActivity3.class);
//
//                startActivity(in);
//            }
//        });
    }
}






