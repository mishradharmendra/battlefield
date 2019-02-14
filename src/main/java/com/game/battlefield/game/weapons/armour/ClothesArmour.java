package com.game.battlefield.game.weapons.armour;

public class ClothesArmour extends Armour {

    private static final int CLOTHES_HITPOINTS = 0;
    private static final int CLOTHES_DAMAGE_BLOCKED = 0;


    /**
     * Constructs armour for a player.
     *
     * @param type the type of this armour
     */
    public ClothesArmour(String type) {
        super(type + " armour", CLOTHES_HITPOINTS, CLOTHES_DAMAGE_BLOCKED);
    }
}
