package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cs2340a.R;

public class Slingshot implements IDrawable {
    private int numPellets;
    private Bitmap sprite;
    private int x;
    private int y;
    public Slingshot (int numPellets, Resources res) {
        this.numPellets = numPellets;
        this.x = 2050;
        this.y = 800;
        this.sprite = BitmapFactory.decodeResource(res, R.drawable.slingshot);
        this.sprite = Bitmap.createBitmap(sprite);
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {
        System.out.println("DRAWING SLINGSHOT");
        Paint paint = new Paint();
        canvas.drawBitmap(sprite, x, y, paint);
    }
}
