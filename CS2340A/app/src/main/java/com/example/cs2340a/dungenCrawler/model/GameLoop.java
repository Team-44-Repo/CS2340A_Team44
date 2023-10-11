package com.example.cs2340a.dungenCrawler.model;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.SurfaceHolder;

import androidx.annotation.NonNull;

public class GameLoop extends Thread implements Parcelable {
    public static final double MAX_UPS = 30.0;
    private static final double UPS_PERIOD = 1E+3/MAX_UPS;

    private GameConfig game;
    private SurfaceHolder surfaceHolder;

    private boolean isRunning = false;
    private double averageUPS;
    private double averageFPS;
    long startTime;
    long elapsedTime;
    long sleepTime;


    public GameLoop(GameConfig game) {
        this.game = game;
    }
    public GameLoop(GameConfig game, SurfaceHolder surfaceHolder) {
        this.game = game;
        this.surfaceHolder = surfaceHolder;
    }

    protected GameLoop(Parcel in) {
        game = in.readParcelable(GameConfig.class.getClassLoader());
        isRunning = in.readByte() != 0;
        averageUPS = in.readDouble();
        averageFPS = in.readDouble();
        startTime = in.readLong();
        elapsedTime = in.readLong();
        sleepTime = in.readLong();
    }

    public static final Creator<GameLoop> CREATOR = new Creator<GameLoop>() {
        @Override
        public GameLoop createFromParcel(Parcel in) {
            return new GameLoop(in);
        }

        @Override
        public GameLoop[] newArray(int size) {
            return new GameLoop[size];
        }
    };

    public double getAverageUPS() {
        return averageUPS;
    }

    public double getAverageFPS() {
        return averageFPS;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }

    @Override
    public void run() {
        super.run();

        int updateCount = 0;
        int frameCount = 0;

        Canvas canvas = null;
        startTime = System.currentTimeMillis();
        while(isRunning) {
            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    game.update();
                    updateCount++;

                    game.draw(canvas);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } finally {
                if(canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        frameCount++;
					} catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long) (updateCount*UPS_PERIOD - elapsedTime);
            if(sleepTime > 0) {
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while(sleepTime < 0 && updateCount < MAX_UPS-1) {
                game.update();
                updateCount++;
                elapsedTime = System.currentTimeMillis() - startTime;
                sleepTime = (long) (updateCount*UPS_PERIOD - elapsedTime);
            }
            elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime >= 1000) {
                averageUPS = updateCount / (1E-3 * elapsedTime);
                averageFPS = frameCount / (1E-3 * elapsedTime);
                updateCount = 0;
                frameCount = 0;
                startTime = System.currentTimeMillis();
            }
        }
    }
    public void stopLoop() {
        isRunning = false;
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getElapsedTime() {
        return (int) elapsedTime / 1000;
    }
    public long getStartTime() {
        return startTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(game, i);
        parcel.writeByte((byte) (isRunning ? 1 : 0));
        parcel.writeDouble(averageUPS);
        parcel.writeDouble(averageFPS);
        parcel.writeLong(startTime);
        parcel.writeLong(elapsedTime);
        parcel.writeLong(sleepTime);
    }
}
