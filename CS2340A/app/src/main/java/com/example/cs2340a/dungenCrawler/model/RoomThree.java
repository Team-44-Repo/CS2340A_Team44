package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;

public class RoomThree extends Room {
    public RoomThree(String name, int initialPlayerX, int initialPlayerY,
                     int y1, int y2, int x1, int x2, Background bg, int roomID) {
        super(name, initialPlayerX, initialPlayerY, y1, y2, x1, x2, bg, 3);
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {

    }
}
