package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;

public abstract class PowerUpDecorator implements IDrawable, Collidable, PowerUpBase {
    private Resources res;
    private int x;
    private int y;
    private boolean isActive;
    private int width = 74;
    private int height = 74;
    protected PowerUp powerUp;
    public PowerUpDecorator(Resources res) {
        this.res = res;
        this.x = 1000;
        this.y = 500;
        this.isActive = true;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public abstract int applyEffect();
    public abstract void drawIcon(Canvas canvas, Resources res);
}
