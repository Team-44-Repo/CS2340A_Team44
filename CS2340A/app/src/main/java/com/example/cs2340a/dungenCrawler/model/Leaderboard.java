package com.example.cs2340a.dungenCrawler.model;
import java.util.ArrayList;

public class Leaderboard {
    //singleton class with getters and setters
    private String[] names;
    private int[] scores;

    private static Leaderboard instance;

    private Leaderboard(String[] names, int[] scores) {
        if (names == null) {
            this.names = new String[5];
        }
        //if scores array is null, make every score 0 since int can't be null
        if (scores == null) {
            this.scores = new int[5];
            for (int i = 0; i < 5; i ++) {
                scores[i] = 0;
            }
        } else {
            this.names = names;
            this.scores = scores;
        }
    }
    private Leaderboard() {
        this(null, null);
    }

    //one instance of leaderboard
    public static synchronized Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

    //getters and setters
    public String[] getNames() {
        return names;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScore(int score, int index) {
        scores[index] = score;
    }

    public void setName(String name, int index) {
        names[index] = name;
    }
}
