package com.game.battlefield.game;

import java.util.Random;

public interface GameConstant {

    //Player related Constant
    /** The default name given to a player. */
    String DEFAULT_NAME = "";

    /** The delayMessage used for display messages. */
    int MAXIMUM_GOLD_DROP = 30;

    /** The coin / health penalty for running away,  */
    int PENALTY_FOR_RUNNING = 5;

    /** Default number of potions of this player. */
    int DEFAULT_NUMBER_OF_POTIONS = 3;

    /** The delayMessage used for display messages to allow for readability. */
    long DELAY = 2000;

    /** Random number generator for this player. */
    Random RANDOM = new Random();

    /** The amount of HP one potion heals. */
    int POTION_HEALING = 30;

    /** Maximum health of this player. */
    int FULL_HEALTH = 100;

    /** The maximum attack damage of this player. */
    int MAXIMUM_ATTACK_DAMAGE = 25;


    //Enemy related Constants
    /** An array of possible enemy types. */
    String[] ENEMY_NAMES = { "Zombie", "Skeleton", "Werewolf", "Vampire" };

    /** The maximum attack damage of this enemy. */
    int ENEMY_MAXIMUM_ATTACK_DAMAGE = 20;

    /** The maximum health of this enemy. */
    int MAXIMUM_HEALTH = 75;
}
