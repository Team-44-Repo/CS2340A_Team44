package com.example.cs2340a;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a.dungenCrawler.model.GameConfig;
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

    @Test
    //Clare Cotter
    public void storeHighScore () {
        LeaderboardViewModel leaderboard = new LeaderboardViewModel();
        leaderboard.addScores("clare", 15);
        assertEquals(15, leaderboard.leaderboard.getScores()[0]);
    }
}
