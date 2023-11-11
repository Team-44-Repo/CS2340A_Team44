package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.cs2340a.dungenCrawler.model.DifficultyEnum;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.viewModel.LeaderboardViewModel;

import org.junit.Test;
public class UnitTestsSprint4 {

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

    @Test
    public void setDifficultyHard() { // Olivia Klemmer
        GameConfig.setDifficulty(DifficultyEnum.HARD);
        assertEquals(DifficultyEnum.HARD, GameConfig.getDifficulty());
    }

    @Test
    public void setCharacter1() {
        GameConfig.setAvatar(1);
        assertEquals(1, GameConfig.getAvatar());
    }
}
