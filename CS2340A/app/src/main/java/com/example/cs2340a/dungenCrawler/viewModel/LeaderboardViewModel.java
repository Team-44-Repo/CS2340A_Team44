package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340a.R;

import com.example.cs2340a.dungenCrawler.model.Player;

public class LeaderboardViewModel extends AppCompatActivity {

    //public Leaderboard leaderboard;

    private long timeLeft;

    private Player player;

    //private String[] names;

    //private long[] scores;
    private TextView scoreboard;

    private TextView playerNameTV;

    //using leaderboard from Leaderboard class, but only getting the single instance
    public LeaderboardViewModel() {
        //leaderboard = Leaderboard.getInstance();
    }
    //when the game ends, this method should be called to see if score should be set to leaderboard
    //takes in the name of the player and score they just received

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_view_model);
        //leaderboard = Leaderboard.getInstance();
        playerNameTV = findViewById(R.id.playerNameDisplayEnd_id);
        scoreboard = findViewById(R.id.score_id);
        timeLeft = getIntent().getLongExtra("timeLeftInMilliseconds", timeLeft);


        player = getIntent().getParcelableExtra("player");
        playerNameTV.setText(player.getPlayerName());



        scoreboard.setText("" + player.getPlayerName() + ", " + timeLeft);

        Button restartBtn = (Button) findViewById(R.id.restartBtn);

        // restart button functionality
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LeaderboardViewModel.this,
                        InitialConfigViewModel.class);
                startActivity(intent);
            }
        });
    }



}

