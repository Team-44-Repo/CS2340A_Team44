package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.os.Parcel;

import androidx.annotation.NonNull;

import com.example.cs2340a.R;

public class EasyEnemyFactory extends EnemyFactory {

    public Enemy spawnBat(Resources res) {
        Enemy enemy;
        enemy = new Bat(res, R.drawable.bat, 10, 5);
        return enemy;
    }
    public Enemy spawnGhost(Resources res) {
        Enemy enemy;
        enemy = new Ghost(res, R.drawable.ghost, 10, 5);
        return enemy;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

    }

    public static final Creator<EasyEnemyFactory> CREATOR = new Creator<EasyEnemyFactory>() {
        @Override
        public EasyEnemyFactory createFromParcel(Parcel in) {
            return new EasyEnemyFactory();
        }

        @Override
        public EasyEnemyFactory[] newArray(int size) {
            return new EasyEnemyFactory[size];
        }
    };

    // do it by difficulty
    // could then implement difficulty interface
    // use those details to inform decisions in that difficulty
    // what difficulty
    // method spawn enemy
    // if its made in this hard difficulty it would do this
    // amount of damage to health points
    // player and enemy implement difficulty
    // decouples things rather than being an attribute of player


    // game loop class that has update draw run sleep implements runnable
    // that's what we instantiate in game room model
}