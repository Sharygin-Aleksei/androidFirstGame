package com.example.gamefirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout gameFieldLayout = null;
    ConstraintLayout barFieldLayout = null;
    int gameFieldX;
    int gameFieldY;
    int holePictureSideSize = 125;
    PlayField playField = null;
    Player player = null;
    TextView dig = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameFieldLayout = (ConstraintLayout)findViewById(R.id.gameField);
        gameFieldLayout.setBackgroundResource(R.drawable.grass_background);
        gameFieldX = gameFieldLayout.getLayoutParams().width;
        gameFieldY = gameFieldLayout.getLayoutParams().height;

        barFieldLayout = (ConstraintLayout)findViewById(R.id.barField);

        playField = new PlayField(gameFieldX/holePictureSideSize, gameFieldY/holePictureSideSize);
        player = new Player();

        dig = (TextView) findViewById(R.id.digCounter);
        dig.setText(String.valueOf(player.dig));

        gameFieldLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float xTouch = event.getX();
                float yTouch = event.getY();

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    if(xTouch <= playField.fieldSizeX * holePictureSideSize && yTouch <= playField.fieldSizeY * holePictureSideSize && player.dig > 0 ){
                        if(playField.field[(int) Math.floor(xTouch / holePictureSideSize)][(int) Math.floor(yTouch / holePictureSideSize)] == 0){
                            player.dig--;
                            playField.field[(int) Math.floor(xTouch / holePictureSideSize)][(int) Math.floor(yTouch / holePictureSideSize)] = 1;
                            ImageView hole = new ImageView(MainActivity.this);
                            hole.setImageResource(R.drawable.holee);
                            hole.setX((float) (Math.floor(xTouch / holePictureSideSize)) * holePictureSideSize);
                            hole.setY((float) (Math.floor(yTouch / holePictureSideSize)) * holePictureSideSize);
                            gameFieldLayout.addView(hole);
                            hole.getLayoutParams().height = holePictureSideSize;
                            hole.getLayoutParams().width = holePictureSideSize;
                        }else{
                            Toast.makeText(getApplicationContext(), "ПШОЛ ВОН", Toast.LENGTH_SHORT).show();
                        }
                    }
                    dig.setText(String.valueOf(player.dig));
                }
                return true;
            }
        });
    }
    public void startNewGame(View v){
        gameFieldLayout.removeAllViews();
        playField = new PlayField(gameFieldX/holePictureSideSize, gameFieldY/holePictureSideSize);
        gameFieldLayout.setBackgroundResource(R.drawable.grass_background);
        player = new Player();
    }


}

