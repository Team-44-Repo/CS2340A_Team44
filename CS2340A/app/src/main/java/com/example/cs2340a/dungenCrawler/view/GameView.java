package com.example.cs2340a.dungenCrawler.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.Background;
import com.example.cs2340a.dungenCrawler.model.Player;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    private Background bg;
    private int screenX, screenY;
    private int screenNum;
    private static float screenRatioX, screenRatioY;
    Bitmap sprite;
    private Player player;
    private Paint paint;
    public GameView(Context context, int screenX, int screenY, int resBGID, Player player, int screenNum) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;
        this.player = player;
        this.screenNum = screenNum;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        bg = new Background(screenX, screenY, getResources(), resBGID);

        paint = new Paint();
    }
    @Override
    public void run() {
        System.out.println("GameView running...");
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(bg.getBackground(), bg.getX(), bg.getY(), paint);
//            System.out.println("Sprite: " + player.getSprite() + "\n" +
//                "PlayerX: " + player.getX() + "\n" +
//                    "PlayerY: " + player.getY());
            if (screenNum == 1) {
                player.setX(990);
                player.setY(800);
            }
            if (player.getAvatarID() == R.drawable.player1) {
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.player1);
                canvas.drawBitmap(sprite, player.getX(), player.getY(), paint);
            } else if (player.getAvatarID() == R.drawable.player2) {
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.player2);
                canvas.drawBitmap(sprite, player.getX(), player.getY(), paint);
            } else if (player.getAvatarID() == R.drawable.player3) {
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.player3);
                canvas.drawBitmap(sprite, player.getX(), player.getY(), paint);
            }
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
