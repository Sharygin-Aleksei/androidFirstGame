package com.example.gamefirst;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

public class Map implements AnimatorInterface {

    public static Bitmap mapBitmap;
    private final static int FIRST_MAP = R.drawable.firstmap;
    private final static int SECOND_MAP = R.drawable.secondmap;
    private final static int THIRD_MAP = R.drawable.thirdmap;

    public List<Hole> holesList = new ArrayList<>();

    public static void setMap(Context context, GameView gameView, int mapId){
        switch (mapId) {
            case 2:
                mapBitmap = BitmapFactory.decodeResource(context.getResources(), SECOND_MAP);
                mapBitmap = Bitmap.createScaledBitmap(mapBitmap, gameView.getWidth(), gameView.getWidth(), true );
                gameView.map = mapBitmap;
                gameView.clearCanvas = true;
                gameView.invalidate();
                break;
            case 3:
                mapBitmap = BitmapFactory.decodeResource(context.getResources(), THIRD_MAP);
                mapBitmap = Bitmap.createScaledBitmap(mapBitmap, gameView.getWidth(), gameView.getWidth(), true );
                gameView.map = mapBitmap;
                gameView.clearCanvas = true;
                gameView.invalidate();
                break;
            default:
                mapBitmap = BitmapFactory.decodeResource(context.getResources(), FIRST_MAP);
                mapBitmap = Bitmap.createScaledBitmap(mapBitmap, gameView.getWidth(), gameView.getWidth(), true );
                gameView.map = mapBitmap;
                gameView.clearCanvas = true;
                gameView.invalidate();
                break;
        }
    }

    @Override
    public void draw(Canvas canvas) {

        Paint paint = new Paint();

        canvas.drawBitmap(mapBitmap, 0, 0, paint);

        for(Hole hole: holesList){
            hole.draw(canvas);
        }
    }

    @Override
    public List<AnimatorInterface> getAnimators() {
        return null;
    }
}
