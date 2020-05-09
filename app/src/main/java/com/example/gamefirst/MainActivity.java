package com.example.gamefirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout myLayout = null;
    int holePictureSideSize = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PlayField playField = new PlayField(10, 15);

        myLayout = (ConstraintLayout)findViewById(R.id.fon);
        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float xTouch = event.getX();
                float yTouch = event.getY();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    if(xTouch <= playField.fieldSizeX * holePictureSideSize && yTouch <= playField.fieldSizeY * holePictureSideSize ){
                        if(playField.field[(int) Math.floor(xTouch / holePictureSideSize)][(int) Math.floor(yTouch / holePictureSideSize)] == 0){

                            playField.field[(int) Math.floor(xTouch / holePictureSideSize)][(int) Math.floor(yTouch / holePictureSideSize)] = 1;
                            ImageView hole = new ImageView(MainActivity.this);
                            hole.setImageResource(R.drawable.holee);
                            hole.setX((float) (Math.floor(xTouch / holePictureSideSize)) * holePictureSideSize);
                            hole.setY((float) (Math.floor(yTouch / holePictureSideSize)) * holePictureSideSize);
                            myLayout.addView(hole);
                            hole.getLayoutParams().height = holePictureSideSize;
                            hole.getLayoutParams().width = holePictureSideSize;
                        }else{
                            Toast.makeText(getApplicationContext(), "ПШОЛ ВОН", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                return true;
            }
        });


    }


}

