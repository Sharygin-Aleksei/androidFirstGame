package com.example.gamefirst;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    float screenHeight;
    float screenWidth;
    float navigationBarHeight;

    ConstraintLayout gameFieldLayout = null;

    ConstraintLayout barFieldLayout = null;
    float gameFieldX;
    float gameFieldY;
    float gameFieldHeight;
    float gameFieldWidth;

    float barFieldHeight;
    float barFieldWidth;

    float holePictureSideSize;

    PlayField playField = null;
    Player player = null;
    TextView dig = null;
    TextView scoreCounter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;

        navigationBarHeight = Utils.getNavigationBarHeight(getResources());

        gameFieldLayout = findViewById(R.id.gameField);
        gameFieldLayout.setBackgroundResource(R.drawable.grass_background);
        gameFieldX = gameFieldLayout.getLayoutParams().width;
        gameFieldY = gameFieldLayout.getLayoutParams().height;

        barFieldLayout = findViewById(R.id.barField);
        barFieldLayout.getLayoutParams().width = (int) screenWidth;
        barFieldLayout.getLayoutParams().height = (int) (screenHeight / 6);

        barFieldHeight = barFieldLayout.getHeight();
        barFieldWidth = barFieldLayout.getWidth();

        gameFieldHeight = screenHeight - barFieldHeight - navigationBarHeight;
        gameFieldWidth = screenWidth;

        gameFieldLayout.getLayoutParams().height = (int) gameFieldHeight;
        gameFieldLayout.setY(barFieldHeight);
        gameFieldLayout.requestLayout();


        scoreCounter = findViewById(R.id.scoreCounter);

        holePictureSideSize = gameFieldHeight / 15;



        playField = new PlayField(10, 15);
        player = new Player();

        dig = findViewById(R.id.digCounter);
        dig.setText(String.valueOf(player.dig));

        gameFieldLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float xTouch = event.getX();
                float yTouch = event.getY();

                if(event.getAction() == MotionEvent.ACTION_DOWN){

                    if(xTouch <= playField.fieldSizeX * holePictureSideSize && yTouch <= playField.fieldSizeY * holePictureSideSize && player.dig > 0 ){

                        int i = (int) Math.floor(xTouch / holePictureSideSize);
                        int j = (int) Math.floor(yTouch / holePictureSideSize);

                        if(playField.field[i][j] == 0){
                            player.score++;
                            player.dig--;
                            playField.dig(i,j);

                            ImageView hole = new ImageView(MainActivity.this);
                            hole.setImageResource(R.drawable.holee);
                            hole.setX((float) i * holePictureSideSize);
                            hole.setY((float) j * holePictureSideSize);
                            gameFieldLayout.addView(hole);
                            hole.getLayoutParams().height = (int) holePictureSideSize;
                            hole.getLayoutParams().width = (int) holePictureSideSize;

                        }else if(playField.field[i][j] == 2){
                            player.score += 2;
                            playField.dig(i,j);
                            ImageView hole = new ImageView(MainActivity.this);
                            hole.setImageResource(R.drawable.holee);
                            hole.setX((float) i * holePictureSideSize);
                            hole.setY((float) j * holePictureSideSize);
                            gameFieldLayout.addView(hole);
                            hole.getLayoutParams().height = (int) holePictureSideSize;
                            hole.getLayoutParams().width = (int) holePictureSideSize;
                        }
                    }
                    scoreCounter.setText(String.valueOf(player.score));
                    dig.setText(String.valueOf(player.dig));
                }
                return true;
            }
        });
    }
    public void startNewGame(View v){
        player.score = 0;
        gameFieldLayout.removeAllViews();
        playField = new PlayField(10, 15);
        player = new Player();
        dig.setText(String.valueOf(player.dig));
        scoreCounter.setText(String.valueOf(player.score));
    }


}

