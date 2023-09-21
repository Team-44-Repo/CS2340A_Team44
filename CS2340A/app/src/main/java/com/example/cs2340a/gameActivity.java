package com.example.cs2340a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameActivity extends AppCompatActivity {

    private double difficulty;
    private int healthPoints;
    private String hpString;
    Button tempEndButton;
    TextView playerNameTextView;
    TextView hpTextView;


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