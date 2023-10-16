package com.example.cs2340a.dungenCrawler.model;

import android.view.MotionEvent;

public interface MovementStrategy {
    boolean isMoving = false;
    int x = 0, y = 0, width = 0, height = 0;

    boolean onTouchEvent(MotionEvent event);
}
