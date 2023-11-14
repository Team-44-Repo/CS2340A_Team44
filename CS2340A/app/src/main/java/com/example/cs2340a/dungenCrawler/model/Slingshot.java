package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.cs2340a.R;

public class Slingshot implements IDrawable, Parcelable {
    private int numPellets;
    private Bitmap sprite;
    private Rect pellet;
    private int x;
    private int y;
    private int movingX;
    private boolean shooting;
    public Slingshot (int numPellets, Resources res) {
        this.numPellets = numPellets;
        this.x = 2050;
        this.y = 800;
        this.sprite = BitmapFactory.decodeResource(res, R.drawable.slingshot);
        this.sprite = Bitmap.createBitmap(sprite);
        this.shooting = false;
        // this.movingX = GameConfig.getPlayer().getX() - 20;
    }

    protected Slingshot(Parcel in) {
        numPellets = in.readInt();
        sprite = in.readParcelable(Bitmap.class.getClassLoader());
        pellet = in.readParcelable(Rect.class.getClassLoader());
        x = in.readInt();
        y = in.readInt();
        movingX = in.readInt();
        shooting = in.readByte() != 0;
    }

    public static final Creator<Slingshot> CREATOR = new Creator<Slingshot>() {
        @Override
        public Slingshot createFromParcel(Parcel in) {
            return new Slingshot(in);
        }

        @Override
        public Slingshot[] newArray(int size) {
            return new Slingshot[size];
        }
    };

    @Override
    public void draw(Canvas canvas, Resources resources) {
        System.out.println("DRAWING SLINGSHOT");
        Paint paint = new Paint();
        canvas.drawBitmap(sprite, x, y, paint);
    }

    public void drawPellet(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        this.pellet = new Rect(GameConfig.getPlayer().getX() - 20,
                GameConfig.getPlayer().getY() + 80,
                GameConfig.getPlayer().getX(),
                GameConfig.getPlayer().getY() + 100);
        canvas.drawRect(pellet, paint);
    }
    public void shoot() {
        System.out.println("SHOOTING");
        this.movingX = GameConfig.getPlayer().getX() - 20;
        this.movingX -= 30;
    }
    public boolean getShooting() {
        return shooting;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

        parcel.writeInt(numPellets);
        parcel.writeParcelable(sprite, i);
        parcel.writeParcelable(pellet, i);
        parcel.writeInt(x);
        parcel.writeInt(y);
        parcel.writeInt(movingX);
        parcel.writeByte((byte) (shooting ? 1 : 0));
    }
}
