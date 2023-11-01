package com.example.cs2340a.dungenCrawler.model;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class Enemy {

    private int x;
    private int y;
    private int speed;
    private Bitmap sprite;
    private Rect collisionShape;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getSpeed() {
        return speed;
    }
    public Bitmap getSprite() {
        return sprite;
    }
    public Rect getCollisionShape() {
        return collisionShape;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }
    public void setCollisionShape(Rect collisionShape) {
        this.collisionShape = collisionShape;
    }
    public abstract void attack();
}