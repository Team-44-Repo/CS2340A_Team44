package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cs2340a.R;

public class EndViewModel extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // when the game ends, this method should be called to see if score should be set to leaderboard
        // takes in the name of the player and score they just received
        // LeaderboardViewModel.addScores(String name, int score)

        // local fields
        Button restartBtn = (Button) findViewById(R.id.restartBtn);

        // restart button functionality
        restartBtn.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainViewModel.this,
                        InitialConfigViewModel.class);
                startActivity(intent);
            }
        });
    }
}