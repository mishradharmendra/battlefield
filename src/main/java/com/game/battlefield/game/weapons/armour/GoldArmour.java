package com.game.battlefield.game.weapons.armour;

public class GoldArmour extends Armour {

    private static final int GOLD_HITPOINTS = 20;
    private static final int GOLD_DAMAGE_BLOCKED = 10;


    /**
     * Constructs armour for a player.
     *
     * @param type the type of this armour
     */
    public GoldArmour(String type) {
        super(type + " armour", GOLD_HITPOINTS, GOLD_DAMAGE_BLOCKED);
    }
}
