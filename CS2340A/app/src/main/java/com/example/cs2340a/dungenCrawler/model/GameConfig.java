package com.example.cs2340a.dungenCrawler.model;


import android.content.res.Resources;
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
    private Background bg;
    private Room currRoom;
    private int resID;

    //basic constructor
    public GameConfig(Player player) {
        this.player = player;
    }
    public GameConfig(Player player, Background bg) {
        this(player);
        this.bg = bg;
        resID = bg.getResID();
    }
    public GameConfig(Player player, Room room) {
        this(player);
        this.currRoom = room;
    }

    public GameConfig(Player player, Background bg, int room, Resources res) {
        this(player, bg);
        this.currRoom = new RoomOne("room1", 1200, 540, 310,
                460, 2090, 2400, bg, 1);

        //Create 3 Room Objects
        /*
        Room room1 = new RoomOne("room1", 1200, 540, 310, 460,
                2090, 2400);
        Room room2 = new RoomTwo("room2", 30, 400, 0, 20,
                720, 890);
        Room room3 = new RoomThree("room3", 800, 800, 420, 580,
                2090, 2400);
         */

        /*
        switch (room) {
        case 1:
            currRoom = room1;
            break;
        case 2:
            currRoom = room2;
            break;
        case 3:
            currRoom = room3;
            break;
        default:
            currRoom = room1;
            break;
        }
         */
    }

    protected GameConfig(Parcel in) {
        player = in.readParcelable(Player.class.getClassLoader());
        // bg = in.readParcelable(Background.class.getClassLoader());
        currRoom = in.readParcelable(Room.class.getClassLoader());
    }

    public Player getPlayer() {
        return player; }
    public Background getBG() {
        return bg; }
    public Room getCurrRoom() {
        return currRoom; }

    public void setPlayer(Player player) {
        this.player = player; }
}
