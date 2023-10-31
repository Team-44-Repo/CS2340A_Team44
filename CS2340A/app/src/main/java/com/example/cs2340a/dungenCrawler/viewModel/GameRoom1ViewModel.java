package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;


import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.example.cs2340a.dungenCrawler.model.GameConfig;


public class GameRoom1ViewModel extends AppCompatActivity implements GameLoop.Callback {
    private GameConfig gameConfig;
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

        gameConfig = getIntent().getParcelableExtra("gameConfig");

        // Initializing Runnable GameLoop
        gameLoop = new GameLoop(this, gameConfig);
        gameLoop.setCallback(this);
        setContentView(gameLoop);

        if (gameLoop.won()) {
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
        game2.putExtra("gameConfig", gameConfig);
        startActivity(game2);
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
            gameConfig.getPlayer().setY(gameConfig.getPlayer().getY() - 30);
            return true;
        case KeyEvent.KEYCODE_A:
            gameConfig.getPlayer().setX(gameConfig.getPlayer().getX() - 30);
            return true;
        case KeyEvent.KEYCODE_S:
            gameConfig.getPlayer().setY(gameConfig.getPlayer().getY() + 30);
            return true;
        case KeyEvent.KEYCODE_D:
            gameConfig.getPlayer().setX(gameConfig.getPlayer().getX() + 30);
            return true;
        default:
            return super.onKeyDown(keyCode, event);
        }
    }
}

