package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;


import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.example.cs2340a.dungenCrawler.model.GameConfig;
//import com.example.cs2340a.dungenCrawler.model.GameConfig;


public class GameRoom1ViewModel extends AppCompatActivity implements GameLoop.Callback {
    //private GameConfig gameConfig;
    private GameLoop gameLoop;
    private Point point;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.d("----room1--------", "------------------------");
        point = new Point();

        getWindowManager().getDefaultDisplay().getSize(point);


        // Initializing Runnable GameLoop
        gameLoop = new GameLoop(this);
        gameLoop.setCallback(this);
        setContentView(gameLoop);

        //if (gameLoop.lost()) {
        // System.out.println("I LOST");
        //    gameOver();
        //}

        if (gameLoop.won() || gameLoop.lost()) {
            switchLeaderboardView();
        }
    }

    @Override
    public void onRunnablePaused() {
        // This code is executed when the gameView is paused from within onTouchEvent.
        Log.d("executed after the gameView", "");
        switchLeaderboardView();
    }

    public void switchLeaderboardView() {
        System.out.println("You won!");
        Log.d("switchLeaderboardView()", "");
        Intent game2 = new Intent(GameRoom1ViewModel.this, LeaderboardViewModel.class);
        //game2.putExtra("gameConfig", gameConfig);
        startActivity(game2);
    }

    public void gameOver() {
        System.out.println("IN GAME OVER");
        Intent endgame = new Intent(GameRoom1ViewModel.this, LeaderboardViewModel.class);
        startActivity(endgame);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameLoop.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameLoop.resume();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    /*
    Allows the Player to move with WASD key movement.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("KEY DOWN");
        switch (keyCode) {
        case KeyEvent.KEYCODE_W:
            GameConfig.getPlayer().setY(GameConfig.getPlayer().getY()
                    - GameConfig.getPlayer().getSpeed());
            return true;
        case KeyEvent.KEYCODE_A:
            GameConfig.getPlayer().setX(GameConfig.getPlayer().getX()
                    - GameConfig.getPlayer().getSpeed());
            return true;
        case KeyEvent.KEYCODE_S:
            GameConfig.getPlayer().setY(GameConfig.getPlayer().getY()
                    + GameConfig.getPlayer().getSpeed());
            return true;
        case KeyEvent.KEYCODE_D:
            GameConfig.getPlayer().setX(GameConfig.getPlayer().getX()
                    + GameConfig.getPlayer().getSpeed());
            return true;
        case KeyEvent.KEYCODE_E:
            GameConfig.getPlayer().getSlingshot().shootRight();
            return true;
        case KeyEvent.KEYCODE_Q:
            GameConfig.getPlayer().getSlingshot().shootLeft();
            return true;
        default:
            return super.onKeyDown(keyCode, event);
        }
        //because player has moved >> update enemies (and check for collisions)
    }
}

