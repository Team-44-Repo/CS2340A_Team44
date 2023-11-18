package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Power_3 extends PowerUp implements Collidable {

    public Power_3(Resources res) {
        super(res);
    }

    @Override
    public void checkCollision(Player player) {

    }

    @Override
    public int applyEffect() {
        return 0;
    }

    @Override
    public Rect getCollisionShape() {
        return null;
    }

    @Override
    public void setCollisionShape(Rect rect) {

    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public void setActive(boolean isActive) {
        super.setActive(isActive);
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {
    }
    @Override
    public void drawIcon(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        if (!super.isActive()) {
            canvas.drawRect(getCollisionShape(), paint);
            // canvas.drawBitmap(sprite, 250, 800, paint);
        }
    }
}
