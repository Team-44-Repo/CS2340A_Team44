package com.example.cs2340a.dungenCrawler.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.Background;
import com.example.cs2340a.dungenCrawler.model.Player;

public class GameView extends SurfaceView implements Runnable, SurfaceHolder.Callback, View.OnKeyListener {

    private Thread thread;
    private boolean isPlaying;
    private int x, y;
    private Background bg;
    private int screenX, screenY;
    private int screenNum;
    private static float screenRatioX, screenRatioY;
    Bitmap sprite;
    private Player player;
    private Paint paint;
    private KeyEvent up;
    private KeyEvent down;
    private KeyEvent left;
    private KeyEvent right;
    public GameView(Context context, int screenX, int screenY, int resBGID, Player player, int screenNum) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;
        this.player = player;
        this.screenNum = screenNum;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        if (screenNum == 1) {
            player.setX(990);
            player.setY(800);
            this.x = 990;
            this.y = 800;
        }

        up = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_W);
        down = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_S);
        left = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_A);
        right = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_D);

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
        if (player.getMovement().onKey(up)) {
            System.out.println("Moving Up");
            y -= 30;
            player.setY(y);
        }
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                player.setX((int) event.getX());
                player.setY((int) event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                player.setX((int) event.getX());
                player.setY((int) event.getY());
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onKey(View view, int i, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            System.out.println("ActionDown...");
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_W:
                    player.getMovement().setUp(true);
                    break;
//                case KeyEvent.KEYCODE_A:
//                    isMovingLeft = true;
//                    break;
//                case KeyEvent.KEYCODE_S:
//                    isMovingDown = true;
//                    break;
//                case KeyEvent.KEYCODE_D:
//                    isMovingRight = true;
//                    break;
            }
        }

        return true;
    }

    public KeyEvent getUp() {
        return up;
    }
}
