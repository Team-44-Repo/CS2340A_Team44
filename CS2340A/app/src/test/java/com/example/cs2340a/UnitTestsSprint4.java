package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import com.example.cs2340a.dungenCrawler.model.DifficultyEnum;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.model.PlayerMovement;
import com.example.cs2340a.dungenCrawler.model.PlayerPosition;
import com.example.cs2340a.dungenCrawler.model.Vampire;
import com.example.cs2340a.dungenCrawler.view.PositionObserver;
import com.example.cs2340a.dungenCrawler.viewModel.LeaderboardViewModel;
import com.example.cs2340a.dungenCrawler.viewModel.GameLoop;

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

    @Test //Clare Cotter
    public void addObserver() {
        class item implements PositionObserver {
            String name;
            int count;
            public item(String name) {
                this.name = name;
            }
            public void onPositionChanged(int x, int y) {
                count++;
            }
        }
        PlayerPosition position = new PlayerPosition();
        item i = new item("item1");
        position.addObserver(i);
        position.notifyObservers();
        assertEquals(1, i.count);
    }

    @Test //Clare Cotter
    public void removeObserver() {
        class item implements PositionObserver {
            String name;
            int count;
            public item(String name) {
                this.name = name;
            }
            public void onPositionChanged(int x, int y) {
                count++;
            }
        }
        PlayerPosition position = new PlayerPosition();
        item i = new item("item1");
        position.addObserver(i);
        position.removeObserver(i);
        position.notifyObservers();
        assertEquals(0, i.count);
    }

    @Test //Angela Chang
    public void gameWon() {
        boolean result = GameLoop.won();
        assertTrue("Game should be won.", result);
    }

    @Test //Angela Chang
    public void gameLost() {
        boolean result = GameLoop.lost();
        assertTrue("Game should be lost.", result);
    }

    @Test //Catherine Trobradovic
    public void setCharacter2() {
        GameConfig.setAvatar(2);
        assertEquals(2, GameConfig.getAvatar());
    }

    @Test //Catherine Trobradovic
    public void setCharacter3() {
        GameConfig.setAvatar(3);
        assertEquals(3, GameConfig.getAvatar());
    }

}
