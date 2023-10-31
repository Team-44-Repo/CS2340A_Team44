package com.example.cs2340a.dungenCrawler.model;


import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;



public abstract class GameConfig implements Parcelable {

    /*
    This is where ALL base information of the game should be stored. This will need to be modified
    more to adjust to the concrete classes: EasyConfig, MediumConfig, and HardConfig. These classes
    will extend this class to add specifics based on their difficulty. Right now, there's nothing
    specific in any other them, but any specific information regarding those difficulties should
    be included in those classes hereafter.
     */
    private Player player;
    private Room currRoom;
    private int resID;

    //basic constructor
    public GameConfig(Player player) {
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

    public Player getPlayer() {
        return player; }

    public Room getCurrRoom() {
        return currRoom; }

    public void setPlayer(Player player) {
        this.player = player; }
    public void switchRoom(int roomID) {
        if (roomID == 1) {
            currRoom = new RoomTwo("room2", currRoom.getInitialPlayerX(),
                    currRoom.getInitialPlayerY(),
                    currRoom.getDoorwayTopY(), currRoom.getDoorwayBottomY(),
                    currRoom.getDoorwayLeftX(), currRoom.getDoorwayRightX(),
                    currRoom.getBackground(), 2);
            player.setX(30);
            player.setY(400);
        } else if (roomID == 2) {
            currRoom = new RoomThree("room3", currRoom.getInitialPlayerX(),
                    currRoom.getInitialPlayerY(),
                    currRoom.getDoorwayTopY(), currRoom.getDoorwayBottomY(),
                    currRoom.getDoorwayLeftX(), currRoom.getDoorwayRightX(),
                    currRoom.getBackground(), 3);
            player.setX(800);
            player.setY(800);
        }
    }
    public abstract EnemyFactory getFactory();
    public abstract void drawEnemies(Canvas canvas, Resources resources);
    public abstract void updateEnemies();
}
