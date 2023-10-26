public abstract class EnemyFactory {
    public Enemy launchEnemy() {
        Enemy enemy = spawnEnemy();
        enemy.attack();
        return enemy;
    }

    public abstract Enemy spawnEnemy();
}