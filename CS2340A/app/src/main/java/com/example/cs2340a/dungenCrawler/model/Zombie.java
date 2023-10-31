package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

    }

    @Override
    public void draw(Canvas canvas, Resources resources) {

    }
}