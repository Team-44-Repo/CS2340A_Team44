package com.example.cs2340a.dungenCrawler.model;

import android.os.CountDownTimer;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Score {
    private CountDownTimer score;
    private long timeLeftInMilliseconds = 60000;
    String timeLeftText;
    private boolean isActive;
    int seconds;

    public Score(long timeLeftInMilliseconds, boolean isActive) {
        this.timeLeftInMilliseconds = timeLeftInMilliseconds;
        this.isActive = isActive;
    }

    public void startScore(TextView score) {
        if (isActive) {
            startTimer(score);
        }
    }
    private void startTimer(TextView scoreText) {
        score = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateScore(scoreText);
            }

            @Override
            public void onFinish() {
            }
        };
    }

    private void updateScore(TextView scoreText) {
        seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        timeLeftText = "" + seconds;

        scoreText.setText("Score: " + timeLeftText);
    }

    public String timeLeft() {
        return timeLeftText;
    }

    public boolean getActive() {
        return isActive;
     }
    public void setActive(boolean active) {
        isActive = active;
    }
    public int getSeconds() {
        return seconds;
    }
}
