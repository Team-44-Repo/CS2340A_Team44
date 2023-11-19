package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;

public class PowerUp implements PowerUpBase, IDrawable {
    private int x;
    private int y;
    private boolean isActive;

    @Override
    public int applyEffect() {
        return 1;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public boolean isActive() {
        return isActive;
    }
    @Override
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void drawIcon(Canvas canvas, Resources res) {

    }

    @Override
    public void checkCollision(Player player) {

    }

    @Override
    public void draw(Canvas canvas, Resources resources) {

    }

    @Override
    public Rect getCollisionShape() {
        return new Rect();
    }
}
