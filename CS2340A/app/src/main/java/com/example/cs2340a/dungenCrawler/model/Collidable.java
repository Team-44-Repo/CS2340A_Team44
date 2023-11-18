package com.example.cs2340a.dungenCrawler.model;

import android.graphics.Rect;

public interface Collidable {
    void checkCollision(Player player);
    Rect getCollisionShape();
    void setCollisionShape(Rect rect);
    void setActive(boolean isActive);
}
