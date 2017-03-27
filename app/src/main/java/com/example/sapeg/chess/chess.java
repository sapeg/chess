
package com.example.sapeg.chess;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;


public class chess extends Activity {
    Button mB, bt;
    Button mButton, b;
    LinearLayout layout, lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(new DrawView(this,this));
      //  setContentView(R.layout.main);
        //     b = (Button) findViewById(R.id.button1);
        //    LinearLayout grouplayout = (LinearLayout) findViewById(R.id.grouplayout);
        lay = new LinearLayout(this);
        setContentView(lay);
        MyButtonClass myBtn = new MyButtonClass(this);

        lay.addView(myBtn);
        //  ViewGroup linearLayout = (ViewGroup) findViewById(R.id.activity_main);
        //  mB = (Button) findViewById(R.id.button1);
 /*       layout = (LinearLayout) findViewById(R.id.button1);
        Button mB = new Button(this);
   //     mB.setText(R.string.b);
        mB.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(mB);
*//*        View.OnClickListener oclmButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chess.this, Main2Activity.class);
                startActivity(intent);
            }

        };

        mB.setOnClickListener(oclmButton);                 /*(new View.OnClickListener() {
*/
 /*           @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, Main2Activity.class);

                startActivity(intent);
            }
        });
*/
    }

    public class MyButtonClass extends Button {
        public MyButtonClass(Context context) {
            super(context);

            // Тут можно задать Вашей View параметры по умолчанию, например:
            this.setText("My Button");
        }

        class DrawView extends View {
            Paint p, paint;
            Bitmap bitmap1, bitmap2;
            Rect rect;
            int x1 = 70, y1 = 20;


            public DrawView(Context context, AttributeSet attrs) {
                super(context, attrs);
                p = new Paint();
                rect = new Rect();
                bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.k_w_33x33);
                bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.k_b_33x33);

            }

            public boolean onTouchEvent(MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    invalidate();
                }
                return true;
            }


            @Override
            protected void onDraw(Canvas canvas)  {

                canvas.drawColor(Color.GREEN);
                // invalidate();

                //     b.layout(11, 11, 11, 11);
                //            b.draw(canvas);
                //    mButton.setBounds(11, 11, 22, 22); //параметры определяют область, где будет нарисована кнопка
                //   mButton.draw(canvas);

                p.setColor(Color.WHITE);

                // толщина линии = 10
                p.setStrokeWidth(2);

                // рисуем точку (50,50)
                //   canvas.drawPoint(480,2, p);

                // рисуем линию от (100,100) до (500,50)
             //   canvas.drawLine(100, 100, 500, 50, p);

// создание игровой доски
                //x=70;y=20...x=470;y=420
                int a = 0;
                int c = 0;
                int b1 = 0;
                int b2 = 0;
                for (int i = 2; i <= 9; i++) {
                    for (int j = 2; j <= 9; j++) {

                        a = a + 50;
                        b1 = i % 2;
                        b2 = j % 2;
                        if ((b1 == 0 & b2 == 0) | (b1 != 0 & b2 != 0)) {
                            p.setColor(Color.BLACK);
                        } else {
                            p.setColor(Color.WHITE);
                        }
                        canvas.drawRect(20 + a, 20 + c, 70 + a, 70 + c, p);
                    }
                    a = 0;
                    c = c + 50;
                }


                for (int i = 1; i < 2; i++) {
                    Random random = new Random();

                    int s;
                    s = (random.nextInt(9) + 1);

                    if (s == 1) {
                        x1 = x1 - 50;
                        y1 = y1 - 50;
                    }
                    if (s == 2) {
                        y1 = y1 - 50;
                    }
                    if (s == 3) {
                        x1 = x1 + 50;
                        y1 = y1 - 50;
                    }
                    if (s == 4) {
                        x1 = x1 - 50;
                        y1 = y1;
                    }
                    if (s == 5) {
                        x1 = x1;
                        y1 = y1;
                    }
                    if (s == 6) {
                        x1 = x1 + 50;
                        y1 = y1;
                    }
                    if (s == 7) {
                        x1 = x1 - 50;
                        y1 = y1 + 50;
                    }
                    if (s == 8) {
                        x1 = x1;
                        y1 = y1 + 50;
                    }
                    if (s == 9) {
                        x1 = x1 + 50;
                        y1 = y1 + 50;
                    }
                    if (x1 < 70) x1 = x1 + 100;
                    if (y1 < 20) y1 = y1 + 100;
                    if (x1 >= 470) x1 = x1 - 100;
                    if (y1 >= 420) y1 = y1 - 100;


                    canvas.drawBitmap(bitmap1, x1, y1, paint);

                    char xcoord = 0;
                    int ycoord = 0;
                    if (x1 == 70) xcoord = 'a';
                    if (x1 == 70 + 50) xcoord = 'b';
                    if (x1 == 70 + 50 * 2) xcoord = 'c';
                    if (x1 == 70 + 50 * 3) xcoord = 'd';
                    if (x1 == 70 + 50 * 4) xcoord = 'e';
                    if (x1 == 70 + 50 * 5) xcoord = 'f';
                    if (x1 == 70 + 50 * 6) xcoord = 'g';
                    if (x1 == 70 + 50 * 7) xcoord = 'h';

                    if (y1 == 20) ycoord = 1;
                    if (y1 == 20 + 50) ycoord = 2;
                    if (y1 == 20 + 50 * 2) ycoord = 3;
                    if (y1 == 20 + 50 * 3) ycoord = 4;
                    if (y1 == 20 + 50 * 4) ycoord = 5;
                    if (y1 == 20 + 50 * 5) ycoord = 6;
                    if (y1 == 20 + 50 * 6) ycoord = 7;
                    if (y1 == 20 + 50 * 7) ycoord = 8;



              /*  Paint s1 = new Paint();
                s1.setTextSize(30.0f);
                int g=0,k=i;

                if (i>=5) {
                    k=i-5;
                    g=50;
                }
                canvas.drawText(""+s, (k-1)*120, 450+g, s1);
              */
/*
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //          canvas.drawText("y1="+y1, 70, 500, s1);
*/

                }
                super.onDraw(canvas);
            }

        }

    }
}