package com.example.cs2340a.dungenCrawler.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import com.example.cs2340a.dungenCrawler.model.Background;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    private Background bg1, bg2, bg3;
    private int screenX, screenY;
    private float screenRatioX, screenRatioY;
    private Paint paint;
    public GameView(Context context, int screenX, int screenY, int resID) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        bg1 = new Background(screenX, screenY, getResources(), resID);

//        bg1.setX(screenX);

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
        System.out.println("Drawing...");
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(bg1.getBackground(), bg1.getX(), bg1.getY(), paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep() {
        System.out.println("Sleeping...");
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        System.out.println("Updating...");
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
