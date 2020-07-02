package com.example.gamefirst;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class Hole implements AnimatorInterface {

    public Bitmap holeBitmap;
    public int x;
    public int y;
    public int coinTimer = 50;
    public Coin coin = null;

    public Hole(Context context, int mapId, int i, int j, int holePictureSideSize) {

        this.x = i * holePictureSideSize;
        this.y = j * holePictureSideSize;
        coin = new Coin(context, x + holePictureSideSize/4, y - holePictureSideSize/2 , holePictureSideSize/2);

        switch (mapId){
            case 1:
                holeBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.newhole);
                holeBitmap = Bitmap.createScaledBitmap(holeBitmap, holePictureSideSize, holePictureSideSize, true);
                break;
            case 2:
                holeBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.secondhole);
                holeBitmap = Bitmap.createScaledBitmap(holeBitmap, holePictureSideSize, holePictureSideSize, true);
                break;
            case 3:
                holeBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirdhole);
                holeBitmap = Bitmap.createScaledBitmap(holeBitmap, holePictureSideSize, holePictureSideSize, true);
                break;
        }
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public List<AnimatorInterface> getAnimators() {
        return null;
    }
}
