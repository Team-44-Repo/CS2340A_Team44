package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.cs2340a.dungenCrawler.model.DifficultyEnum;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.HeartPower;
import com.example.cs2340a.dungenCrawler.model.PowerUp;

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

    @Test       //Clare Cotter
    public void addPowerUp() {
        PowerUp power = new PowerUp();
        GameConfig.setPowerUp(power);
        assertNotNull(GameConfig.getPowerUp());
    }

    @Test       //Clare Cotter
    public void activePowerUp() {
        PowerUp power = new PowerUp();
        power.setActive(true);
        GameConfig.setPowerUp(power);
        assertEquals(true, power.isActive());
    }
}
