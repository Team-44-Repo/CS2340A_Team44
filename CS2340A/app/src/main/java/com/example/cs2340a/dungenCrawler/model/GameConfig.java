package com.example.cs2340a.dungenCrawler.model;


import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;

/*
This is where ALL base information of the game should be stored. This will need to be modified
more to adjust to the concrete classes: EasyConfig, MediumConfig, and HardConfig. These classes
will extend this class to add specifics based on their difficulty. Right now, there's nothing
specific in any other them, but any specific information regarding those difficulties should
be included in those classes hereafter.
*/

public abstract class GameConfig implements Parcelable {

    //Attributes -----------------------------------------------------------
    private Player player;
    private Room currRoom;
    private int resID;

    //Constructors -----------------------------------------------------------
    public GameConfig(Player player) {
        //basic constructor
        this.player = player;
    }
    public GameConfig(Player player, Room room, Resources res) {
        this(player);
        this.currRoom = room;
    }
    protected GameConfig(Parcel in) {
        player = in.readParcelable(Player.class.getClassLoader());
        currRoom = in.readParcelable(Room.class.getClassLoader());
    }

    //Methods -----------------------------------------------------------
    public void switchRoom(int roomID) {
        System.out.println("in switchRooms");
        if (roomID == 1) {
            //switchEnemies(1);
            currRoom = new RoomTwo("room2", currRoom.getInitialPlayerX(),
                    currRoom.getInitialPlayerY(),
                    currRoom.getDoorwayTopY(), currRoom.getDoorwayBottomY(),
                    currRoom.getDoorwayLeftX(), currRoom.getDoorwayRightX(),
                    currRoom.getBackground(), 2);
            player.setX(30);
            player.setY(400);

        } else if (roomID == 2) {
            //switchEnemies(2);
            currRoom = new RoomThree("room3", currRoom.getInitialPlayerX(),
                    currRoom.getInitialPlayerY(),
                    currRoom.getDoorwayTopY(), currRoom.getDoorwayBottomY(),
                    currRoom.getDoorwayLeftX(), currRoom.getDoorwayRightX(),
                    currRoom.getBackground(), 3);
            player.setX(800);
            player.setY(800);
        }
    }

    //Abstract Methods -----------------------------------------------------------
    public abstract EnemyFactory getFactory();
    public abstract void drawEnemies(Canvas canvas, Resources resources);
    public abstract void addObserver(Enemy enemy);
    public abstract void removeObserver(Enemy enemy);
    public abstract void clearObservers();
    public abstract void notifyObservers();
    public abstract void switchEnemies(int roomID);
    public abstract String difType();

    //getters and setters -----------------------------------------------------------
    public Player getPlayer() {
        return player;
    }
    public Room getCurrRoom() {
        return currRoom;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public int getResID() {
        return this.resID;
    }
}
