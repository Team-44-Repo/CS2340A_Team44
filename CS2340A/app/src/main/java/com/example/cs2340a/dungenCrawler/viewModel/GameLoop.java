package com.example.cs2340a.dungenCrawler.viewModel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.cs2340a.dungenCrawler.model.Background;
import com.example.cs2340a.dungenCrawler.model.GameConfig;

public class GameLoop extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private Callback callback;
    private GameConfig gameConfig;
    private Thread thread;
    private boolean isPlaying;
    private Background bg;

    public GameLoop(Context context) {
        super(context);
    }

    public GameLoop(Context context, GameConfig gameConfig) {
        this(context);
        this.gameConfig = gameConfig;
        bg = gameConfig.getBG();
        bg.createBitmap(bg.getPoint(), getResources(), bg.getResID());
    }

    @Override
    public void run() {
        System.out.println("GameLoop running...");
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
        if (!(isPlaying)) {
            if (callback != null) {
                callback.onRunnablePaused(); // Trigger the callback
            }
        }
    }

    private void update() {
        Log.d("in update()", "");
        gameConfig.getPlayer().getScore().setScore(gameConfig.getPlayer().getScore().getScore()
                + 1);
    }

    private void draw() {
        Log.d("in draw()", "");
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(bg.getBackground(), bg.getX(), bg.getY(), new Paint());
            gameConfig.getPlayer().draw(canvas, getResources());
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep() {
        Log.d("in sleep()", "");
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        return gameConfig.getPlayer().getMovement().onTouchLogic(event, gameConfig.getPlayer());
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

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void onRunnablePaused();
    }
}