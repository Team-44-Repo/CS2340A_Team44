package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import com.example.cs2340a.dungenCrawler.model.DifficultyEnum;
import com.example.cs2340a.dungenCrawler.model.EasyEnemyFactory;
import com.example.cs2340a.dungenCrawler.model.EnemyFactory;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.MediumEnemyFactory;
import com.example.cs2340a.dungenCrawler.model.HeartPower;
import com.example.cs2340a.dungenCrawler.model.PowerUp;
import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.SpeedPower;

import android.content.res.Resources;

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

    @Test //Angela Chang
    public void applyEffectPowerUp() {
        PowerUp power = new PowerUp();
        GameConfig.setPowerUp(power);
        assertEquals(1, power.applyEffect());
    }

    @Test
    public void setDifficultyHard() { // Angela Chang
        GameConfig.setDifficulty(DifficultyEnum.HARD);
        assertEquals(DifficultyEnum.HARD, GameConfig.getDifficulty());
    }

    // Daysen Gyatt
    @Test
    public void createEnemyFactory() {
        GameConfig.setDifficulty(DifficultyEnum.EASY);
        assertNotNull(GameConfig.getFactory());
    }

    // Daysen Gyatt
    @Test
    public void testDiffFactories() {
        GameConfig.setDifficulty(DifficultyEnum.HARD);
        EnemyFactory testFactory = new EasyEnemyFactory();
        assertNotSame(testFactory, GameConfig.getFactory());
    }

    @Test //Catherine Trobradovic
    public void testEasyFactory() {
        GameConfig.setDifficulty(DifficultyEnum.EASY);
        EnemyFactory testFactory = new EasyEnemyFactory();
        assertNotSame(testFactory, GameConfig.getFactory());
    }

    @Test //Catherine Trobradovic
    public void testMediumFactory() {
        GameConfig.setDifficulty(DifficultyEnum.MEDIUM);
        EnemyFactory testFactory = new MediumEnemyFactory();
        assertNotSame(testFactory, GameConfig.getFactory());
    }

    @Test // Olivia Klemmer
    public void setAvatar1() {
        GameConfig.setAvatar(1);
        assertEquals(1, GameConfig.getAvatar());
    }

    @Test // Olivia Klemmer
    public void setAvatar2() {
        GameConfig.setAvatar(2);
        assertEquals(2, GameConfig.getAvatar());
    }
}
