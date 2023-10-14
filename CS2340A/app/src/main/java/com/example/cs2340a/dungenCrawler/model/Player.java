package com.example.cs2340a.dungenCrawler.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;


public class Player implements Parcelable, MovementStrategy {

    //******* MAKE SINGLETON *********

    //attributes
    private String playerName;
    private CharSprite avatar;
    private int currRoomId; // not sure if this is where we should keep track of this.
    private double difficulty;
    private int healthPoints;


    //temporary basic public constructor
    public Player(String name, CharSprite sprite, int roomId, double difficulty, int hp) {
        this.playerName = name;
        this.avatar = sprite;
        this.currRoomId = roomId;
        this.difficulty = difficulty;
        //this.healthPoints = 44;
        this.healthPoints = (int) (100 * difficulty);
    }


    protected Player(Parcel in) {
        playerName = in.readString();
        currRoomId = in.readInt();
        difficulty = in.readDouble();
        healthPoints = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playerName);
        dest.writeInt(currRoomId);
        dest.writeDouble(difficulty);
        dest.writeInt(healthPoints);
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
    public CharSprite getAvatar() {
        return avatar;
    }
    public int getAvatarResId() {
        return avatar.getSpriteResId();
    }
    public int getCurrRoomId() {
        return currRoomId;
    }
    public double getDifficulty() {
        return difficulty;
    }
    public int getHealthPoints() {
        return healthPoints;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }
    public void setAvatar(CharSprite sprite) {
        this.avatar = sprite;
    }
    public void setCurrRoomId(int roomNum) {
        this.currRoomId = roomNum;
    }
    public void setDifficulty(double diff) {
        this.difficulty = diff;
    }


    public void updateHealthPoints() {
        this.healthPoints = 200; //temp number so code runs
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
