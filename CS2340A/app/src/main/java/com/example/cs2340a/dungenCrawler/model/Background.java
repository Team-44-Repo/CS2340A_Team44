package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    private int x;
    private int y;
    private Bitmap background;

    public Background(int screenX, int screenY, Resources res, int resID) {
        background = BitmapFactory.decodeResource(res, resID);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getBackground() {
        return background;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
