package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;


import android.util.Log;
import android.view.WindowManager;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.GameConfig;

import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.model.PlayerPosition;
//import com.example.cs2340a.dungenCrawler.view.GameView;


public class GameRoom2ViewModel extends AppCompatActivity implements GameLoop.Callback {
    @Override
    public void onRunnablePaused() {

    }

    //private GameView gameView;
    /*
    private int avatar;
    private Thread thread;
    private Player player;
    private int score;
    private GameConfig gameConfig;
    private PlayerPosition playerPosition; //observer pattern


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.d("----room2--------", "------------------------");
        Point point = new Point();

        getWindowManager().getDefaultDisplay().getSize(point);

        player = getIntent().getParcelableExtra("player");
        gameConfig = getIntent().getParcelableExtra("gameConfig");
        avatar = getIntent().getIntExtra("avatar", R.drawable.player1);
        score = getIntent().getIntExtra("score", 0);
        System.out.println("Score after switch: " + score);
        //compSprite = getIntent().getByteArrayExtra("compSprite");
        //player.setSprite(BitmapFactory.decodeByteArray(compSprite, 0, compSprite.length));


        // Initialize Runnable GameView
        gameView = new GameView(this, point.x, point.y, R.drawable.room2, player, 2);
        gameView.setScore(score);
        gameView.setCallback((GameView.Callback) this);
        //Setting the GameView as the content view
        Log.d("Activating gameView...",  "");
        setContentView(gameView);
        Log.d("right after setContentView",  "");

    }

    @Override
    public void onRunnablePaused() {
        // This code is executed when the gameView is paused from within onTouchEvent.
        Log.d("executed after the gameView", "");
        switchGameRoom1View();
    }


    public void switchGameRoom1View() {
        Log.d("switchGameRoom1View()", "");
        Intent game2 = new Intent(GameRoom2ViewModel.this, GameRoom3ViewModel.class);
        game2.putExtra("score", gameView.getScore());
        game2.putExtra("avatar", avatar);
        game2.putExtra("player", player);
        game2.putExtra("gameConfig", gameConfig);
        startActivity(game2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
     */
}