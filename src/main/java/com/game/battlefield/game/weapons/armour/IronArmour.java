package com.game.battlefield.game.weapons.armour;

public class IronArmour extends Armour {

    public static final int IRON_HITPOINTS = 10;
    public static final int IRON_DAMAGE_BLOCKED = 5;

    /**
     * Constructs armour for a player.
     *
     * @param type the type of this armour
     */
    public IronArmour(String type) {
        super(type + " armour", IRON_HITPOINTS, IRON_DAMAGE_BLOCKED);
    }
}
