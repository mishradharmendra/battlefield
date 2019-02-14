package com.game.battlefield.game.player;

import static com.game.battlefield.game.GameConstant.*;

/**
 * This is model class for Enemy. Currently there is limited enemy added one can add mor enemies.
 */
public class Enemy {

    private int health;
    private String name;

    public Enemy() {
        name = ENEMY_NAMES[RANDOM.nextInt(ENEMY_NAMES.length)];
        health = RANDOM.nextInt(MAXIMUM_HEALTH);
    }

    /**
     * Returns the damage dealt by this enemy.
     *
     * @return the damage dealt by this enemy
     */
    public int attack() {
        return RANDOM.nextInt(ENEMY_MAXIMUM_ATTACK_DAMAGE);
    }

    /**
     * Reduces the HP of this enemy by a specifed value.
     *
     * @param damage the amount to reduce the
     */
    public void takeDamage(int damage) {
        health = health - damage;
    }

    /**
     * The name of this enemy.
     *
     * @return the name of the enemy
     */
    public String name() {
        return name;
    }

    /**
     * Returns the health of this enemy.
     *
     * @return heatlh of this enemy
     */
    public int health() {
        return health;
    }
}
