package com.cookandroid.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

//        ImageView iv1 = (ImageView) findViewById(R.id.iv1);
//        ImageView iv2 = (ImageView) findViewById(R.id.iv2);
//        ImageView iv3 = (ImageView) findViewById(R.id.iv3);
//        ImageView iv4 = (ImageView) findViewById(R.id.iv4);


        ImageView imageArr[] = new ImageView[9];
        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서" };

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;

//        final int cnt_iv1=0;
        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };

        for(int i=0; i<imageArr.length; ++i) {
            imageArr[i] = (ImageView) findViewById(imageId[i]);
        }


        for(int i=0; i<imageArr.length; ++i) {
            final int idx = i;
            imageArr[idx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //1.이 그림에 대한 투표수 카운팅
                    voteCount[idx]++;

                    //2.이 그림 이름을 토스트 띄워준다, 투표수(카운팅)과 함께
                    Toast.makeText(getApplicationContext(),
                            imgName[idx] + " 총:" +voteCount[idx] + " 표",
                            Toast.LENGTH_SHORT).show();

                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),
                        ResultActivity.class);

                //값을 가지고 가야된다! extra
                in.putExtra("VoteCount", voteCount);
                in.putExtra("ImageName", imgName);

                startActivity(in);
            }
        });


    }
}
