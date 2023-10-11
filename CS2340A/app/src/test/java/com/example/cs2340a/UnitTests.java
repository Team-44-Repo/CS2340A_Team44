package com.example.cs2340a;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a.dungenCrawler.model.GameConfig;

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
        GameConfig gConfig = new GameConfig("null", null, 2, 0);
        assertEquals(2, gConfig.getAvatar(), 0);
    }

    @Test // Angela Chang
    public void avatar3Selected() {
        GameConfig gConfig = new GameConfig("null", null, 3, 0);
        assertEquals(3, gConfig.getAvatar(), 0);
    }

    @Test // Angela Chang
    public void checkValidCurrRoomId() {
        GameConfig gConfig = new GameConfig("null", null, null, 1);
        assertEquals(1, gConfig.getCurrRoomId(), 0);
    }
}
