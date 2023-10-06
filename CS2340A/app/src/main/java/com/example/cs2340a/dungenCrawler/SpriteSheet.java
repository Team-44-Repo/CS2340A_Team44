package com.example.cs2340a.dungenCrawler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340a.R;

public class SpriteSheet extends AppCompatActivity {
    private static final int SPRITE_WIDTH_PIXELS = 64;
    private static final int SPRITE_HEIGHT_PIXELS = 64;
    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.team44_spritesheet,
                bitmapOptions);
    }


    public Sprite getPlayerSprite() {
        return new Sprite(this,
                new Rect(0, 0, 64, 64));
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Sprite getFloorSprite() {
        return getSpriteByIdx(1, 0);
    }

    private Sprite getSpriteByIdx(int idxRow, int idxCol) {
        return new Sprite(this, new Rect(idxCol * SPRITE_WIDTH_PIXELS,
                idxRow * SPRITE_HEIGHT_PIXELS, (idxCol + 1) * SPRITE_WIDTH_PIXELS,
                (idxRow + 1) * SPRITE_HEIGHT_PIXELS));
    }
}
