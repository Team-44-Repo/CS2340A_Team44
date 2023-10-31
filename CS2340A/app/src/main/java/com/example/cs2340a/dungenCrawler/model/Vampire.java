package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;

public class Vampire extends Enemy {
    public Vampire(Resources res, int resID, int speed, int attackPower) {
        super(res, resID, speed, attackPower);
    }

    public void attack() {
        // Vampire attack logic
        // bite/drink blood
        // sleep
        // burn
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {

    }
}