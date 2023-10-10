package com.example.cs2340a.dungenCrawler.viewModel;
import androidx.lifecycle.ViewModel;

import com.example.cs2340a.dungenCrawler.model.Leaderboard;

public class LeaderboardViewModel extends ViewModel {
    //we're going to have to add the leaderboard to the activity_end.xml and endViewModel
    //right now it doesn't show up on the screen this is just the logic
    private Leaderboard leaderboard;

    //using leaderboard from Leaderboard class, but only getting the single instance
    public LeaderboardViewModel() {
        leaderboard = Leaderboard.getInstance();
    }
    //when the game ends, this method should be called to see if score should be set to leaderboard
    //takes in the name of the player and score they just received
    public void addScores(String name, int score) {
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (leaderboard.getScores()[i] < score) {
                for (int j = 4; j >= i; j--) {
                    leaderboard.setScore(leaderboard.getScores()[j], j + 1);
                    leaderboard.setName(leaderboard.getNames()[j], j + 1);
                }
                index = i;
            } else if (leaderboard.getScores()[i] == 0 && leaderboard.getNames()[i] == null) {
                index = i;
            }
        }
        leaderboard.setScore(score, index);
        leaderboard.setName(name, index);
    }
}
