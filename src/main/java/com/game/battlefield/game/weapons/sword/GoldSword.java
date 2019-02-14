package com.game.battlefield.game.weapons.sword;

public class GoldSword extends Sword {

    /** The hitpoints of a gold sword. */
    private static final int GOLD_HITPOINTS = 20;

    /** The damage increase of a gold sword. */
    private static final int GOLD_DAMAGE_INCREASE = 15;

    /**
     * Constructs a sword with the specified characteristics.
     *
     * @param type the type of this sword
     */
    public GoldSword(String type) {
        super(type + " sword", GOLD_DAMAGE_INCREASE, GOLD_HITPOINTS);
    }
}
