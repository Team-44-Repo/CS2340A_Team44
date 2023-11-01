package com.example.cs2340a.dungenCrawler.model;

public class HardEnemyFactory extends EnemyFactory {
    @Override
    public Enemy spawnEnemy() {
        //return new HardVampire?
        return new Zombie();
    }
    // do it by difficulty
    // could then implement difficulty interface
    // use those details to inform decisions in that difficulty
    // what difficulty
    // method spawn enemy
    // if its made in this hard difficulty it would do this
    // amount of damage to health points
    // player and enemy implement difficulty
    // decouples things rather than being an attribute of player


    // game loop class that has update drwa run sleep implements runnable
    // thats what we instantiate in game room model
}