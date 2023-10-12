package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.cs2340a.dungenCrawler.model.CharSprite;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Player;


import com.example.cs2340a.dungenCrawler.viewModel.LeaderboardViewModel;


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

    @Test
    //Clare Cotter
    public void storeHighScore () {
        LeaderboardViewModel leaderboard = new LeaderboardViewModel();
        leaderboard.addScores("clare", 15);
        leaderboard.addScores("jake", 40);
        leaderboard.addScores("mia", 30);
        assertEquals(15, leaderboard.leaderboard.getScores()[0]);
        assertEquals(40, leaderboard.leaderboard.getScores()[0]);
        assertEquals(30, leaderboard.leaderboard.getScores()[1]);

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


}


