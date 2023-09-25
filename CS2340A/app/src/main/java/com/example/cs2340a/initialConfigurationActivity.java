package com.example.cs2340a;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ImageButton;

public class initialConfigurationActivity extends AppCompatActivity {

    String playerName = "Mark Test";
    EditText playerNameInput;

    Button startGameButton;
    Button exitbtn;
//    ImageButton avatar1 = (ImageButton) findViewById(R.id.avatar1);
//    ImageButton avatar2 = (ImageButton) findViewById(R.id.avatar2);
//    ImageButton avatar3 = (ImageButton) findViewById(R.id.avatar3);
    private int avatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration_activty);

        playerNameInput = (EditText) findViewById(R.id.playerNameInput_id);
        startGameButton = (Button) findViewById(R.id.startGameButton_id);

        //exit button functionality
        exitbtn = (Button)findViewById(R.id.exitbtn);
        exitbtn.setOnClickListener(v -> {
            Intent exit = new Intent(Intent.ACTION_MAIN);
            exit.addCategory(Intent.CATEGORY_HOME);
            exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(exit);
        });

        startGameButton.setOnClickListener(v -> {

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

            //get character selection
            RadioGroup characterRadioGroup = findViewById(R.id.characterSelectRadioGroup_id);
            avatar = 1;

            switch (characterRadioGroup.getCheckedRadioButtonId()) {
                case R.id.character1:
                    avatar = 1;
                    break;
                case R.id.character2:
                    avatar = 2;
                    break;
                case R.id.character3:
                    avatar = 3;
                    break;
                default:
                    avatar = 1;
                    break;
            }

                //check if player name is valid and if sprite selected
                if (checkAllFields()) {
                    Intent game = new Intent(initialConfigurationActivity.this, gameActivity.class);
                    game.putExtra("key", playerName);
                    game.putExtra("difficulty", difficulty);
                    game.putExtra("avatar", avatar);
                    startActivity(game);
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