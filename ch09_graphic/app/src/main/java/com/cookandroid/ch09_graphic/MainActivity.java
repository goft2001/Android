package com.cookandroid.ch09_graphic;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //xml의 뷰를 사용하지 않는다!
        setContentView(new MyGraphicView(this));
    }

    //1.View 클래스를 상속 받아 재정의해서 만든다
    private static class MyGraphicView extends View
    {
        public MyGraphicView(Context context) {
            super(context);
        }

        //2.onDraw()라는 메소드에서 그리는 것을 전부 처리한다!
        @Override
        protected void onDraw(Canvas canvas)//3.Canvas로 그리기 위한 배경을 마련한다
        {
            super.onDraw(canvas);

            //4.Paint 라는 객체로 그린다.(캔버스에 채워넣는다!)
            Paint paint = new Paint();
            paint.setAntiAlias(true);//anti -> Alias(계단현상)
            paint.setColor(Color.GREEN);
            //5.Canvas와 Paint를 연결한다!
            canvas.drawLine(10, 10, 300, 10, paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(5);
            canvas.drawLine(10, 30, 300, 30, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);
            paint.setStyle(Paint.Style.FILL);
            Rect rect1 = new Rect(10, 50, 10 + 100, 50 + 100);
            canvas.drawRect(rect1, paint);

            paint.setStyle(Paint.Style.STROKE);
            Rect rect2 = new Rect(130, 50, 130 + 100, 50 + 100);
            canvas.drawRect(rect2, paint);

            RectF rect3 = new RectF(250, 50, 250 + 100, 50 + 100);
            canvas.drawRoundRect(rect3, 20, 20, paint);

            canvas.drawCircle(60, 220, 50, paint);

            paint.setStrokeWidth(5);
            Path path1 = new Path();
            path1.moveTo(10, 290);
            path1.lineTo(10 + 50, 290 + 50);
            path1.lineTo(10 + 100, 290);
            path1.lineTo(10 + 150, 290 + 50);
            path1.lineTo(10 + 200, 290);
            canvas.drawPath(path1, paint);

            paint.setStrokeWidth(0);
            paint.setTextSize(30);
            canvas.drawText("안드로이드", 10, 390, paint);

          //  Paint paint = new Paint();
//            paint.setAntiAlias(true);
//
//            paint.setStrokeWidth(30);
//            canvas.drawLine(30, 30, 300, 30, paint);
//
//            paint.setStrokeCap(Paint.Cap.ROUND);
//            canvas.drawLine(30, 80, 300, 80, paint);
//
//            RectF rectF = new RectF();
//
//            rectF.set(60, 120, 60 + 200, 100 + 100);
//            canvas.drawOval(rectF, paint);
//
//            rectF.set(60, 170, 60 + 100, 170 + 100);
//            canvas.drawArc(rectF, 40, 110, true, paint);
//
//            paint.setColor(Color.BLUE);
//            rectF.set(60, 280, 60 + 100, 280 + 100);
//            canvas.drawRect(rectF, paint);
//
//            paint.setColor(Color.argb(0x88, 0xff, 0x00, 0x00));
//            rectF.set(90, 310, 90 + 100, 310 + 100);
//            canvas.drawRect(rectF, paint);
//
       }
    }
}
