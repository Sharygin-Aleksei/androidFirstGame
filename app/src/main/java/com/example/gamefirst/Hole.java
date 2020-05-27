package com.example.gamefirst;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Hole {

    private static final int HOLE_FOR_FIRST_MAP = R.drawable.newhole;
    private static final int HOLE_FOR_SECOND_MAP = R.drawable.secondhole;
    private static final int HOLE_FOR_THIRD_MAP = R.drawable.thirdhole;

    public Hole(Context context, ConstraintLayout layout, int mapId, int i, int j, int holePictureSideSize) {
        ImageView hole = new ImageView(context);
        hole.setImageResource(Hole.getHolePictureForMap(mapId));
        hole.setX((float) i * holePictureSideSize);
        hole.setY((float) j * holePictureSideSize);
        layout.addView(hole);
        hole.getLayoutParams().height =  holePictureSideSize;
        hole.getLayoutParams().width =  holePictureSideSize;
    }

    static int getHolePictureForMap(int mapId){
        switch (mapId){
            case 2:
                return HOLE_FOR_SECOND_MAP;
            case 3:
                return HOLE_FOR_THIRD_MAP;
            default:
                return HOLE_FOR_FIRST_MAP;
        }

    }
}
