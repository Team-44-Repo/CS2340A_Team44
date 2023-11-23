package com.example.cs2340a.dungenCrawler.viewModel;

import android.content.Context;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import com.example.cs2340a.dungenCrawler.model.GameConfig;

public class GameLoop extends SurfaceView implements Runnable, SurfaceHolder.Callback {
    /*
    This is how our game operates. Since it is Runnable, it allows for a continous loop to go on
    until the GameLoop is no longer needed (AKA the game ends). Every loop, it runs 3 methods:
    update(), draw(), and sleep() (more detail on them at their method locations). Anything that
    needs to be monitored needs to be in here.
     */

    private Callback callback;
    private Thread thread;
    private boolean isPlaying;
    private boolean youWon = false;
    private boolean youLost = false;

    public GameLoop(Context context) {
        super(context);
    }


    /*
    public GameLoop(Context context, GameConfig gameConfig) {
        this(context);
        this.gameConfig = gameConfig;
        System.out.println(gameConfig.difType());
        // bg = gameConfig.getBG();
        // bg.createBitmap(bg.getPoint(), getResources(), bg.getResID());
    } */

    /*
    This is how our game is running. It is an overriden method from the Runnable interface and
    allows us to create a continuous loop that doesn't shut down.
     */
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

    /*
    This is where things that constantly need to be checked should be put (collisions, item
    interactions, score updates, etc.). It will constantly check whatever you put in here and
    update it in real time to our current gameplay.
     */
    private void update() {
        //gameConfig.addRoom1Enemies();
        Log.d("in update()", "");
        GameConfig.getPlayer().update();
        //player made
        GameConfig.notifyObservers();
        GameConfig.getPlayer().getSlingshot().updatePellet();


        // Border collisions
        if (GameConfig.getPlayer().getCollisionShape().intersect(GameConfig.getCurrRoom().
                getCollisionMap().getBottomBorder())) {
            GameConfig.getPlayer().
                    setY(GameConfig.getCurrRoom().getCollisionMap().getBottomBorderCollisionMark());
        } else if (GameConfig.getPlayer().getCollisionShape().intersect(GameConfig.getCurrRoom().
                getCollisionMap().getTopBorder())) {
            GameConfig.getPlayer().
                    setY(GameConfig.getCurrRoom().getCollisionMap().getTopBorderCollisionMark());
        } else if (GameConfig.getPlayer().getCollisionShape().intersect(GameConfig.getCurrRoom().
                getCollisionMap().getLeftBorder())) {
            GameConfig.getPlayer().
                    setX(GameConfig.getCurrRoom().getCollisionMap().getLeftBorderCollisionMark());
        } else if (GameConfig.getPlayer().getCollisionShape().intersect(GameConfig.getCurrRoom().
                getCollisionMap().getRightBorder())) {
            GameConfig.getPlayer().
                    setX(GameConfig.getCurrRoom().getCollisionMap().getRightBorderCollisionMark());
        }

        // Doorway Collisions
        if (GameConfig.getPlayer().getCollisionShape().
                intersect(GameConfig.getCurrRoom().getCollisionMap().getDoorway1())
                && GameConfig.getCurrRoom().getRoomID() == 3) {
            youWon = true;
            setIsPlaying(false);
        } else if (GameConfig.getPlayer().getCollisionShape().
                intersect(GameConfig.getCurrRoom().getCollisionMap().getDoorway1())) {
            GameConfig.switchRoom(GameConfig.getCurrRoom().getRoomID());
        }

        //end game if health points have dropped to zero
        if (GameConfig.getHealthPoints() <= 0) {
            System.out.println("YOU LOST: " + youLost);
            youLost = true;
            setIsPlaying(false);
        }

        // Weapon Collisions
        if (GameConfig.getEnemy1().isActive() && GameConfig.getPlayer().getSlingshot().getPellet().
                intersect(GameConfig.getEnemy1().getCollisionShape()) && GameConfig.getPlayer().
                getSlingshot().getShooting()) {
            GameConfig.getEnemy1().setActive(false);
            GameConfig.getPlayer().getSlingshot().setShooting(false);
            GameConfig.setScore(GameConfig.getScore() + 5);
            //GameConfig.setEnemies(null, GameConfig.getEnemy2());
        } else if (GameConfig.getEnemy2().isActive() && GameConfig.getPlayer().getSlingshot().
                getPellet().
                intersect(GameConfig.getEnemy2().getCollisionShape()) && GameConfig.getPlayer().
                getSlingshot().getShooting()) {
            GameConfig.getEnemy2().setActive(false);
            GameConfig.getPlayer().getSlingshot().setShooting(false);
            GameConfig.setScore(GameConfig.getScore() + 5);
            //GameConfig.setEnemies(GameConfig.getEnemy1(), null);
        }

        // PowerUp Collisions
        if (GameConfig.getPowerUp().getCollisionShape().
                intersect(GameConfig.getPlayer().getCollisionShape())) {
            // System.out.println("power up collision, will work if power up active");
            System.out.println("COLLIDING WITH POWERUP");
            GameConfig.getPowerUp().checkCollision(GameConfig.getPlayer());
            // used up power up so set to false
            GameConfig.getPowerUp().setActive(false);
        }

        //GameConfig.getPowerUp().checkCollision(GameConfig.getPlayer());
    }
    public boolean won() {
        return youWon; }
    public boolean lost() {
        return youLost; }
    public void setIsPlaying(boolean val) {
        this.isPlaying = val; }

    /*
    This is how we are seeing everything on screen. It takes the updated information changed by
    update() which is called before it and redraws the entire screen in real time with the updated
    information. It draws this faster than we can see.
     */
    private void draw() {
        Log.d("in draw()", "");
        if (getHolder().getSurface().isValid()) {
            System.out.println("DRAWING");
            Canvas canvas = getHolder().lockCanvas();
            GameConfig.getCurrRoom().draw(canvas, getResources());
            GameConfig.getPlayer().draw(canvas, getResources());
            GameConfig.getPlayer().getSlingshot().drawPellet(canvas, getResources());
            GameConfig.drawEnemies(canvas, getResources());
            GameConfig.drawHP(canvas);
            GameConfig.getPowerUp().draw(canvas, getResources());
            GameConfig.getPlayer().getSlingshot().draw(canvas, getResources());
            GameConfig.getPowerUp().drawIcon(canvas, getResources());
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    /*
    This method gives us the brief amount of time for everything to process the changes correctly
    so our game doesn't crash. THIS DOES NOT NEED TO BE TOUCHED ANY FURTHER.
     */
    private void sleep() {
        Log.d("in sleep()", "");
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    This resumes our game from our previous stopping point if we used pause().
     */
    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    /*
    This temporarily pauses our run state without deleting our information.
     */
    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
