package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cs2340a.R;

public class HeartPower extends PowerUpDecorator implements IDrawable, Collidable {
    private Bitmap sprite;
    private Rect collisionShape;
    private String powerType = "heart";
    public HeartPower(Resources res, PowerUp powerUp) {
        super(res);
        this.powerUp = powerUp;
        this.sprite = BitmapFactory.decodeResource(res, R.drawable.power1heart);
        this.sprite = Bitmap.createBitmap(sprite);

        this.collisionShape = new Rect(getX(), getY(), getX() + getWidth(),
                getY() + getHeight());
    }

    @Override
    public void checkCollision(Player player) {
        GameConfig.setHealthPoints(GameConfig.getHealthPoints() + powerUp.applyEffect()
                + applyEffect());
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
        if (super.isActive()) {
            canvas.drawRect(getCollisionShape(), paint);
            canvas.drawBitmap(sprite, getX(), getY(), paint);
        }
    }
    public String getPowerType() {
        return powerType;
    }
    @Override
    public void drawIcon(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        if (!super.isActive()) {
            canvas.drawBitmap(sprite, 50, 800, paint);
        }
    }
}
