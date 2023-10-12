package com.example.cs2340a.dungenCrawler.model;


import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;


import androidx.annotation.NonNull;


public class GameConfig implements Parcelable {

    //I'm not sure if its a bad, good, or neutral idea to have these attributes in both
    //the Player class and the GameConfig class.
    private String playerName;
    private double difficulty;
    private CharSprite avatar;
    private int currRoomId;
    private int score;


    //basic constructor
    public GameConfig(String name, double diff, CharSprite sprite, int roomId) {

        this.playerName = name;
        this.difficulty = diff;
        this.avatar = sprite;
        this.currRoomId = roomId;

    }
    protected GameConfig(Parcel in) {

        playerName = in.readString();
        difficulty = in.readDouble();
        currRoomId = in.readInt();
    }

    public static final Creator<GameConfig> CREATOR = new Creator<GameConfig>() {
        @Override
        public GameConfig createFromParcel(Parcel in) {
            return new GameConfig(in);
        }

        @Override
        public GameConfig[] newArray(int size) {
            return new GameConfig[size];
        }
    };

    //getters and setters
    public String getPlayerName() {
        return playerName;
    }
    public double getDifficulty() {
        return difficulty;
    }
    public CharSprite getAvatar() {
        return avatar;
    }
    public int getCurrRoomId() {
        return currRoomId;
    }
    public int getScore() {
        return score; }
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    public void setDifficulty(double diff) {
        this.difficulty = diff;
    }
    public void setAvatar(CharSprite sprite) {
        this.avatar = sprite;
    }
    public void setCurrRoomId(int roomNum) {
        this.currRoomId = roomNum;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(playerName);
        parcel.writeDouble(difficulty);
        parcel.writeInt(currRoomId);
    }

    public void draw(Canvas canvas) {

    }

    public void update() {
        //GameDisplay.update();
    }
}
