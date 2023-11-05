package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class MediumConfig extends GameConfig {
    /*
    Contains all game info specific to a game played on the MEDIUM difficulty.
     */
    private EnemyFactory factory;
    private Enemy enemy1;
    private Enemy enemy2;
    private int numEnemies;
    public MediumConfig(Player player, Room room, Resources res) {
        super(player, room, res);
        System.out.println("MediumConfig formed!");
        this.factory = new MediumEnemyFactory();

        this.numEnemies = 2;
        this.enemy1 = factory.spawnVampire(res);
        System.out.println("enemy1: " + enemy1);
        this.enemy2 = factory.spawnZombie(res);
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

    protected MediumConfig(Parcel in) {
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
    public void updateEnemies(Resources res) {
        if (getCurrRoom().getRoomID() == 1) {
            this.enemy1 = factory.spawnBat(res);
            this.enemy2 = factory.spawnGhost(res);
        } else if (getCurrRoom().getRoomID() == 2) {
            this.enemy1 = factory.spawnZombie(res);
            this.enemy2 = factory.spawnVampire(res);
        } else if (getCurrRoom().getRoomID() == 3) {
            this.enemy1 = factory.spawnGhost(res);
            this.enemy2 = factory.spawnVampire(res);
        }
    }

    public static final Creator<MediumConfig> CREATOR = new Creator<MediumConfig>() {
        @Override
        public MediumConfig createFromParcel(Parcel in) {
            return new MediumConfig(in);
        }

        @Override
        public MediumConfig[] newArray(int size) {
            return new MediumConfig[size];
        }
    };
}
