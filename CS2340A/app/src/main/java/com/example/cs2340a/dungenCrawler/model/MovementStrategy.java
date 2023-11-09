package com.example.cs2340a.dungenCrawler.model;

import android.view.KeyEvent;

public interface MovementStrategy {
    boolean isMoving = false;
    int x = 0;
    int y = 0;
    int width = 0;
    int height = 0;

    boolean onKey(KeyEvent event);
    boolean isMovingUp();
    boolean isMovingDown();
    boolean isMovingLeft();
    boolean isMovingRight();
    void setUp(boolean up);
}
