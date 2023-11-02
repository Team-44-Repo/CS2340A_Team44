package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class Zombie extends Enemy {
    public Zombie(Resources res, int resID, int speed, int attackPower) {
        super(res, resID, speed, attackPower);
    }

    public void attack() {
        // Zombie attack logic
        // eat method
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        canvas.drawCircle(super.getX() - 24, super.getY(), 20, paint); // temp
        // canvas.drawBitmap(super.getSprite(), super.getX() - 24, super.getY(), paint);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

    }
}