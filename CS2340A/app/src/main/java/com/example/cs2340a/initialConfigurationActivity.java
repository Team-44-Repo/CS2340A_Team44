package com.example.cs2340a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

                Intent intent = new Intent(initialConfigurationActivity.this, gameActivity.class);
                startActivity(intent);

            }
        });

    }
}