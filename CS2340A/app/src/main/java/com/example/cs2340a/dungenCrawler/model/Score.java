package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;


public class Score implements Parcelable, IDrawable {
    // private CountDownTimer score;
    private int score;
    // private long timeLeftInMilliseconds;
    private String scoreText;
    // private boolean isActive;
    // private int seconds;

    public Score(int currScore) {
        score = currScore;
    }

    public Score() {
        this(0);
    }

    protected Score(Parcel in) {
        score = in.readInt();
    }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(score);
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

    @Override
    public void draw(Canvas canvas, Resources resources) {
        Paint paint = new Paint();
        paint.setTextSize(50);
        canvas.drawText("Score: " + score, 1500, 1000, paint);
    }
    /*

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

    public String timeLeftText() {

        return timeLeftText;
    }

    public long timeLeft() {
        return timeLeftInMilliseconds;
    }

    public boolean getActive() {
        return isActive;
    }
    public void setActive(boolean active) {

        isActive = active;
    }
    public void setScore(long timeLeftInMilliseconds) {
        this.timeLeftInMilliseconds = timeLeftInMilliseconds;
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
     */
}
