package com.example.cs2340a.dungenCrawler.model;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import androidx.annotation.NonNull;

public class PlayerMovement extends Activity implements MovementStrategy, Parcelable, View.OnKeyListener {

    //
    private Player player;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;

    private int x, y, width, height;
    private Bitmap avatar;
    public PlayerMovement(int screenX, int screenY, Resources res, int resID) {

        avatar = BitmapFactory.decodeResource(res, resID);

        width = avatar.getWidth();
        height = avatar.getHeight();

        width /= 4;
        height /= 4;

        avatar = Bitmap.createScaledBitmap(avatar, width, height, false);
    }

    protected PlayerMovement(Parcel in) {
        player = in.readParcelable(Player.class.getClassLoader());
        isMovingUp = in.readByte() != 0;
        isMovingDown = in.readByte() != 0;
        isMovingLeft = in.readByte() != 0;
        isMovingRight = in.readByte() != 0;
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
    public void setUp(boolean up) { this.isMovingUp = up; }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int index = event.getActionIndex();
//        int action = event.getActionMasked();
//        int pointerId = event.getPointerId(index);
//
//        switch(action) {
//            case MotionEvent.ACTION_DOWN:
//                if(mVelocityTracker == null) {
//                    mVelocityTracker = VelocityTracker.obtain();
//                }
//                else {
//                    mVelocityTracker.clear();
//                }
//                mVelocityTracker.addMovement(event);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mVelocityTracker.addMovement(event);
//                mVelocityTracker.computeCurrentVelocity(1000);
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                mVelocityTracker.recycle();
//                break;
//        }
//        return true;
//    }

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

        return false;
    }

//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        System.out.println("Key Pressed: " + event.getKeyCode());
//        return super.dispatchKeyEvent(event);
//    }

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
        parcel.writeInt(x);
        parcel.writeInt(y);
        parcel.writeInt(width);
        parcel.writeInt(height);
        parcel.writeParcelable(avatar, i);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent event) {
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

        return false;
    }
}
