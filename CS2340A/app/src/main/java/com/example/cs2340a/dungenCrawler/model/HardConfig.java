package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Parcel;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class HardConfig extends GameConfig {

    /*
    Contains all game info specific to a game played on the HARD difficulty.
     */

    //Attributes -----------------------------------------------------------
    private HardEnemyFactory factory;
    private Enemy enemy1;
    private Enemy enemy2;
    private Resources res;
    private int numEnemies;

    // List of current Enemy Observers
    private ArrayList<Enemy> observerList = new ArrayList<Enemy>();

    //Constructor -----------------------------------------------------------
    public HardConfig(Player player, Room room, Resources res) {
        super(player, room, res);
        this.res = res;

        System.out.println("HardConfig formed!");
        this.factory = new HardEnemyFactory();
        this.numEnemies = 2;

        //for room 1, set the 2 enemies to enemy 1 and 2
        enemy1 = factory.spawnBat(res);
        enemy2 = factory.spawnGhost(res);
        observerList.add(enemy1);
        observerList.add(enemy2);
        //for other rooms, enemies are set in switchEnemies
    }

    //Methods -----------------------------------------------------------

    //Observable methods
    @Override
    public void addObserver(Enemy enemy) {
        observerList.add(enemy);
    }
    @Override
    public void removeObserver(Enemy enemy) {
        observerList.remove(enemy);
    }
    @Override
    public void clearObservers() {
        for (Enemy observer : observerList) {
            removeObserver(observer);
        }
    }
    @Override
    public void notifyObservers() {
        for (Enemy observer : observerList) {
            observer.update(getPlayer());
        }
        enemy1.update(getPlayer());
        enemy2.update(getPlayer());
    }
    @Override
    public String difType() {
        return "Hard";
    }


    //Other Methods
    @Override
    public void switchEnemies(int roomID) {
        clearObservers();
        switch (roomID) {
        case 1:
            //sets room 2 enemies
            enemy1 = factory.spawnZombie(res);
            enemy2 = factory.spawnVampire(res);
            break;
        case 2:
            //sets room 3 enemies
            enemy1 = factory.spawnGhost(res);
            enemy2 = factory.spawnVampire(res);
            break;
        default:
            enemy1 = factory.spawnBat(res);
            enemy2 = factory.spawnGhost(res);
        }
        addObserver(enemy1);
        addObserver(enemy2);
    }
    @Override
    public void drawEnemies(Canvas canvas, Resources resources) {
        System.out.println("Drawing enemies!");
        enemy1.draw(canvas, resources);
        enemy2.draw(canvas, resources);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    //getters and setters -----------------------------------------------------------
    public EnemyFactory getFactory() {
        return factory;
    }

    //Other stuff
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
    public void switchRoom(int roomID) {

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
