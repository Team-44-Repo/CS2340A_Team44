package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.model.PlayerPosition;

public class EndViewModel extends AppCompatActivity {
    private PlayerPosition playerPosition;
    private TextView winningTV;
    //TextView scoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Player player = getIntent().getParcelableExtra("player");

        winningTV = findViewById(R.id.WinningText_id);
        if (player.getHealthPoints() <= 0) {
            winningTV.setText("GAME OVER");
        } else {
            winningTV.setText("YOU WIN!!!");
        }



        //scoreTV = findViewById(R.id.finalScore_id);
        //scoreTV.setText((CharSequence) player.getScore());



        // when the game ends, this method should be called to see if score should be set to
        // leaderboard
        // takes in the name of the player and score they just received

        // local fields
        Button restartBtn = (Button) findViewById(R.id.restartBtn);

        // restart button functionality
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndViewModel.this,
                        InitialConfigViewModel.class);
                startActivity(intent);
            }
        });
    }
}