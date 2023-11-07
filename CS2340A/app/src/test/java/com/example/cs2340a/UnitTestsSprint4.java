package com.example.cs2340a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.cs2340a.dungenCrawler.model.Player;
import com.example.cs2340a.dungenCrawler.viewModel.LeaderboardViewModel;

import org.junit.Test;
public class UnitTestsSprint4 {
    @Test
    public void changeEndScreenText() {
        Player playerTest = new Player("name", 1, 2,2, null,100);
        playerTest.setHealthPoints(0);
        assertEquals("GAME OVER", LeaderboardViewModel.getWinLoseText());
    }
}
