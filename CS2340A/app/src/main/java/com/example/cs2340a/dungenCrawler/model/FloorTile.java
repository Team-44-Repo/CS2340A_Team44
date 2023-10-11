package com.example.cs2340a.dungenCrawler.model;

import android.graphics.Canvas;
import android.graphics.Rect;

public class FloorTile extends Tile {

    private final Sprite sprite;

    public FloorTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getFloorSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
