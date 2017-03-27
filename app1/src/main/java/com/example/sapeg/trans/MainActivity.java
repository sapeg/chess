package com.example.sapeg.trans;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint paint;
        Bitmap bitmap;
int x=150,y=150;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.im3);

            String info =
                    String.format("Info: size = %s x %s, bytes = %s (%s), config = %s",
                            bitmap.getWidth(),
                            bitmap.getHeight(),
                            bitmap.getByteCount(),
                            bitmap.getRowBytes(),
                            bitmap.getConfig());
            Log.d("log", info);


        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(180, 102, 204, 255);
            canvas.drawBitmap(bitmap, x, y, paint);

        }

    }

 /*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView image = (ImageView) findViewById(R.id.animationView);
        image.setImageResource(R.drawable.im2);
        ImageView image1 = (ImageView) findViewById(R.id.animationView);
        image1.setImageResource(R.drawable.im3);
        TranslateAnimation anim = new TranslateAnimation(350, 50, 350, 50);
        TranslateAnimation anim1 = new TranslateAnimation(150, 50, 50, 50);
        anim.setDuration(1000);
    //    anim.setFillAfter(true);
        image.startAnimation(anim);
        image1.startAnimation(anim1);



    }

*/
/*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView img = (ImageView)findViewById(R.id.animationView);
        // определим для ImageView какое-нибудь изображение
        img.setImageResource(R.drawable.im2);
        // создаем анимацию
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.onleft);
        // запуск анимации
        img.startAnimation(animation);

//       super.onCreate(savedInstanceState);
 //       setContentView(R.layout.main);

        ImageView img1 = (ImageView)findViewById(R.id.animationView);
        // определим для ImageView какое-нибудь изображение
        img.setImageResource(R.drawable.im2);
        // создаем анимацию
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.onright);
        // запуск анимации
        img.startAnimation(animation1);




    }

*/
}

