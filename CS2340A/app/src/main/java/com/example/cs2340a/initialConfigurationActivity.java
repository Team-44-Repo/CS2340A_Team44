package com.example.cs2340a;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class initialConfigurationActivity extends AppCompatActivity {

    String playerName = "Mark Test";
    EditText playerNameInput;

    Button startGameButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration_activty);

        playerNameInput = (EditText) findViewById(R.id.playerNameInput_id);
        startGameButton = (Button) findViewById(R.id.startGameButton_id);


        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get player name
                playerName = playerNameInput.getText().toString();

                //get difficulty selection
                RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup_id);
                double difficulty = 1.0;

                switch (difficultyRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioEasy_id:
                        difficulty = 1.0;
                        break;
                    case R.id.radioMedium_id:
                        difficulty = 0.75;
                        break;
                    case R.id.radioHard_id:
                        difficulty = 0.5;
                        break;
                    default:
                        difficulty = 1.0;
                        break;
                }
                

                //get sprint selection

                //check if player name is valid and if sprite selected
                if (checkAllFields()) {
                    Intent game = new Intent(initialConfigurationActivity.this, gameActivity.class);
                    game.putExtra("key", playerName);
                    game.putExtra("difficulty", difficulty);
                    startActivity(game);
                }
            }
        });

    }

    private boolean checkAllFields () {
        if (playerName == null || playerName.trim().isEmpty()) {
            playerNameInput.setError("Must input a player name.");
            return false;
        }
        // after all validation return true.
        return true;
    }
}