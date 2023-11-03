package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class HardConfig extends GameConfig {

    /*
    Contains all game info specific to a game played on the HARD difficulty.
     */
    private HardEnemyFactory factory;
    private Enemy enemy1;
    private Enemy enemy2;
    private int numEnemies;

    public HardConfig(Player player, Room room, Resources res) {
        super(player, room, res);
        System.out.println("HardConfig formed!");
        this.factory = new HardEnemyFactory();

        this.numEnemies = 2;
        this.enemy1 = factory.spawnVampire(res);
        System.out.println("enemy1: " + enemy1);
        this.enemy2 = factory.spawnBat(res);
        System.out.println("enemy2: " + enemy2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(super.getPlayer(), flags);
        dest.writeParcelable(super.getCurrRoom(), flags);
        dest.writeParcelable(factory, flags);
        dest.writeParcelable(enemy1, flags);
        dest.writeParcelable(enemy2, flags);
        dest.writeInt(numEnemies);
    }

    protected HardConfig(Parcel in) {
        super(in);
        factory = in.readParcelable(EnemyFactory.class.getClassLoader());
        enemy1 = in.readParcelable(Enemy.class.getClassLoader());
        enemy2 = in.readParcelable(Enemy.class.getClassLoader());
        numEnemies = in.readInt();
    }

    @Override
    public EnemyFactory getFactory() {
        return factory;
    }

    @Override
    public void drawEnemies(Canvas canvas, Resources resources) {
        System.out.println("Drawing enemies!");
        enemy1.draw(canvas, resources);
        enemy2.draw(canvas, resources);
    }

    @Override
    public void updateEnemies() {

    }

    public static final Creator<HardConfig> CREATOR = new Creator<HardConfig>() {
        @Override
        public HardConfig createFromParcel(Parcel in) {
            return new HardConfig(in);
        }

        @Override
        public HardConfig[] newArray(int size) {
            return new HardConfig[size];
        }
    };
}
