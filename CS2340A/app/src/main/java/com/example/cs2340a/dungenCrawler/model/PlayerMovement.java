package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;

public class PlayerMovement implements MovementStrategy {
    Player player;
    boolean isMoving = false;
    int x, y, width, height;
    Bitmap avatar;
    public PlayerMovement(int screenX, int screenY, Resources res, int resID) {

        avatar = BitmapFactory.decodeResource(res, resID);

        width = avatar.getWidth();
        height = avatar.getHeight();

        width /= 4;
        height /= 4;

        avatar = Bitmap.createScaledBitmap(avatar, width, height, false);
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap a) {
        this.avatar = a;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
