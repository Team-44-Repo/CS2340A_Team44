package com.example.cs2340a.dungenCrawler.model;


import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.cs2340a.dungenCrawler.SpriteSheet;
import com.example.cs2340a.dungenCrawler.Tile;

//********************* WARNING/NOTE I only barley understand tile set stuff so this probably all
// needs to be changed.
public class GameMap extends SurfaceView implements SurfaceHolder.Callback {

    private final Tilemap tilemap;

    public GameMap(Context context) {
        super(context);
        SpriteSheet spriteSheet = new SpriteSheet(context);
        tilemap = new Tilemap(spriteSheet);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }
    /*
    private Room[][] rooms;


    public GameMap(int numRows, int numCols) {
        rooms = new Room[numRows][numCols];
        // Initialize the map with empty rooms
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                rooms[i][j] = new Room(RoomType.EMPTY);
            }
        }
    }

    public Room getRoom(int row, int col) {
        return rooms[row][col];
    }
    public void setRoom(int row, int col, Room room) {
        rooms[row][col] = room;
    }
    */
}
