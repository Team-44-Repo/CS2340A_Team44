package com.example.cs2340a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class initialConfigurationActivity extends AppCompatActivity {

    Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_configuration_activty);

        startGameButton = (Button) findViewById(R.id.startGameButton_id);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup_id);
                int difficulty;

                switch (difficultyRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioEasy_id:
                        difficulty = 20;
                        break;
                    case R.id.radioMedium_id:
                        difficulty = 10;
                        break;
                    case R.id.radioHard_id:
                        difficulty = 5;
                        break;
                    default:
                        difficulty = 20;
                        break;
                }

                Intent intent = new Intent(initialConfigurationActivity.this, gameActivity.class);
                intent.putExtra("difficulty", difficulty);
                startActivity(intent);

            }
        });

    }
}