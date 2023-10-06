package com.example.cs2340a.dungenCrawler;

import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.appcompat.app.AppCompatActivity;

abstract public class Tile extends AppCompatActivity {

    protected final Rect mapLocationRect;

    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }

    public enum TileType {
        FLOOR_TILE,
        WALL_TILE
    }
    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect) {
        switch (TileType.values()[idxTileType]) {
            case FLOOR_TILE:
                return new FloorTile(spriteSheet, mapLocationRect);
            default:
                return new FloorTile(spriteSheet, mapLocationRect);
        }
    }

    public abstract void draw(Canvas canvas);
}
