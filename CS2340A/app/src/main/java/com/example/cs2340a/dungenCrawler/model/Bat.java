package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Bat extends Enemy implements IDrawable {
    public void attack() {
        // check collision
        // apply damage dealt
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        canvas.drawCircle(super.getX() - 24, super.getY(), 20, paint); // temp
        // canvas.drawBitmap(super.getSprite(), super.getX() - 24, super.getY(), paint);
    }
}