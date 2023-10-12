package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.GameConfig;

import com.example.cs2340a.dungenCrawler.model.Player;


public class GameRoom1ViewModel extends AppCompatActivity {

    private double difficulty;
    //private int healthPoints;
    private Button toScreen2;
    //private ImageView sprite;
    //private Bitmap bitmap;
    private Canvas canvas;
    //Bitmap.Config config;
    //private GameLoop gameLoop;
    //private boolean gameActive;
    //viewModel elements >> findViewById()
    private TextView playerNameTV;
    private TextView difficultyTV;
    private TextView hpTV;
    private TextView scorePlace;
    private ImageView sprite;
    private Button tempNextBtn;
    private Button tempEndBtn;
    //    private Score score;
    private int seconds;
    private CountDownTimer score;
    private long timeLeftInMilliseconds = 60000;
    private boolean isActive = true;


    private int avatar; // del when working
    //private Tilemap tilemap;
    //private SpriteSheet spriteSheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tilemap = new Tilemap(spriteSheet);
        //canvas.drawBitmap(tilemap);
        //setFocusable(true);
        setContentView(R.layout.activity_game);
        //bitmap = Bitmap.createBitmap(600, 600, config);
        //canvas = new Canvas();

        //viewModel elements >> findViewById()
        playerNameTV = findViewById(R.id.playerNameDisplay_id);
        difficultyTV = findViewById(R.id.dificulty_id);
        hpTV = findViewById(R.id.healthPoints_id);
        sprite = findViewById(R.id.spriteView);
        scorePlace = findViewById(R.id.score_id);
        //tempNextBtn = findViewById(R.id.#);
        toScreen2 = findViewById(R.id.toScreen2_id);



        //gets Player and GameConfig objects
        Player player = getIntent().getParcelableExtra("player");
        GameConfig gameConfig = getIntent().getParcelableExtra("gameConfig");

        //and displays properties of Player & GameConfig
        //  1   player name
        playerNameTV.setText(player.getPlayerName());

        //  2   difficulty
        double diff = gameConfig.getDifficulty();
        if (diff == 0.5) {
            difficultyTV.setText("Hard Mode");
        } else if (diff == 0.75) {
            difficultyTV.setText("Regular Mode");
        } else {
            difficultyTV.setText("Easy Mode");
        }

        //  2.5 healthpoints
        hpTV.setText("HP: " + player.getHealthPoints());


        // ************ I CANT GET THIS TO WORK using the object's sprite *******
        //  3   gets sprite
        //int test = player.getAvatarResId();
        avatar = getIntent().getIntExtra("avatar", 3);

        if (avatar == 1) {
            sprite.setImageResource(R.drawable.player1);
        } else if (avatar == 2) {
            sprite.setImageResource(R.drawable.player2);
        } else if (avatar == 3) {
            sprite.setImageResource(R.drawable.player3);
        }
        // ************ old version - need to change  *******

        //        score = new Score(timeLeft, true);
        //        score.setActive(true);
        //        score.startScore(scorePlace);


        if (isActive) {
            startTimer();
        }



        //temporary button to get to the next screen.
        toScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GameRoom1ViewModel.this, GameRoom2ViewModel.class);
                intent.putExtra("avatar", avatar);
                intent.putExtra("player", player);
                intent.putExtra("gameConfig", gameConfig);
                intent.putExtra("timeLeftInMilliseconds", timeLeftInMilliseconds);

                startActivity(intent);
            }
        });
    }

    private void startTimer() {
        score = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateScore();
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

    private void updateScore() {
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + seconds;

        scorePlace.setText(timeLeftText);
    }
}