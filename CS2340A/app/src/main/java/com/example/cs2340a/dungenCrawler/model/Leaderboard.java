package com.example.cs2340a.dungenCrawler.model;
import java.util.Arrays;

public class Leaderboard {
    //singleton class with getters and setters
    private static String[] names = new String[6];
    private static int[] scores = new int[6];

    private static Leaderboard instance;

    private Leaderboard(String[] names, int[] scores) {
        if (names == null) {
            this.names = new String[5];
            for (int i = 0; i < 5; i++) {
                names[i] = "XXXX";
            }
        }
        //if scores array is null, make every score 0 since int can't be null
        if (scores == null) {
            this.scores = new int[5];
            for (int i = 0; i < 5; i++) {
                scores[i] = 0;
            }
        } else {
            this.names = names;
            this.scores = scores;
        }
    }
//    private Leaderboard() {
//        this(null, null);
//    }

    //one instance of leaderboard
    public static synchronized Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard(names, scores);
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

    public void setScore(int score, int index) { scores[index] = score; }

    public void setName(String name, int index) {
        names[index] = name;
    }
    public void addScores(int score, String name) {
        for (int i = 0; i < 5; i++) {
            if (scores[i] == 0) {
                scores[i] = score;
                names[i] = name;
                break;
            } else if (scores[i] > score) {
                continue;
            } else if (scores[i] < score) {
                if (scores[i + 1] == 0) {
                    scores[i + 1] = scores[i];
                    names[i + 1] = names[i];
                    scores[i] = score;
                    names[i] = name;
                    break;
                } else {
                    int count = i;
                    scores[5] = score;
                    int placeholder;
                    String placeholderName;
                    while (count + 1 <= 5) {
                        System.out.println("Starting while loop...");
                        if (scores[count] < scores[count + 1]) {
                            placeholder = scores[count];
                            placeholderName = names[count];
                            scores[count] = scores[count + 1];
                            names[count] = names[count + 1];
                            scores[count + 1] = placeholder;
                            names[count + 1] = placeholderName;
                            count++;
                        } else {
                            count++;
                        }
                    }
//                    names[count] = name;
                    break;
                }
            }
        }
        //        if ((scores[index] != 0) {
//            int placeholder;
//            int placeholder2;
//            for (int i = index + 1; i < 5; i++) {
//                if (scores[i] != 0 && scores[i] != placeholder) {
//                    placeholder = scores[i];
//                    if (scores[i + 1] != 0) {
//                        placeholder2 = scores[i + 1];
//                        scores[i + 1] = placeholder;
//                    }
//                }
//            }
//        } else {
//            scores[index] = score;
//        }
//        if (scores[index] != 0) {
//            scores[6] = score;
//            System.out.println("Unsorted: " + scores);
//            Arrays.sort(scores);
//            System.out.println("Sorted: " + scores);
//        } else {
//            scores[index] = score;
//        }
    }
}
