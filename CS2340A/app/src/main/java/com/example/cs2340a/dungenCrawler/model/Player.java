package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class Player implements Parcelable, MovementStrategy {

    //******* MAKE SINGLETON *********

    //attributes
    private String playerName;
//    private CharSprite avatar;
    private int avatarID;
    private int currRoomId; // not sure if this is where we should keep track of this.
    private double difficulty;
    private int healthPoints;
    int x = 990, y = 800, width = 74, height = 74;
//    private Bitmap sprite;
//    private ByteArrayOutputStream stream;
//    private byte[] compSprite;
    private MovementStrategy movement;

    //temporary basic public constructor

    public Player(String name, double difficulty, int screenX, int screenY, Resources res, int avaID) {
        this.playerName = name;
        this.difficulty = difficulty;
        this.healthPoints = (int) (100 * difficulty);
        this.avatarID = avaID;

//        System.out.println("Setting sprite decode...");
//        System.out.println("Sprite: " + sprite);
//        System.out.println("this.Sprite: " + this.sprite);
//        this.sprite = BitmapFactory.decodeResource(res, avaID);
//        System.out.println("Creating scaled bitmap...");
//        System.out.println("Sprite: " + sprite);
//        System.out.println("this.Sprite: " + this.sprite);
//        this.sprite = Bitmap.createScaledBitmap(this.sprite, screenX, screenY, false);
//        System.out.println("Sprite: " + sprite);
//        System.out.println("this.Sprite: " + this.sprite);
//        this.stream = new ByteArrayOutputStream();
//        sprite.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        this.compSprite = stream.toByteArray();

        movement = new PlayerMovement(screenX, screenY, res, avaID);
    }
//    public Player(String name, CharSprite sprite, int roomId, double difficulty, int hp) {
//        this.playerName = name;
////        this.avatar = sprite;
//        this.currRoomId = roomId;
//        this.difficulty = difficulty;
//        //this.healthPoints = 44;
//        this.healthPoints = (int) (100 * difficulty);
//    }

    protected Player(Parcel in) {
        playerName = in.readString();
        currRoomId = in.readInt();
        difficulty = in.readDouble();
        healthPoints = in.readInt();
        avatarID = in.readInt();
        movement = in.readParcelable(PlayerMovement.class.getClassLoader());
//        sprite = in.readParcelable(null);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playerName);
        dest.writeInt(currRoomId);
        dest.writeDouble(difficulty);
        dest.writeInt(healthPoints);
        dest.writeInt(avatarID);
        dest.writeParcelable((Parcelable) movement, 0);
//        dest.writeParcelable(sprite, 0);
//        dest.writeByteArray(compSprite);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    //getters and setters
    public String getPlayerName() {
        return playerName;
    }
    public int getAvatarID() { return avatarID; }
//    public CharSprite getAvatar() {
//        return avatar;
//    }
//    public int getAvatarResId() {
//        return avatar.getSpriteResId();
//    }
    public int getCurrRoomId() {
        return currRoomId;
    }
    public double getDifficulty() {
        return difficulty;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
//    public Bitmap getSprite() {
//        System.out.println("Returning sprite...\n" + "Sprite: " + sprite);
//        return sprite;
//    }
    public int getX() { return x; }
    public int getY() { return y; }
    public MovementStrategy getMovement() { return movement; }
//    public byte[] getCompSprite() { return compSprite; }

    public void setPlayerName(String name) {
        this.playerName = name;
    }
//    public void setAvatar(CharSprite sprite) {
//        this.avatar = sprite;
//    }
    public void setCurrRoomId(int roomNum) {
        this.currRoomId = roomNum;
    }
    public void setAvatarID(int avaID) { this.avatarID = avaID; }
    public void setDifficulty(double diff) { this.difficulty = diff; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
//    public void setSprite(Bitmap sprite) { this.sprite = sprite; }
//    public void setCompSprite(byte[] compSprite) { this.compSprite = compSprite; }
//    public void setSprite(int avatar) {
//        sprite = BitmapFactory.decodeResource(getResources(), avatar);
//        sprite = Bitmap.createScaledBitmap(sprite, screenX, screenY, false);
//    }

    public void updateHealthPoints() {
        this.healthPoints = 200; //temp number so code runs
    }

    @Override
    public boolean onKey(KeyEvent event) {
        return movement.onKey(event);
    }

    @Override
    public boolean isMovingUp() {
        return movement.isMovingUp();
    }

    @Override
    public boolean isMovingDown() {
        return movement.isMovingDown();
    }

    @Override
    public boolean isMovingLeft() {
        return movement.isMovingLeft();
    }

    @Override
    public boolean isMovingRight() {
        return movement.isMovingRight();
    }
}
