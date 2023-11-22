package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cs2340a.R;

public class MainViewModel extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //local fields
        Button startButton = (Button) findViewById(R.id.startButton_id);
        Button exitBtnStart = (Button) findViewById(R.id.exitBtnStart);

        //start button functionality
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainViewModel.this,
                        InitialConfigViewModel.class);
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