package com.example.gamefirst;

import android.graphics.Canvas;

import java.util.List;

public interface AnimatorInterface {

    void draw(Canvas canvas);

    List<AnimatorInterface> getAnimators();

}
