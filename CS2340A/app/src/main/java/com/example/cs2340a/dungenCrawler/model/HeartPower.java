package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cs2340a.R;

public class HeartPower extends PowerUp implements IDrawable, Collidable {
    private Bitmap sprite;
    private Rect collisionShape;
    private String powerType = "heart";
    public HeartPower(Resources res) {
        super(res);
        this.sprite = BitmapFactory.decodeResource(res, R.drawable.power1heart);
        this.sprite = Bitmap.createBitmap(sprite);

        this.collisionShape = new Rect(getX(), getY(), getX() + getWidth(),
                getY() + getHeight());
    }

    @Override
    public void checkCollision(Player player) {
        GameConfig.setHealthPoints(GameConfig.getHealthPoints() + applyEffect());
    }

    @Override
    public int applyEffect() {
        return 100;
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
        return super.isActive();
    }

    @Override
    public void setActive(boolean isActive) {
        super.setActive(isActive);
    }

    @Override
    public void draw(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        canvas.drawRect(getCollisionShape(), paint);
        canvas.drawBitmap(sprite, getX(), getY(), paint);
    }
    public String getPowerType() {
        return powerType;
    }
}
