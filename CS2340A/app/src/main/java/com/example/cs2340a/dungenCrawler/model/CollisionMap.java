package com.example.cs2340a.dungenCrawler.model;


public class CollisionMap {
    /*
    This class is made to create the proper collision map based on the room the player is currently
    in. In the GameView class, there will need to be a method called in the update() function to
    check and see if Player is intersecting the CollisionMap and prevent Player from moving past
    the collided area (keep the x and y values in place). >>should be done using Observer pattern**

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

    temp commented out to try invisible tile map for collision map
    */
    public static final int TILE_WIDTH_PIXELS = 83;
    public static final int TILE_HEIGHT_PIXELS = 84;
    public static final int NUM_ROW_TILES = 13;
    public static final int NUM_COL_TILES = 29;

    private int[][] collisionMap;

    //constructor
    // >> edit to take in room id and create collision map accordingly*******
    public CollisionMap() {
        initializeCollisionMap();
    }

    public int[][] getCollisionMap() {
        return collisionMap;
    }

    static final int WALKABLE = 0;
    static final int BLOCKED = 1;

    private void initializeCollisionMap() {
        collisionMap = new int[][] {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

        };
    }
}
