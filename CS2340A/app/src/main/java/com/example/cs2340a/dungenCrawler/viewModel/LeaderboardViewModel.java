package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340a.R;

import com.example.cs2340a.dungenCrawler.model.Leaderboard;
import com.example.cs2340a.dungenCrawler.model.Player;

public class LeaderboardViewModel extends AppCompatActivity {

    private Leaderboard leaderboard;

    private int timeLeft;

    private Player player;

    private String[] names;

    private int[] scores;
    private TextView score1;
    private TextView score2;
    private TextView score3;
    private TextView score4;
    private TextView score5;

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

        // Instantiate
        leaderboard = Leaderboard.getInstance();
        playerNameTV = findViewById(R.id.playerNameDisplayEnd_id);
        score1 = findViewById(R.id.score_id);
        score2 = findViewById(R.id.score_id2);
        score3 = findViewById(R.id.score_id3);
        score4 = findViewById(R.id.score_id4);
        score5 = findViewById(R.id.score_id5);

        // Carry over data from past screens
        timeLeft = (int) getIntent().getLongExtra("timeLeftInMilliseconds", timeLeft);
        player = getIntent().getParcelableExtra("player");

        // Initialize Leaderboard stuff
        leaderboard.addScores(timeLeft, player.getPlayerName());
        scores = leaderboard.getScores();
        names = leaderboard.getNames();

        // Set texts
        playerNameTV.setText(player.getPlayerName());
        score1.setText(names[0] + ", " + scores[0]);
        score2.setText(names[1] + ", " + scores[1]);
        score3.setText(names[2] + ", " + scores[2]);
        score4.setText(names[3] + ", " + scores[3]);
        score5.setText(names[4] + ", " + scores[4]);

        // Restart button
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

