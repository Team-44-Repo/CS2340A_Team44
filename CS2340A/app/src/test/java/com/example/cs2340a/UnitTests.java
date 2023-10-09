package com.example.cs2340a;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a.dungenCrawler.model.GameConfig;

import org.junit.Test;

public class UnitTests {
    @Test
    public void difficultyEasySelected() {
        GameConfig gConfig = new GameConfig("null", 1.0, null, 0);
        assertEquals(1.0, gConfig.getDifficulty(), 0);
    }
    @Test
    public void difficultyMediumSelected() {
        GameConfig gConfig = new GameConfig("null", 0.75, null, 0);
        assertEquals(0.75, gConfig.getDifficulty(), 0);
    }
}
