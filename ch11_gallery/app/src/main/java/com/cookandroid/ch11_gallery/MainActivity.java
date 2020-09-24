package com.cookandroid.ch11_gallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);

        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        Context context;
        Integer[] posterID = { R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
                R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
                R.drawable.mov19, R.drawable.mov20 };



        String[] posterTitle = { "여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀",
                "혹성탈출", "아름다운비행", "내이름은 칸", "해리포터", "마더", "킹콩을 들다" };


        public MyGalleryAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv1 = new ImageView(context);
            iv1.setLayoutParams(new Gallery.LayoutParams(200, 300));
            iv1.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv1.setPadding(5, 5, 5, 5);
            iv1.setImageResource(posterID[position]);

            final int pos = position;
            iv1.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView iv2 = (ImageView) findViewById(R.id.ivPoster);

                    iv2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iv2.setImageResource(posterID[pos]);

                    Toast toast = new Toast(getApplicationContext());
                    View toastView = View.inflate(getApplicationContext(), R.layout.toast, null);

                    TextView tvToast = (TextView) toastView.findViewById(R.id.tvToast);
                    tvToast.setText(posterTitle[pos]);
                    toast.setView(toastView);
                    toast.show();


                    return false;
                }
            });

            return iv1;
        }
    }
}