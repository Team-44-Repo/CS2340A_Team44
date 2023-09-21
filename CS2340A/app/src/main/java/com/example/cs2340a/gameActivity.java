package com.example.cs2340a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameActivity extends AppCompatActivity {

    Button tempEndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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