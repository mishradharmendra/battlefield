package com.game.battlefield.game.weapons.armour;

public class LeatherArmour extends Armour {

    private static final int LEATHER_HITPOINTS = 5;
    private static final int LEATHER_DAMGAGE_BLOCKED = 2;

    /**
     * Constructs armour for a player.
     *
     * @param type the type of this armour
     */
    public LeatherArmour(String type) {
        super(type + " armour", LEATHER_HITPOINTS, LEATHER_DAMGAGE_BLOCKED);
    }
}
