package com.example.gamefirst;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationListener;

import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private LocationManager locationManager;

    LocationRequest locationRequest = null;

    int screenHeight;
    int screenWidth;
    int navigationBarHeight;

    ConstraintLayout gameFieldLayout = null;

    ConstraintLayout barFieldLayout = null;
    int gameFieldX;
    int gameFieldY;
    int gameFieldHeight;
    int gameFieldWidth;

    int barFieldHeight;
    int barFieldWidth;

    final int MATRIX_SIZE = 18;
    int holePictureSideSize;

    PlayField playField = null;
    Player player = null;
    TextView dig = null;
    TextView scoreCounter = null;

    int mapId = 1;


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
        Map.setMap(gameFieldLayout, 1);

        gameFieldX = gameFieldLayout.getLayoutParams().width;
        gameFieldY = gameFieldLayout.getLayoutParams().height;

        barFieldLayout = findViewById(R.id.barField);
        barFieldLayout.getLayoutParams().width = screenWidth;

        barFieldHeight = barFieldLayout.getHeight();
        barFieldWidth = barFieldLayout.getWidth();

        gameFieldHeight = screenHeight - barFieldHeight - navigationBarHeight;
        gameFieldWidth = screenWidth;

        gameFieldLayout.getLayoutParams().height = screenWidth;

        scoreCounter = findViewById(R.id.scoreCounter);

        holePictureSideSize = gameFieldLayout.getLayoutParams().height / MATRIX_SIZE;

        playField = new PlayField(MATRIX_SIZE, MATRIX_SIZE, mapId);
        player = new Player();

        dig = findViewById(R.id.digCounter);
        dig.setText(String.valueOf(player.dig));


        gameFieldLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                float xTouch = event.getX();
                float yTouch = event.getY();

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    if (xTouch <= playField.fieldSizeX * holePictureSideSize && yTouch <= playField.fieldSizeY * holePictureSideSize && player.dig > 0) {

                        int i = (int) Math.floor(xTouch / holePictureSideSize);
                        int j = (int) Math.floor(yTouch / holePictureSideSize);

                        if (playField.field[j][i] == 0) {
                            playField.dig(j, i, player);

                            new Hole(MainActivity.this, gameFieldLayout,
                                    mapId, i, j, holePictureSideSize);
                        }
                    }
                    Utils.barCountersRefresh(dig, scoreCounter, player);
                }
                return true;
            }
        });
    }

    public void startNewGame(View v) {
        player = new Player();
        gameFieldLayout.removeAllViews();
        playField = new PlayField(MATRIX_SIZE, MATRIX_SIZE, mapId);
        Utils.barCountersRefresh(dig, scoreCounter, player);
    }

    public void firstMapSwitcher(View v) {
        mapId = 1;
        Map.setMap(gameFieldLayout, mapId);
        playField.setField(mapId);
        player = new Player();
        gameFieldLayout.removeAllViews();
        Utils.barCountersRefresh(dig, scoreCounter, player);
    }

    public void secondMapSwitcher(View v) {
        mapId = 2;
        Map.setMap(gameFieldLayout, mapId);
        playField.setField(mapId);
        player = new Player();
        gameFieldLayout.removeAllViews();
        Utils.barCountersRefresh(dig, scoreCounter, player);
    }

    public void thirdMapSwitcher(View v) {
        mapId = 3;
        Map.setMap(gameFieldLayout, mapId);
        playField.setField(mapId);
        player = new Player();
        gameFieldLayout.removeAllViews();
        Utils.barCountersRefresh(dig, scoreCounter, player);
    }


}

