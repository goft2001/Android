package com.cookandroid.mid_a_002;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String gender ="여자";
    String blood = "A";

    double height = 0;
    double weight = 0;
    double bmi =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1 = (EditText)findViewById(R.id.edt1);
        final EditText edt2 = (EditText)findViewById(R.id.edt2);

        final RadioButton rb1 = (RadioButton)findViewById(R.id.rb1);
        final RadioButton rb2 = (RadioButton)findViewById(R.id.rb2);

        final Spinner spinner = (Spinner)findViewById(R.id.spin1);
        final Gallery gallery = (Gallery)findViewById(R.id.ga1);

        final CheckBox chk1 = (CheckBox)findViewById(R.id.chk1);
        final CheckBox chk2 = (CheckBox)findViewById(R.id.chk2);
        final CheckBox chk3 = (CheckBox)findViewById(R.id.chk3);

        final TextView tv1 = (TextView)findViewById(R.id.tv1);
        final TextView tv2 = (TextView)findViewById(R.id.tv2);
        Button btn1 = (Button)findViewById(R.id.btn1);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
              gender=  rb.getText().toString();
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RadioButton rb = (RadioButton) v;
               gender= rb.getText().toString();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.blood_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                blood = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(),0   );
                    ArrayList<Integer> mThumids = new ArrayList<Integer>();



                    if(edt1.getText().toString().equals("")||edt2.getText().toString().equals("")){
                        tv2.setText("2.신체질량지수는 ?입니다!");

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("키와 체중")
                                .setView(getLayoutInflater().inflate(R.layout.custom_dialog,null))
                                .show();
                    }
                    else{
                        String str1=edt1.getText().toString();
                        String str2 = edt2.getText().toString();

                         height=Double.parseDouble(str1);
                         weight=Double.parseDouble(str2);

                        bmi = weight/((height/100)*(height/100));
                        tv2.setText("2.신체질량지수는 " +Math.round(bmi*10)/10F+ " 입니다.");
                        }

                    if(blood.equals("")||spinner.equals("")){
                        tv1.setText("1.?형 ??입니다");
                        return;
                    }
                    else{
                        tv1.setText("1."+blood+"형 "+gender+"입니다!");
                    }
                    if(chk1.isChecked()){
                        mThumids.add(R.drawable.drinking);

                    }

                    if(chk2.isChecked()){
                        mThumids.add(R.drawable.ciga);

                    }

                    if(!chk3.isChecked()){
                        mThumids.add(R.drawable.running);

                    }
                    if(chk1.isChecked()||chk2.isChecked()||!chk3.isChecked()){
                        gallery.setAdapter(new Imageadapter(MainActivity.this,mThumids));
                    }
                    else
                    {
                        gallery.removeAllViewsInLayout();
                    }

                }
            });
    }
}