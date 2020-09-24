package com.cookandroid.project11_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Integer[] posterID={
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
            R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
            R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,
            R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20,
            R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,R.drawable.mov24,R.drawable.mov25,
            R.drawable.mov26,R.drawable.mov27,R.drawable.mov28,R.drawable.mov29,R.drawable.mov30,
            R.drawable.mov31,R.drawable.mov32,R.drawable.mov33,R.drawable.mov34,R.drawable.mov35,
            R.drawable.mov36,R.drawable.mov37,R.drawable.mov38,R.drawable.mov39,R.drawable.mov40,
            R.drawable.mov41,R.drawable.mov42,R.drawable.mov43,R.drawable.mov44,R.drawable.mov45,
            R.drawable.mov46,R.drawable.mov47,R.drawable.mov48,R.drawable.mov49,R.drawable.mov50,
            R.drawable.mov51,R.drawable.mov52,R.drawable.mov53,R.drawable.mov54,R.drawable.mov55,
            R.drawable.mov56,R.drawable.mov57,R.drawable.mov58,R.drawable.mov59
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드 영화 포스터");

        final GridView gv =(GridView)findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);


    }



    public class MyGridAdapter extends BaseAdapter {
        //1.멤버변수(필드)
        //2.생성자
        //3.메소드
        //4.내부클래스

        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }


        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 150));
            imageView.setScaleType((ImageView.ScaleType.FIT_CENTER));
            imageView.setPadding(3,5,3,5);
            imageView.setImageResource(posterID[position]);

           final int pos = position;
           imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View)View.inflate(MainActivity.this,R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster =(ImageView)dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("큰 포스터");
                    dlg.setIcon(R.drawable.cat);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });

           return imageView;



        }

    }

}