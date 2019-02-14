package com.game.battlefield.game.weapons.sword;

public class WoodSword extends Sword {

    /** The hitpoints of a wood sword. */
    public static final int WOOD_HITPOINTS = 10;

    /** The damage increase of a wood sword. */
    public static final int WOOD_DAMAGE_INCREASE = 5;

    /**
     * Constructs a sword with the specified characteristics.
     *
     * @param type the type of this sword
     */
    public WoodSword(String type) {
        super(type + " sword", WOOD_DAMAGE_INCREASE, WOOD_HITPOINTS);
    }
}
