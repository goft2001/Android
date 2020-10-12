package com.cookandroid.mid_b_001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText edt1 = (EditText)findViewById(R.id.edt1);
        final EditText edt2 = (EditText)findViewById(R.id.edt2);
        final  EditText edt3 = (EditText)findViewById(R.id.edt3);

        final TextView tv1 = (TextView)findViewById(R.id.tv1);

        Button btn1=(Button)findViewById(R.id.btn1);

        RadioGroup.OnCheckedChangeListener rLis = new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton) group.findViewById(checkedId);
                tv1.setText(rb.getText());
            }
        };

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rbGroup);

        radioGroup.setOnCheckedChangeListener(rLis);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0);

                if (tv1.getText().toString().equals("op")|| edt1.getText().toString().equals("") || edt2.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"수를 입력해 주세요.",Toast.LENGTH_SHORT).show();

                }



                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();

                double a1 = Double.parseDouble(str1);
                double a2 = Double.parseDouble(str2);
                double a3 = 0;

                String op = tv1.getText().toString();

                if (op.equals("+"))
                    a3=a1+a2;


               else if (op.equals("-"))
                    a3=a1-a2;


                else  if (op.equals("*"))
                    a3=a1*a2;


                else if (op.equals("/"))
                    a3=a1/a2;

                edt3.setText(String.valueOf(a3));

            }
        });

    }
}