package com.raraflower.hackgsu.myapplication;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import android.util.Log;


public class MainActivity extends AppCompatActivity {
    ImageView img;
    int color = Color.RED;
    int numPetal = 6;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);

        //set Paint
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Style.STROKE);

        //create bitmap
        Bitmap bmp= Bitmap.createBitmap(500, 500,Bitmap.Config.ARGB_8888);

        //Canvas
        final Canvas canvas=new Canvas(bmp);

        drawFlower(canvas);

        SeekBar sk = (SeekBar) findViewById(R.id.seekBar);
       // sk.setProgress(6);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.v("MyValue",i+"");
                numPetal=i+6;
                System.out.println(i);
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
                drawFlower(canvas);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //buttons
         Button bt1 = (Button) findViewById(R.id.buttonBlue);
         bt1.setOnClickListener(new View.OnClickListener() {
             @Override

             public void onClick(View v) {
                 color=Color.BLUE;
                 drawFlower(canvas);
             }
         });


//buttons
         Button bt2 = (Button) findViewById(R.id.buttonRed);
         bt2.setOnClickListener(new View.OnClickListener() {
             @Override

             public void onClick(View v) {
                 color=Color.RED;
                 drawFlower(canvas);
             }
         });

         Button bt3 = (Button) findViewById(R.id.buttonYellow);
         bt3.setOnClickListener(new View.OnClickListener() {
             @Override

             public void onClick(View v) {
                 color=Color.YELLOW;
                 drawFlower(canvas);
             }
         });

         Button bt4 = (Button) findViewById(R.id.buttonGreen);
         bt4.setOnClickListener(new View.OnClickListener() {
             @Override

             public void onClick(View v) {
                 color=Color.GREEN;
                 drawFlower(canvas);
             }
         });


         //setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });



        img.setImageBitmap(bmp);
    }



    public void drawFlower(Canvas canvas){
        Paint paint=new Paint();

        paint.setColor(color);
        paint.setStrokeWidth(2f);
        float x0 = 0, y0 = 0;
        float offset=250;

        int n=numPetal;
        if(n%2==1) n=n+1;
        for (float t = 0.0f; t <= 360.0; t += 0.1) {
            float theta = (float)(Math.toRadians(t));
            float r =(float) Math.sin(n * theta);
            float x1 = 200*(float)(r * Math.cos(theta));
            float y1 = 200*(float) (r * Math.sin(theta));

            canvas.drawLine(x0+offset,y0+offset,x1+offset,y1+offset,paint);
            x0 = x1;
            y0 = y1;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
