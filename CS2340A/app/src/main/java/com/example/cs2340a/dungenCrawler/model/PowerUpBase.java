package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;

public interface PowerUpBase {
    int applyEffect();
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    boolean isActive();
    void setActive(boolean active);
    void drawIcon(Canvas canvas, Resources res);
    void checkCollision(Player player);

    void draw(Canvas canvas, Resources resources);

    Rect getCollisionShape();
}
