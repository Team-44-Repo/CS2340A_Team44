package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.graphics.Rect;

import com.example.cs2340a.dungenCrawler.model.Bat;
import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.model.PlayerMovement;
import com.example.cs2340a.dungenCrawler.model.PlayerPosition;
import com.example.cs2340a.dungenCrawler.model.Vampire;
import com.example.cs2340a.dungenCrawler.view.PositionObserver;
import com.example.cs2340a.dungenCrawler.viewModel.LeaderboardViewModel;

import org.junit.Test;
public class UnitTestsSprint4 {
    /*

    //these used BITMAP so they did not work
    //DONT USE BITMAP

    @Test
    public void createBat() {
        Bat bat = new Bat(null, 1, 5, 10);
        assertEquals(5, bat.getSpeed());
        assertEquals(500, bat.getX());
        assertEquals(500, bat.getY());
    }

    @Test
    public void createVampire() {
        Vampire vampire = new Vampire(null, 1, 3, 10);
        assertEquals(3, vampire.getSpeed());
        assertEquals(new Rect(500, 500 - 30, 500 + 74 + 50, 500 + 74 + 50), vampire.getCollisionShape());
    }

     */
    @Test //Clare Cotter
    public void addObserver() {
        class item implements PositionObserver {
            String name;
            int count;
            public item(String name) {
                this.name = name;
            }
            public void onPositionChanged(int x, int y) {
                count++;
            }
        }
        PlayerPosition position = new PlayerPosition();
        item i = new item("item1");
        position.addObserver(i);
        position.notifyObservers();
        assertEquals(1, i.count);
    }

    @Test //Clare Cotter
    public void removeObserver() {
        class item implements PositionObserver {
            String name;
            int count;
            public item(String name) {
                this.name = name;
            }
            public void onPositionChanged(int x, int y) {
                count++;
            }
        }
        PlayerPosition position = new PlayerPosition();
        item i = new item("item1");
        position.addObserver(i);
        position.removeObserver(i);
        position.notifyObservers();
        assertEquals(0, i.count);
    }

}
