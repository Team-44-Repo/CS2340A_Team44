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
    private String direction;
    private int movingX = 0;
    private int stagnantY = 0;
    private boolean shooting;
    public Slingshot(int numPellets, Resources res) {
        this.numPellets = numPellets;
        this.x = 2050;
        this.y = 800;
        this.sprite = BitmapFactory.decodeResource(res, R.drawable.slingshot);
        this.sprite = Bitmap.createBitmap(sprite);
        this.shooting = false;
        this.pellet = new Rect(1, 2, 1, 2);
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
        pellet = in.readParcelable(Rect.class.getClassLoader());
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

    /*
        This draws the slingshot IMAGE in the corner of the screen.
        NOT THE PELLETS.
     */
    @Override
    public void draw(Canvas canvas, Resources resources) {
        System.out.println("DRAWING SLINGSHOT");
        Paint paint = new Paint();
        canvas.drawBitmap(sprite, x, y, paint);
    }
    /*
        This updates the pellet's location when you're shooting.
     */
    public void updatePellet() {
        if (shooting) {
            if (direction.equals("left")) {
                movingX -= 80;
            } else {
                movingX += 80;
            }
        }
        if (movingX <= 0 || movingX >= 2100) {
            shooting = false;
        }
    }
    /*
        Draws pellets in front of player when not shooting and
        shows the pellets moving when fired.
     */
    public void drawPellet(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        if (shooting) {
            System.out.println("Drawing while shooting");
            this.pellet = new Rect(movingX, stagnantY,
                    movingX + 20, stagnantY + 20);
        } else {
            this.pellet = new Rect(GameConfig.getPlayer().getX() - 20,
                    GameConfig.getPlayer().getY() + 80,
                    GameConfig.getPlayer().getX(),
                    GameConfig.getPlayer().getY() + 100);
        }
        canvas.drawRect(pellet, paint);
    }
    /*
        Called when the Player presses the "E" key to allow the slingshot to shoot.
        movingX: locks the location of the Player's current position to move left
        stagnantY: locks the location of the Player's y and DOESN'T CHANGE
     */
    public void shootLeft() {
        if (!shooting) {
            shooting = true;
            movingX = GameConfig.getPlayer().getX() - 20;
            stagnantY = GameConfig.getPlayer().getY() + 80;
            direction = "left";
        }
    }
    public void shootRight() {
        if (!shooting) {
            shooting = true;
            movingX = GameConfig.getPlayer().getX() + 80;
            stagnantY = GameConfig.getPlayer().getY() + 80;
            direction = "right";
        }
    }
    public boolean getShooting() {
        return shooting;
    }
    public Rect getPellet() {
        return pellet;
    }
    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

        parcel.writeInt(numPellets);
        parcel.writeParcelable(sprite, i);
        parcel.writeInt(x);
        parcel.writeInt(y);
        parcel.writeInt(movingX);
        parcel.writeByte((byte) (shooting ? 1 : 0));
        parcel.writeParcelable(pellet, i);
    }
}
