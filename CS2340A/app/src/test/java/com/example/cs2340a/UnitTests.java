package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import android.content.Context;
import android.graphics.Point;

import com.example.cs2340a.dungenCrawler.model.CharSprite;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.model.Room;
import com.example.cs2340a.dungenCrawler.model.Score;
import com.example.cs2340a.dungenCrawler.view.GameView;
import com.example.cs2340a.dungenCrawler.viewModel.GameRoom1ViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Ordering;
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


    @Test // Angela Chang
    public void avatar2Selected() {
        CharSprite avatar = new CharSprite(2, "null");
        GameConfig gConfig = new GameConfig("null", 1.0, avatar, 0);
        assertEquals(2, gConfig.getAvatar().getSpriteResId(), 0);
    }

    @Test // Angela Chang
    public void avatar3Selected() {
        CharSprite avatar = new CharSprite(3, "null");
        GameConfig gConfig = new GameConfig("null", 1.0, avatar, 0);
        assertEquals(3, gConfig.getAvatar().getSpriteResId(), 0);
    }

    @Test // Angela Chang
    public void checkValidCurrRoomId() {
        GameConfig gConfig = new GameConfig("null", 1.0, null, 1);
        assertEquals(1, gConfig.getCurrRoomId(), 0);
    }

    @Test // Olivia Klemmer
    public void difficultyHardSelected() {
        CharSprite avatar = new CharSprite(1, "luna");
        GameConfig gConfig = new GameConfig("null", 0.5, null, 0);
        assertEquals(0.5, gConfig.getDifficulty(), 0);
    }
    @Test // Olivia Klemmer
    public void avatar1Selected() {
        CharSprite avatar = new CharSprite(1, "null");
        GameConfig gConfig = new GameConfig("null", 1, avatar, 0);
        assertEquals(1, gConfig.getAvatar().getSpriteResId(), 0);
    }

    @Test // Clare Cotter
    public void timedScore() {
        Score score = new Score(400, false);
        assertEquals(null, score.timeLeft());
        assertNotNull(score);
    }
    @Test // Clare Cotter
    public void timedScore2() {
        Score score = new Score(400, false);
        assertEquals(false, score.getActive());
        assertNotNull(score);
    }

    @Test // Daysen Gyatt
    public void playerCreated() {
        CharSprite sprite = new CharSprite(R.drawable.player1, "char1");
        Player playerTest = new Player("name", sprite, 2,0.5,100);
        assertNotNull(playerTest);
    }
    @Test // Daysen Gyatt
    public void GamConfigCreated() {
        CharSprite sprite = new CharSprite(R.drawable.player1, "char1");
        GameConfig gameConfigTest = new GameConfig("name", 0.5, sprite, 2);
        assertNotNull(gameConfigTest);
    }

    @Test //Catherine Trobradovic
    public void checkValidCurrRoom2Id() {
        GameConfig gConfig = new GameConfig("null", 1.0, null, 2);
        assertEquals(2, gConfig.getCurrRoomId(), 0);
    }
    @Test //Catherine Trobradovic
    public void checkValidCurrRoom3Id() {
        GameConfig gConfig = new GameConfig("null", 1.0, null, 3);
        assertEquals(3, gConfig.getCurrRoomId(), 0);
    }

    @Test //Angela Chang
    public void roomCreated2() {
        Room testRoom = new Room("room2", 10, 0, 0, 10, 0,
                10);
        assertNotNull(testRoom);
    }

    @Test //Angela Chang
    public void roomCreated3() {
        Room testRoom = new Room("room3", 0, 10, 10, 0, 0,
                10);
        assertNotNull(testRoom);
    }

    @Test // Daysen Gyatt
    public void roomCreated() {
        Room testRoom = new Room("room1", 0, 10, 0, 10, 0,
                10);
        assertNotNull(testRoom);
    }

    @Test // Daysen Gyatt
    public void doorwayAssigned() {
        Room testRoom = new Room("room1", 0, 10, 0, 10, 0,
                10);
        assertEquals(testRoom.getDoorwayLeftX(), 0);
    }

    @Test //Elizabeth Grace Tuggle
    public void roomCreated4() {
        Room testRoom = new Room("room4", 0, 10, 0, 10, 10,
                0);
        assertNotNull(testRoom);
    }

    @Test //Elizabeth Grace Tuggle
    public void roomCreated5() {
        Room testRoom = new Room("room5", 10, 10, 0, 10, 0,
                10);
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


