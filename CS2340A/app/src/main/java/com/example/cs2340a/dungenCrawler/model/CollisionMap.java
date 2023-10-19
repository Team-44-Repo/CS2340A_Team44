package com.example.cs2340a.dungenCrawler.model;

import android.graphics.Rect;
public class CollisionMap {
    /*
    This class is made to create the proper collision map based on the room the player is currently
    in. In the GameView class, there will need to be a method called in the update() function to
    check and see if Player is intersecting the CollisionMap and prevent Player from moving past
    the collided area (keep the x and y values in place).
    * */
    private Rect topBorder;
    private Rect bottomBorder;
    private Rect leftBorder;
    private Rect rightBorder;
    private Rect doorway; // will be used to create detection area to move to next room
    private int roomID;

    public CollisionMap(int roomID) {
        this.roomID = roomID;

        topBorder = new Rect(0, 0, 1920, 50);
        bottomBorder = new Rect(0, 1000, 2180, 1080);
        leftBorder = new Rect(0, 0, 50, 1080);
        rightBorder = new Rect(2100, 0, 2180, 1080);

        doorway = new Rect();
    }

    public int getRoomID() { return roomID; }
    public Rect getTopBorder() { return topBorder; } // Call in draw() method in GameView
    public Rect getBottomBorder() { return bottomBorder; } // Call in draw() method in GameView
    public Rect getLeftBorder() { return leftBorder; } // Call in draw() method in GameView
    public Rect getRightBorder() { return rightBorder; } // Call in draw() method in GameView

}
