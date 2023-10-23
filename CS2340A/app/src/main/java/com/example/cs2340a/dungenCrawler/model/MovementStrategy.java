package com.example.cs2340a.dungenCrawler.model;

import android.view.KeyEvent;

public interface MovementStrategy {
    //boolean isMoving = false;
    int X = 0;
    int Y = 0;
    int WIDTH = 0;
    int HEIGHT = 0;

    boolean onKey(KeyEvent event);
    boolean isMovingUp();
    boolean isMovingDown();
    boolean isMovingLeft();
    boolean isMovingRight();
    void setUp(boolean up);
}
