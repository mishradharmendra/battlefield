package com.game.battlefield.game.weapons.sword;

public class MetalSword extends Sword {

    /** The hitpoints of a metal sword. */
    private static final int METAL_HITPOINTS = 15;

    /** The damage increase of a metal sword. */
    private static final int METAL_DAMAGE_INCREASE = 10;

    /**
     * Constructs a sword with the specified characteristics.
     *
     * @param type the type of this sword
     */
    public MetalSword(String type) {
        super(type + " sword", METAL_DAMAGE_INCREASE, METAL_HITPOINTS);
    }
}
