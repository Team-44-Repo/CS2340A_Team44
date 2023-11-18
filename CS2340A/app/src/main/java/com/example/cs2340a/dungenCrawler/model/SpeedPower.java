package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cs2340a.R;

public class SpeedPower extends PowerUp implements IDrawable, Collidable {
    private Bitmap sprite;
    private Rect collisionShape;
    public SpeedPower(Resources res) {
        super(res);
        this.sprite = BitmapFactory.decodeResource(res, R.drawable.power2speed);
        this.sprite = Bitmap.createBitmap(sprite);

        this.collisionShape = new Rect(getX(), getY(), getX() + getWidth(),
                getY() + getHeight());
    }

    @Override
    public void checkCollision(Player player) {
        System.out.println("speedpower's check collision method");
        if (isActive()) {
            if (this.getCollisionShape().intersect(player.getCollisionShape())) {
                System.out.println("increasing speed");
                GameConfig.getPlayer().setSpeed(50);
            }
        }
    }

    @Override
    public int applyEffect() {
        return 0;
    }

    @Override
    public Rect getCollisionShape() {
        return collisionShape;
    }

    @Override
    public void setCollisionShape(Rect rect) {
        this.collisionShape = rect;
    }

    @Override
    public boolean isActive() {
        return isActive();
    }

    @Override
    public void setActive(boolean isActive) {
        setActive(isActive);
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        canvas.drawRect(getCollisionShape(), paint);
        canvas.drawBitmap(sprite, getX(), getY(), paint);
    }
}
