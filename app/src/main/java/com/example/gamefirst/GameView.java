package com.example.gamefirst;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameView extends View {

    Bitmap map = null;
    Bitmap hole = null;
    int gameViewHeight;
    int gameViewWidth;
    List<Hole> holesList = new ArrayList<>();
    Boolean clearCanvas = false;

    private Context context;

    public GameView(Context context, int gameViewHeight, int gameViewWidth ) {
        super(context);
        this.context = context;
        this.gameViewHeight = gameViewHeight;
        this.gameViewWidth = gameViewWidth;

        map = BitmapFactory.decodeResource(context.getResources(), R.drawable.firstmap);
        map = Bitmap.createScaledBitmap(map, gameViewWidth, gameViewWidth, true);
}

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        if(clearCanvas) {
            canvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);
            holesList = new ArrayList<>();
            clearCanvas = false;
        }

        canvas.drawBitmap(map, 0, 0,paint);

        if(holesList.size() > 0){
            for(Hole hole: holesList){
                canvas.drawBitmap(hole.holeBitmap, hole.x, hole.y, paint );
                if(hole.coinTimer > 0){
                    canvas.drawBitmap(hole.coin.bitmap, hole.coin.x, hole.coin.y + hole.coinTimer, paint);
                    hole.coinTimer--;
                    invalidate();
                }else if(hole.coinTimer == 0){
                    hole.coinTimer--;
                    invalidate();
                }
            }
        }
    }

    public void drawHole(Hole hole){
        holesList.add(hole);
        invalidate();
    }

}
