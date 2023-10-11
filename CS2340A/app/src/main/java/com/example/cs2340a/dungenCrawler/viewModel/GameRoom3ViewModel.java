package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Player;

public class GameRoom3ViewModel extends AppCompatActivity {

    private double difficulty;
    //private int healthPoints;
    private Button tempEndButton;
    //private ImageView sprite;
    //private Bitmap bitmap;
    private Canvas canvas;
    //Bitmap.Config config;

    //viewModel elements >> findViewById()
    private TextView playerNameTV;
    private TextView difficultyTV;
    private TextView hpTV;
    private ImageView sprite;
    private Button tempNextBtn;
    private Button tempEndBtn;


    private int avatar; // del when working
    //private Tilemap tilemap;
    //private SpriteSheet spriteSheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //tilemap = new Tilemap(spriteSheet);
        //canvas.drawBitmap(tilemap);
        //setFocusable(true);
        setContentView(R.layout.activity_game_room3_view_model);
        //bitmap = Bitmap.createBitmap(600, 600, config);
        //canvas = new Canvas();

        //viewModel elements >> findViewById()
        playerNameTV = findViewById(R.id.playerNameDisplay_id);
        difficultyTV = findViewById(R.id.dificulty_id);
        hpTV = findViewById(R.id.healthPoints_id);
        sprite = findViewById(R.id.spriteView);
        //tempNextBtn = findViewById(R.id.#);
        tempEndBtn = findViewById(R.id.tempEndButton_id);


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


        //temporary button to get to the end screen.
        tempEndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GameRoom3ViewModel.this, EndViewModel.class);
                startActivity(intent);

            }
        });
    }
}