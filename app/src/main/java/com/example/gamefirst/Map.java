package com.example.gamefirst;

import android.graphics.drawable.Drawable;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Map {

    private final static int FIRST_MAP = R.drawable.firstmap;
    private final static int SECOND_MAP = R.drawable.secondmap;
    private final static int THIRD_MAP = R.drawable.thirdmap;

    public static void setMap(ConstraintLayout layout, int mapId){
        switch (mapId) {
            case 2:
                layout.setBackgroundResource(SECOND_MAP);
                break;
            case 3:
                layout.setBackgroundResource(THIRD_MAP);
                break;
            default:
                layout.setBackgroundResource(FIRST_MAP);
                break;
        }
    }
}
