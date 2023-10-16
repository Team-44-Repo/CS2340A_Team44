package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

public class PlayerMovement implements MovementStrategy, Parcelable {
    private Player player;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private KeyEvent up;
    private KeyEvent down;
    private KeyEvent left;
    private KeyEvent right;

    private int x, y, width, height;
    private Bitmap avatar;
    public PlayerMovement(int screenX, int screenY, Resources res, int resID) {

        avatar = BitmapFactory.decodeResource(res, resID);

        width = avatar.getWidth();
        height = avatar.getHeight();

        width /= 4;
        height /= 4;

        up = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_W);
        down = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_S);
        left = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_A);
        right = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_D);

        avatar = Bitmap.createScaledBitmap(avatar, width, height, false);
    }

    protected PlayerMovement(Parcel in) {
        player = in.readParcelable(Player.class.getClassLoader());
        isMovingUp = in.readByte() != 0;
        isMovingDown = in.readByte() != 0;
        isMovingLeft = in.readByte() != 0;
        isMovingRight = in.readByte() != 0;
        up = in.readParcelable(KeyEvent.class.getClassLoader());
        down = in.readParcelable(KeyEvent.class.getClassLoader());
        left = in.readParcelable(KeyEvent.class.getClassLoader());
        right = in.readParcelable(KeyEvent.class.getClassLoader());
        x = in.readInt();
        y = in.readInt();
        width = in.readInt();
        height = in.readInt();
        avatar = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<PlayerMovement> CREATOR = new Creator<PlayerMovement>() {
        @Override
        public PlayerMovement createFromParcel(Parcel in) {
            return new PlayerMovement(in);
        }

        @Override
        public PlayerMovement[] newArray(int size) {
            return new PlayerMovement[size];
        }
    };

    public Bitmap getAvatar() {
        return avatar;
    }
    public boolean isMovingUp() { return isMovingUp; }
    public boolean isMovingDown() { return isMovingDown; }
    public boolean isMovingLeft() { return isMovingLeft; }
    public boolean isMovingRight() { return isMovingRight; }

    public void setAvatar(Bitmap a) {
        this.avatar = a;
    }

    @Override
    public boolean onKey(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            System.out.println("ActionDown...");
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_W:
                    System.out.println("W down");
                    isMovingUp = true;
                    System.out.println("isMovingUp: " + isMovingUp);
                    break;
                case KeyEvent.KEYCODE_A:
                    isMovingLeft = true;
                    break;
                case KeyEvent.KEYCODE_S:
                    isMovingDown = true;
                    break;
                case KeyEvent.KEYCODE_D:
                    isMovingRight = true;
                    break;
            }
        }

        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(player, i);
        parcel.writeByte((byte) (isMovingUp ? 1 : 0));
        parcel.writeByte((byte) (isMovingDown ? 1 : 0));
        parcel.writeByte((byte) (isMovingLeft ? 1 : 0));
        parcel.writeByte((byte) (isMovingRight ? 1 : 0));
        parcel.writeParcelable(up, i);
        parcel.writeParcelable(down, i);
        parcel.writeParcelable(left, i);
        parcel.writeParcelable(right, i);
        parcel.writeInt(x);
        parcel.writeInt(y);
        parcel.writeInt(width);
        parcel.writeInt(height);
        parcel.writeParcelable(avatar, i);
    }
}
