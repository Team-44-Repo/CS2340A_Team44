package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;


import android.util.Log;
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
    }

    @Override
    public void onRunnablePaused() {
        // This code is executed when the gameView is paused from within onTouchEvent.
        Log.d("executed after the gameView", "");
        switchGameRoom1View();
    }


    public void switchGameRoom1View() {
        Log.d("switchGameRoom1View()", "");
        Intent game2 = new Intent(GameRoom1ViewModel.this, GameRoom2ViewModel.class);
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
}

