package com.game.battlefield.game.weapons.armour;

/**
 * Class containing the information related to Armour.
 * 3 Types of Armour is being created, Leather, Iron and GOLD and they have
 * their respective damages
 */
public class Armour {

    private String name;
    private int hitpoints;
    private int damageBlocked;


    /**
     * Constructs armour for a player.
     * @param name
     * @param hitpoints
     * @param damageBlocked
     */
    public Armour(String name, int hitpoints, int damageBlocked) {
        this.name = name;
        this.hitpoints = hitpoints;
        this.damageBlocked = damageBlocked;
    }
    /**
     * Returns the damageBlocked of this armour.
     *
     * @return damageBlocked
     */
    public int damageBlocked() {
        return damageBlocked;
    }

    /**
     * Returns the hitpoints left on this armour
     *
     * @return hitpoints
     */
    public int hitpoints() {
        return hitpoints;
    }

    /**
     * Returns the name of this armour.
     *
     * @return name
     */
    public String name() {
        return name;
    }

    /**
     * Changes the name of this armour to the specified name.
     *
     * @param name the name of this armour
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Uses this armour when attacking an enemy, reduces hitpoints.
     */
    public void useArmour() {
        hitpoints--;
    }
}
