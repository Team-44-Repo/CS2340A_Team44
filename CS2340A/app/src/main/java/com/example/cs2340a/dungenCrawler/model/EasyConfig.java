package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class EasyConfig extends GameConfig {
    /*
    Contains all game info specific to a game played on the EASY difficulty.
     */
    private EnemyFactory factory;
    // private Enemy[] enemies;
    private Enemy enemy1;
    private Enemy enemy2;
    private int numEnemies;
    public EasyConfig(Player player, Room room, Resources res) {
        super(player, room, res);
        System.out.println("EasyConfig formed!");
        this.factory = new EasyEnemyFactory();

        this.numEnemies = 2;
        //this.enemy1 = factory.launchEnemy(player, room.getRoomID(), res);
        this.enemy1 = factory.spawnBat(res);
        System.out.println("enemy1: " + enemy1);
        this.enemy2 = factory.spawnGhost(res);
        System.out.println("enemy2: " + enemy2);
    }

    public EnemyFactory getFactory() {
        return factory;
    }

    public void drawEnemies(Canvas canvas, Resources resources) {
        System.out.println("Drawing enemies!");
        enemy1.draw(canvas, resources);
        enemy2.draw(canvas, resources);
    }

    @Override
    public void updateEnemies(Resources res) {

        System.out.println("Enemy x: " + enemy1.getX());
        if (enemy1.getX() != getPlayer().getX() && enemy1.getY() != getPlayer().getY()) {
            if (enemy1.getX() < getPlayer().getX()) {
                System.out.println("Enemy speed: " + enemy1.getSpeed());
                enemy1.setX(enemy1.getX() + enemy1.getSpeed());
            }
        }

        // Room Checks
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

    protected EasyConfig(Parcel in) {
        super(in);
        factory = in.readParcelable(EnemyFactory.class.getClassLoader());
        enemy1 = in.readParcelable(Enemy.class.getClassLoader());
        enemy2 = in.readParcelable(Enemy.class.getClassLoader());
        numEnemies = in.readInt();
    }

    public static final Creator<EasyConfig> CREATOR = new Creator<EasyConfig>() {
        @Override
        public EasyConfig createFromParcel(Parcel in) {
            return new EasyConfig(in);
        }

        @Override
        public EasyConfig[] newArray(int size) {
            return new EasyConfig[size];
        }
    };
}
