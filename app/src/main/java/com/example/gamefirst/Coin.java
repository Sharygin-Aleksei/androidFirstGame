package com.example.gamefirst;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.List;

public class Coin implements AnimatorInterface {

    public Bitmap bitmap;
    public int x;
    public int y;

    public Coin(Context context, int x, int y, int coinSideSize) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.coin);
        bitmap = Bitmap.createScaledBitmap(bitmap, coinSideSize, coinSideSize, true);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public List<AnimatorInterface> getAnimators() {
        return null;
    }
}
