package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;

public abstract class PowerUp implements IDrawable, Collidable {
    private Resources res;
    private int x;
    private int y;
    private boolean isActive;
    private int width = 74;
    private int height = 74;
    public PowerUp(Resources res) {
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
    public abstract int applyEffect();
}
