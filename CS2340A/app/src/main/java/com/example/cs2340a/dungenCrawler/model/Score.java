package com.example.cs2340a.dungenCrawler.model;

import android.os.CountDownTimer;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;


public class Score implements Parcelable {
    private CountDownTimer score;
    private long timeLeftInMilliseconds = 60000;
    private String timeLeftText;
    private boolean isActive;
    private int seconds;

    public Score(long timeLeftInMilliseconds, boolean isActive) {
        System.out.println("Instantiating Score...");
        this.timeLeftInMilliseconds = timeLeftInMilliseconds;
        System.out.println("TimeLeftInMillseconds: " + timeLeftInMilliseconds);
        this.isActive = isActive;
        System.out.println("isActive: " + isActive);
    }

    protected Score(Parcel in) {
        timeLeftInMilliseconds = in.readLong();
        timeLeftText = in.readString();
        isActive = in.readByte() != 0;
        seconds = in.readInt();
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };


    public void startScore() {
        if (isActive) {
            System.out.println("Score starting...");
            startTimer();
        }
    }


    public void startTimer() {
        this.score = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                System.out.println(timeLeftInMilliseconds);
                timeLeftInMilliseconds = l;
                updateScore();
            }

            @Override
            public void onFinish() {
            }
        };
    }



    public void updateScore() {
        this.seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        timeLeftText = "" + seconds;
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

    public String getSecondsString() {
        return "Score: " + seconds; }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(timeLeftInMilliseconds);
        parcel.writeString(timeLeftText);
        parcel.writeByte((byte) (isActive ? 1 : 0));
        parcel.writeInt(seconds);
    }
}
