package com.game.battlefield.game;

/**
 * Enum containing the Game Options
 */
public enum GameOptions {

    ATTACK(1),
    USEPOTION(2),
    RUN(3),
    VISITSTORE(4),
    EXIT(5);

    private int option;
    GameOptions(int option) {
        this.option = option;
    }
}
