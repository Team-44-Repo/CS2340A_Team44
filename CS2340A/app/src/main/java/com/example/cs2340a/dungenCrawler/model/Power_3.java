package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
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
        return false;
    }

    @Override
    public void setActive(boolean isActive) {

    }

    @Override
    public void draw(Canvas canvas, Resources resources) {

    }
}
