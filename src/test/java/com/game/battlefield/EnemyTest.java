package com.game.battlefield;

import com.game.battlefield.game.player.Enemy;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyTest {

    Enemy enemy = new Enemy();

    @Test
    public void enemyHealthTest() {
        int health = enemy.health();
        System.out.println("Enemy health before damage :: "+ health);

        enemy.takeDamage(20);
        System.out.println("Player health after attack::" + enemy.health());
        assertEquals(enemy.health(), (health - 20));
    }
}
