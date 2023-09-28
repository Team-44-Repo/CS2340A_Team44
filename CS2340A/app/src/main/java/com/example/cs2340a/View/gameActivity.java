package com.example.cs2340a.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.cs2340a.R;

public class gameActivity extends AppCompatActivity {

    private double difficulty;
    private int healthPoints;
    private String hpString;
    private Button tempEndButton;
    private TextView playerNameTextView;
    private TextView hpTextView;
    private TextView difficultyText;
    private ImageView sprite;

    private int avatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // gets and displays player name. input from initial configuration activity
        playerNameTextView = findViewById(R.id.playerNameDisplay_id);
        String playernameString = getIntent().getStringExtra("key");
        playerNameTextView.setText(playernameString);

        // Get difficulty selected from Main screen.
        difficulty = getIntent().getDoubleExtra("difficulty", 1);
        // starting HP 100 for easy, 75 for med, 50 for hard.
        healthPoints = (int) (100 * difficulty);
        // Display starting health points
        //hpString = String.valueOf(healthPoints);
        hpTextView = findViewById(R.id.healthPoints_id);
        //hpTextView.setText(healthPoints);
        hpTextView.setText("HP: " + healthPoints);

        difficultyText = findViewById(R.id.dificulty_id);
        if (difficulty == 0.5) {
            difficultyText.setText("difficulty: Hard");
        } else if (difficulty == 0.75) {
            difficultyText.setText("difficulty: medium");
        } else {
            difficultyText.setText("difficulty: easy");
        }




        // gets sprite
        avatar = getIntent().getIntExtra("avatar", 3);
        sprite = findViewById(R.id.spriteView);
        if (avatar == 1) {
            sprite.setImageDrawable(getResources().getDrawable(R.drawable.player1));
        } else if (avatar == 2) {
            sprite.setImageDrawable(getResources().getDrawable(R.drawable.player2));
        } else if (avatar == 3) {
            sprite.setImageDrawable(getResources().getDrawable(R.drawable.player3));
        }


        //temporary button to get to the end screen.
        tempEndButton = (Button) findViewById(R.id.tempEndButton_id);

        tempEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(gameActivity.this, endActivity.class);
                startActivity(intent);

            }
        });
    }
}