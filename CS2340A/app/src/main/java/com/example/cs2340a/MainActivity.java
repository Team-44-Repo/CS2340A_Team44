package com.example.cs2340a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button exitBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton_id);
        exitBtnStart = (Button) findViewById(R.id.exitBtnStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, initialConfigurationActivity.class);
                startActivity(intent);

            }
        });

        //exit button functionality
        exitBtnStart.setOnClickListener(v -> {
            Intent exit = new Intent(Intent.ACTION_MAIN);
            exit.addCategory(Intent.CATEGORY_HOME);
            exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(exit);
        });

    }
}