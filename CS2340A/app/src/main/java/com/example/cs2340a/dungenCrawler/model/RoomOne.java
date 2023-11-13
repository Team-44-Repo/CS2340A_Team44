package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Parcel;

import com.example.cs2340a.R;

public class RoomOne extends Room {
    public RoomOne(int initialPlayerX,
                   int initialPlayerY, Background bg, int roomID) {
        //super(name, initialPlayerX, initialPlayerY, y1, y2, x1, x2, bg, 1);
        super(initialPlayerX, initialPlayerY, bg, roomID);
    }

    protected RoomOne(Parcel in) {
        super(in);
    }


    public static final Creator<RoomOne> CREATOR = new Creator<RoomOne>() {
        @Override
        public RoomOne createFromParcel(Parcel in) {
            return new RoomOne(in);
        }

        @Override
        public RoomOne[] newArray(int size) {
            return new RoomOne[size];
        }
    };

    @Override
    public void draw(Canvas canvas, Resources resources) {
        /*
        super.setCollisionMap(new CollisionMap(1));
         */
        super.getBackground().createBitmap(super.getBackground().getPoint(), resources,
                R.drawable.room1);
        super.getCollisionMap().draw(canvas, resources);
        super.getBackground().draw(canvas, resources);
    }
}
