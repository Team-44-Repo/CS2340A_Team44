package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;


import androidx.annotation.NonNull;

public abstract class Enemy implements EnemyObserver, Parcelable, IDrawable {

    //Attributes -----------------------------------------------------------
    private int x;
    private int y;
    private int width = 74;
    private int height = 74;
    private int speed;
    private int attackPower;
    private int resID;
    private int collisionOffsetX = 30;
    private int collisionOffsetY = 70;
    private boolean isActive;
    private Bitmap sprite;

    private Score score;
    private Rect collisionShape;

    //Constructor -----------------------------------------------------------
    public Enemy(Resources res, int resID, int speed, int attackPower) {
        //sprite = BitmapFactory.decodeResource(res, resID);
        //sprite = Bitmap.createBitmap(sprite);
        this.resID = resID;
        this.speed = speed;
        this.attackPower = attackPower;

        this.x = 500;
        this.y = 500;
        this.isActive = true;

        collisionShape = new Rect(x, y - 30, x + width + 50, y + height + 50);
    }


    //Methods -----------------------------------------------------------
    public void attack(Player player) {
        if (player.getCollisionShape().intersect(this.getCollisionShape())) {
            player.setHealthPoints(player.getHealthPoints() - attackPower);
        }
    }

    //Observer methods (Overrides)
    @Override
    public void update(Player player) {
        if (isActive) {
            //System.out.println("in Enemy update");
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
            setCollisionShape(new Rect(x + collisionOffsetX, y + collisionOffsetY - 30,
                    (x + collisionOffsetX) + width + 50, (y + collisionOffsetY) + height + 50));
        }
        //check for collision using player.getCollisionShape()
        //referance how this is done in the GameLoop
    }
    @Override
    public void checkCollision(Player player) {
        if (isActive) {
            if (this.getCollisionShape().intersect(player.getCollisionShape())) {
                System.out.println("collision > reducing hp:");
                GameConfig.setHealthPoints(GameConfig.getHealthPoints() - this.attackPower);
                System.out.println("collision > reducing score:");
                if (GameConfig.getScore() >= 5) {
                    GameConfig.setScore(GameConfig.getScore() - 5);
                } else {
                    GameConfig.setScore(0);
                }
            }
        }
    }


    //getters and setters -----------------------------------------------------------
    //      X & Y
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setAttackPower(int power) {
        this.attackPower = power;
    }

    //      Attack power
    protected int getAttackPower() {
        return attackPower; }

    //      Width & Height
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    //      speed
    public int getSpeed() {
        return speed;
    }

    //      Sprite
    public Bitmap getSprite() {
        return sprite;
    }
    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    //  Score
    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    //      CollisionShape
    public Rect getCollisionShape() {
        return collisionShape;
    }
    public void setCollisionShape(Rect collisionShape) {
        this.collisionShape = collisionShape;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }


    // other stuff
    @Override
    public int describeContents() {
        return 0;
    }

    protected Enemy(Parcel in) {
        resID = in.readInt();
        speed = in.readInt();
        attackPower = in.readInt();
        // sprite = in.readParcelable(Bitmap.class.getClassLoader());
        collisionShape = in.readParcelable(Player.class.getClassLoader());
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(resID);
        parcel.writeInt(speed);
        parcel.writeInt(attackPower);
        //parcel.writeBoolean(isActive);
        // parcel.writeParcelable(sprite, i);
        parcel.writeParcelable(collisionShape, i);
    }


}