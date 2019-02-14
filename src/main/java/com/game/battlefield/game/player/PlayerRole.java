package com.game.battlefield.game.player;

public enum PlayerRole {

    FIGHTER("Fighter"),
    RANGER("Ranger"),
    ARCANIST("Arcanist"),
    WARRIOR("Warrior");

    private String playerRole;

    PlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }
}
