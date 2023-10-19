package com.example.cs2340a.dungenCrawler.model;

import android.view.KeyEvent;

public interface MovementStrategy {
    boolean isMoving = false;
    int x = 0, y = 0, width = 0, height = 0;

    boolean onKey(KeyEvent event);
    boolean isMovingUp();
    boolean isMovingDown();
    boolean isMovingLeft();
    boolean isMovingRight();
    void setUp(boolean up);
}
