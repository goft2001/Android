package com.cookandroid.mid_a_001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //바인딩
        Button btnRandom=(Button)findViewById(R.id.btnRandom);
        Button btnRusult=(Button)findViewById(R.id.btnResult);

        final EditText edit1=(EditText)findViewById(R.id.edit1);
        final EditText edit2=(EditText)findViewById(R.id.edit2);
        final EditText edit3=(EditText)findViewById(R.id.edit3);
        final ListView btnList=(ListView)findViewById(R.id.btnList);


        //난수 생성버튼 코드 작성
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rand1 = new Random().nextInt(8)+2;
                int rand2 = new Random().nextInt(8)+2;

                edit1.setText(String.valueOf(rand1));
                edit2.setText(String.valueOf(rand2));


            }

        });


        // 결과 확인버튼 코드 작성
        btnRusult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //난수, 입력값
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();
                String num3 = edit3.getText().toString();
                //
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                int n3 = Integer.parseInt(num3); //사용자 입력값

                int n4= n1*n2; //정답

                if(n3==n4){
                    Toast.makeText(MainActivity.this,"정답입니다!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"틀렸습니다.",Toast.LENGTH_SHORT).show();
                    String[] value = new String[9];

                    for(int i=0;i<9;++i){
                        value[i]=String.valueOf(n1)+"X"+(i+1)+"="+(n1*(i+1));
                    }

                    ArrayAdapter<String> adapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,value);
                    btnList.setAdapter(adapter);
                }


            }
        });



    }
}