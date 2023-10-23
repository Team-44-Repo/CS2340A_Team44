package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import android.graphics.Bitmap;

import com.example.cs2340a.dungenCrawler.model.CharSprite;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.model.PlayerMovement;
import com.example.cs2340a.dungenCrawler.model.Room;
import com.example.cs2340a.dungenCrawler.model.Score;
import com.example.cs2340a.dungenCrawler.viewModel.GameRoom1ViewModel;
import com.example.cs2340a.dungenCrawler.viewModel.GameRoom2ViewModel;
import com.example.cs2340a.dungenCrawler.viewModel.GameRoom3ViewModel;
import android.graphics.BitmapFactory;

import org.junit.Test;

public class UnitTests {
    /*
    To find the API and commands to use for JUnit, use this link:
    https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html#assertEquals(double,%20double,%20double)
    * */
    @Test // Elizabeth Grace Tuggle
    public void difficultyEasySelected() {
        GameConfig gConfig = new GameConfig("null", 1.0, null, 0);
        assertEquals(1.0, gConfig.getDifficulty(), 0);
    }
    @Test // Elizabeth Grace Tuggle
    public void difficultyMediumSelected() {
        GameConfig gConfig = new GameConfig("null", 0.75, null, 0);
        assertEquals(0.75, gConfig.getDifficulty(), 0);
    }

    @Test //Angela Chang
    public void roomCreated2() {
        Room testRoom = new Room("room2", 10, 0, 0, 10, 0,
                10);
        assertNotNull(testRoom);
    }

    @Test //Angela Chang
    public void roomCreated3() {
        Room testRoom = new Room("room3", 0, 10, 10, 0, 0, 10);
        assertNotNull(testRoom);
    }

    @Test // Daysen Gyatt
    public void roomCreated() {
        Room testRoom = new Room("room1", 0, 10, 0, 10, 0, 10);
        assertNotNull(testRoom);
    }

    @Test // Daysen Gyatt
    public void doorwayAssigned() {
        Room testRoom = new Room("room1", 0, 10, 0, 10, 0, 10);
        assertEquals(testRoom.getDoorwayLeftX(), 0);
    }

    @Test //Elizabeth Grace Tuggle
    public void roomCreated4() {
        Room testRoom = new Room("room4", 0, 10, 0, 10, 10, 0);
        assertNotNull(testRoom);
    }

    @Test //Elizabeth Grace Tuggle
    public void roomCreated5() {
        Room testRoom = new Room("room5", 10, 10, 0, 10, 0, 10);
        assertNotNull(testRoom);
    }

    @Test //Catherine Trobradovic
    public void playerCreated2() {
        CharSprite sprite = new CharSprite(R.drawable.player2, "char1");
        Player playerTest = new Player("name", sprite, 2,0.5,100);
        assertNotNull(playerTest);
    }

    @Test //Catherine Trobradovic
    public void doorwayAssigned4() {
        Room testRoom = new Room("room1", 0, 10, 0, 10, 10,
                10);
        assertEquals(testRoom.getDoorwayTopY(), 0);
    }

    @Test //Olivia Klemmer
    public void doorwayAssigned2() {
        Room testRoom = new Room("room1", 0, 10, 10, 0, 10,
                00);
        assertEquals(testRoom.getDoorwayBottomY(), 0);
    }

    @Test //Olivia Klemmer
    public void doorwayAssigned3() {
        Room testRoom = new Room("room1", 0, 10, 0, 10, 10,
                00);
        assertEquals(testRoom.getDoorwayRightX(), 0);
    }

    @Test //Clare Cotter
    public void playerCreated3() {
        CharSprite sprite = new CharSprite(R.drawable.player3, "char1");
        Player playerTest = new Player("name", sprite, 2,0.5,100);
        assertNotNull(playerTest);
    }

    @Test //ClareCotter
    public void GamConfigCreated2() {
        CharSprite sprite = new CharSprite(R.drawable.player2, "char1");
        GameConfig gameConfigTest = new GameConfig("name", 0.5, sprite, 2);
        assertNotNull(gameConfigTest);
    }
}
