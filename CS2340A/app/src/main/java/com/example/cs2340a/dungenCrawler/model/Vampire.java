package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Vampire extends Enemy implements IDrawable {
    public Vampire(Resources res, int resID, int speed, int attackPower) {
        super(res, resID, speed, attackPower);
    }

    public void attack() {
        // Vampire attack logic
        // bite/drink blood
        // sleep
        // burn
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        canvas.drawCircle(super.getX() - 24, super.getY(), 20, paint); // temp
        // canvas.drawBitmap(super.getSprite(), super.getX() - 24, super.getY(), paint);
    }
}