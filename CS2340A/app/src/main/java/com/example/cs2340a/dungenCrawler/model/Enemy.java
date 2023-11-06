package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public abstract class Enemy implements EnemyObserver, Parcelable, IDrawable {
    private int x;
    private int y;
    private int width = 74;
    private int height = 74;
    private int speed;
    private int attackPower;
    private int resID;
    private Bitmap sprite;
    private Rect collisionShape;
    public Enemy(Resources res, int resID, int speed, int attackPower) {
        sprite = BitmapFactory.decodeResource(res, resID);
        sprite = Bitmap.createBitmap(sprite);
        this.resID = resID;
        this.speed = speed;
        this.attackPower = attackPower;

        this.x = 500;
        this.y = 500;

        collisionShape = new Rect(x, y, x + width, y + height);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getSpeed() {
        return speed;
    }
    public Bitmap getSprite() {
        return sprite;
    }
    public Rect getCollisionShape() {
        return collisionShape;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }
    public void setCollisionShape(Rect collisionShape) {
        this.collisionShape = collisionShape;
    }
    public void attack(Player player) {
        if (player.getCollisionShape().intersect(this.getCollisionShape())) {
            player.setHealthPoints(player.getHealthPoints() - attackPower);
        }
    }
    @Override
    public void update(Player player) {
        System.out.println("in update");
        if ((this.getX() != player.getX()) || (this.getY() != player.getY())) {
            //change enemy's X
            if (this.getX() < player.getX()) {
                this.setX(this.getX() + this.getSpeed());
            } else if (this.getX() > player.getX()) {
                this.setX(this.getX() - this.getSpeed());
            }
            //change enemy's Y
            if (this.getY() > player.getY()) {
                this.setY(this.getY() - this.getSpeed());
            } else if (this.getY() < player.getY()) {
                this.setY(this.getY() + this.getSpeed());
            }
        }
        //check for collision using player.getCollisionShape()
        //referance how this is done in the GameLoop
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Enemy(Parcel in) {
        resID = in.readInt();
        speed = in.readInt();
        attackPower = in.readInt();
        collisionShape = in.readParcelable(Player.class.getClassLoader());
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(resID);
        parcel.writeInt(speed);
        parcel.writeInt(attackPower);
        parcel.writeParcelable(collisionShape, i);
    }

    protected int getAttackPower() {
        return attackPower; }
}