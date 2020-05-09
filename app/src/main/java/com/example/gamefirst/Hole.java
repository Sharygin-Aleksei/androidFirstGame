package com.example.gamefirst;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;

public class Hole {

    public float x;
    public float y;
    public Bitmap hole;

    public Hole(float screenX, float screenY, Resources res) {

        hole = BitmapFactory.decodeResource(res, R.drawable.holee);
        hole = Bitmap.createScaledBitmap(hole, (int)screenX, (int)screenY, false);
    }
}
