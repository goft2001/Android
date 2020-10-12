package com.cookandroid.project9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final  static int LINE =1, CIRCLE = 2, RECTANGLE=3;

    static  int curShape = LINE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(Context context){
            super(context);


        }

        //실제로 화면에 도형이 그려질 onDraw메소드
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);

            switch (curShape){
                case LINE:
                    canvas.drawLine(startX,startY,stopX,stopY,paint);
                    break;
                case CIRCLE:
                    int radius = (int)Math.sqrt(Math.pow(stopX - startX,2) +Math.pow(stopY-startY,2));
                                            //sqrt 함수는 루트 씌우는 함수
                    canvas.drawCircle(startX,startY, radius,paint);
                    break;
                case RECTANGLE:
                    canvas.drawRect(startX,startY,stopX,stopY,paint);

                    break;
            }
        }



        public boolean onTouchEvent(MotionEvent event){ // 어떤 이벤트?
            switch (event.getAction()) // 이벤트 종류를 반환함
            {
                case MotionEvent.ACTION_DOWN:
                    startX = (int)event.getX();
                    startY = (int)event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();
                    this.invalidate(); //무효화
                    break;
            }
            return true;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선 그리기");
        menu.add(0,2,0,"원 그리기");
        menu.add(0,3,0,"사각형 그리기");
        menu.add(0,4,0,"색상 변경 >>");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1 :
                curShape = LINE; //선
                return true;
            case 2 :
                curShape = CIRCLE; // 원
                return true;
            case 3 :
                curShape = RECTANGLE;


        }
        return  super.onOptionsItemSelected(item);

    }



}