package com.example.cs2340a;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a.dungenCrawler.model.DifficultyEnum;
import com.example.cs2340a.dungenCrawler.model.GameConfig;

import org.junit.Test;

public class UnitTestSprint5 {
    @Test
    public void setDifficultyEasy() { // Elizabeth Grace Tuggle
        GameConfig.setDifficulty(DifficultyEnum.EASY);
        assertEquals(DifficultyEnum.EASY, GameConfig.getDifficulty());
    }

    @Test
    public void setDifficultyMedium() { // Elizabeth Grace Tuggle
        GameConfig.setDifficulty(DifficultyEnum.MEDIUM);
        assertEquals(DifficultyEnum.MEDIUM, GameConfig.getDifficulty());
    }
}
