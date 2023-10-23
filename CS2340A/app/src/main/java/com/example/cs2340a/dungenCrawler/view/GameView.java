package com.example.cs2340a.dungenCrawler.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.Background;
import com.example.cs2340a.dungenCrawler.model.CollisionMap;
import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.model.Room;


public class GameView extends SurfaceView implements Runnable,
        SurfaceHolder.Callback, View.OnKeyListener {

    private Callback callback;
    private Thread thread;
    private CollisionMap collisionMap = new CollisionMap(); //creates a new CollisionMap object
    private int[][] collisionMapArray = collisionMap.getCollisionMap(); // gets the actual array
    private int score = 0;
    private boolean done = false;
    private boolean isPlaying;
    private int x;
    private int y;
    private int prevX, prevY;
    private Background bg;
    private Room currRoom;
    private int screenX, screenY;
    private int screenNum;
    private static float screenRatioX, screenRatioY;
    Bitmap sprite;
    private Player player;
    private Paint paint;
    private Paint whitePaint;
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
        screenRatioX = 2400f / screenX;
        screenRatioY = 1080f / screenY;

        player.getScore().setActive(true);
        player.getScore().startScore();

        //Create 3 Room Objects
        Room room1 = new Room("room1", 1200, 540,310,460,2090,2400);
        Room room2 = new Room("room2", 30, 400,0,20,720,890);
        Room room3 = new Room("room3", 800, 800,420,580,2090,2400);

        room1.setConnectedRoom(room2);
        room2.setConnectedRoom(room3);
        //room3.setConnectedRoom(exit);

        //set current room to what was passed in from viewModel
        switch (screenNum) {
            case 1:
                currRoom = room1;
                break;
            case 2:
                currRoom = room2;
                break;
            case 3:
                currRoom = room3;
                break;
        }

        //makes player sprite start in the center of the screen
        player.setX(currRoom.getInitialPlayerX());
        player.setY(currRoom.getInitialPlayerY());
        this.x = currRoom.getInitialPlayerX();
        this.y = currRoom.getInitialPlayerY();

        up = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_W);
        down = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_S);
        left = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_A);
        right = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_D);

        bg = new Background(screenX, screenY, getResources(), resBGID);

        paint = new Paint();
        whitePaint = new Paint();
        int color = R.color.white;
        whitePaint.setColor(getResources().getColor(color));


        Log.d("leftX:" + currRoom.getDoorwayLeftX(), "");
    }// end of constructor

    public interface Callback {
        void onRunnablePaused();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    @Override
    public void run() {
        System.out.println("GameView running...");
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
        score++;
    }

    private void draw() {
        Log.d("in draw()", "");
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(bg.getBackground(), bg.getX(), bg.getY(), paint);
            whitePaint.setTextSize(50);
            canvas.drawText(player.getPlayerName(), 50, 50, whitePaint);
            canvas.drawText(player.getDifficultyTitle(), 500, 50, whitePaint);
            canvas.drawText(player.getHealthString(), 2000, 50, whitePaint);
            canvas.drawText("Score: " + score, 1500, 1000, whitePaint);

            if (player.getAvatarID() == R.drawable.player1) {
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.player1);
                canvas.drawBitmap(sprite, player.getX() - 24, player.getY(), paint);
            } else if (player.getAvatarID() == R.drawable.player2) {
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.player2);
                canvas.drawBitmap(sprite, player.getX() - 24, player.getY(), paint);
            } else if (player.getAvatarID() == R.drawable.player3) {
                sprite = BitmapFactory.decodeResource(getResources(), R.drawable.player3);
                canvas.drawBitmap(sprite, player.getX() - 24, player.getY(), paint);
            }
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

    public boolean getDone() {
        return done;
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
        Log.d("in onTouchEvent", "");
        x = (int) event.getX();
        y = (int) event.getY();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("in [0] actionDown", "");
                // took out click to move sprite to where your mouse is
                //player.setX((int) event.getX());
                //player.setY((int) event.getY());
                //Log.d(x + "," + y, "");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.d("in [0] actionMove", "");
                prevX = player.getX();
                prevY = player.getY();
                Log.d("x:" + x + " y:" + y, "");
                Log.d("door|" + currRoom.getDoorwayLeftX() + ", " + currRoom.getDoorwayBottomY(), "");
                //checking for player collision with doorway
                Log.d("checking if doorway", "");
                if (x >= currRoom.getDoorwayLeftX() && x <= currRoom.getDoorwayRightX()) {
                    if (y >= currRoom.getDoorwayTopY() && y <= currRoom.getDoorwayBottomY()) {
                        player.setX(x);
                        player.setY(y);
                        pause();
                        Log.d("paused-------------", "");
                    }
                } else if (x < 20) {
                    //Log.d("left: " + x + "," + y, "");
                    //player.setX(prevX);
                } else if (x > 2090) {
                    //Log.d("right: " + x + "," + y, "");
                    //player.setX(prevX);
                } else if (y < 3) {
                    //Log.d("top: " + x + "," + y, "");
                    //player.setY(prevY);
                } else if (y > 810) {
                    //Log.d("bottom: " + x + "," + y, "");
                    //player.setY(prevY);
                } else { // there is no collision
                    player.setX(x);
                    player.setY(y);
                }
                //Log.d("post-(" + player.getX() + "," + player.getY(), "");
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
        /*
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            System.out.println("ActionDown...");
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_W:
                    player.getMovement().setUp(true);
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
        */
        return true;
    }


    public KeyEvent getUp() {
        return up;
    }
}