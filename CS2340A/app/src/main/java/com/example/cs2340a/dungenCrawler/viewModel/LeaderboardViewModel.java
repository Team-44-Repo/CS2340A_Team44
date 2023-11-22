package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340a.R;

import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Leaderboard;

import java.util.Date;

public class LeaderboardViewModel extends AppCompatActivity {

    private Leaderboard leaderboard;

    private int timeLeft;
    private Date date;
    private int hours;
    private int score;
    private int minutes;
    //private GameConfig gameConfig;

    private String[] names;

    private int[] scores;
    private String[] times;
    private TextView score1;
    private TextView score2;
    private TextView score3;
    private TextView score4;
    private TextView score5;

    private TextView playerNameTV;

    private static TextView winLoseTV;

    //using leaderboard from Leaderboard class, but only getting the single instance
    public LeaderboardViewModel() {
        //leaderboard = Leaderboard.getInstance();
    }
    //when the game ends, this method should be called to see if score should be set to leaderboard
    //takes in the name of the player and score they just received

    public static CharSequence getWinLoseText() {
        return winLoseTV.getText();
    }
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

        winLoseTV = findViewById(R.id.WinLoseTV_id);

        // Carry over data from past screens
        //          noting passed from GameRoom1ViewModel !

        if (GameConfig.getHealthPoints() <= 0) {
            winLoseTV.setText("GAME OVER");
        } else {
            winLoseTV.setText("YOU WIN!!!");
        }

        // Initialize Leaderboard stuff
        date = new Date();
        hours = date.getHours();
        minutes = date.getMinutes();
        score = GameConfig.getPlayer().getScore().getScore();
        String time = hours + ":" + minutes;

        leaderboard.addScores(score, GameConfig.getPlayer().getPlayerName(), time);
        scores = leaderboard.getScores();
        names = leaderboard.getNames();
        times = leaderboard.getTimes();

        // Set texts
        playerNameTV.setText(GameConfig.getPlayer().getPlayerName());
        score1.setText(names[0] + ", " + scores[0] + ", " + times[0]);
        score2.setText(names[1] + ", " + scores[1] + ", " + times[1]);
        score3.setText(names[2] + ", " + scores[2] + ", " + times[2]);
        score4.setText(names[3] + ", " + scores[3] + ", " + times[3]);
        score5.setText(names[4] + ", " + scores[4] + ", " + times[4]);

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

