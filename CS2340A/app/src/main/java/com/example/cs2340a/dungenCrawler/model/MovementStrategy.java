package com.example.cs2340a.dungenCrawler.model;

import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintSet;

public interface MovementStrategy extends Parcelable {
    //boolean isMoving = false;
    int X = 0;
    int Y = 0;
    int WIDTH = 0;
    int HEIGHT = 0;

    boolean onKey(KeyEvent event);
    boolean onTouchLogic(MotionEvent event, Player player);
    boolean isMovingUp();
    boolean isMovingDown();
    boolean isMovingLeft();
    boolean isMovingRight();
    void setUp(boolean up);
}
