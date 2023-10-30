package com.example.cs2340a.dungenCrawler.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public abstract class Room implements Parcelable {
    private String name; // A name or identifier for the room
    private Room[] connectedRooms; // An array of rooms that are connected to this room
    private Room connectedRoom; //the one room that is connected (sprint 3 - only one room
    // connected)
    private int initialPlayerX; // Initial player X-coordinate in the room
    private int initialPlayerY; // Initial player Y-coordinate in the room
    private int doorwayTopY;
    private int doorwayBottomY;
    private int doorwayLeftX;
    private int doorwayRightX;


    public Room(String name, int initialPlayerX, int initialPlayerY, int y1, int y2, int x1,
                int x2) {
        this.name = name;
        this.initialPlayerX = initialPlayerX;
        this.initialPlayerY = initialPlayerY;
        this.doorwayTopY = y1;
        this.doorwayBottomY = y2;
        this.doorwayLeftX = x1;
        this.doorwayRightX = x2;
    }

    // Getters
    public Room[] getConnectedRooms() {
        return connectedRooms;
    }
    public Room getConnectedRoom() {
        return connectedRoom;
    }
    public int getInitialPlayerX() {
        return initialPlayerX;
    }
    public int getInitialPlayerY() {
        return initialPlayerY;
    }
    public int getDoorwayTopY() {
        return doorwayTopY;
    }
    public int getDoorwayBottomY() {
        return doorwayBottomY;
    }
    public int getDoorwayLeftX() {
        return doorwayLeftX;
    }
    public int getDoorwayRightX() {
        return doorwayRightX;
    }

    //setters
    public void setConnectedRooms(Room[] connectedRooms) {
        this.connectedRooms = connectedRooms;
    }
    public void setConnectedRoom(Room connectedRoom) {
        this.connectedRoom = connectedRoom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(initialPlayerX);
        parcel.writeInt(initialPlayerY);
        parcel.writeInt(doorwayTopY);
        parcel.writeInt(doorwayBottomY);
        parcel.writeInt(doorwayLeftX);
        parcel.writeInt(doorwayRightX);
    }


    // Additional methods to handle room-specific behavior, such as rendering
}

