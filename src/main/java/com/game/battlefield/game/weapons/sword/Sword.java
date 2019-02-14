package com.game.battlefield.game.weapons.sword;

public class Sword {

    private int damageIncrease;
    private int hitpoints;
    private String name;


    /**
     * Constructs a sword with the specified characteristics
     * @param name
     * @param damageIncrease
     * @param hitpoints
     */
    public Sword(String name, int damageIncrease, int hitpoints) {
        this.name = name;
        this.damageIncrease = damageIncrease;
        this.hitpoints = hitpoints;
    }

    /**
     * Returns the name of this sword.
     *
     * @return name
     */
    public String name()
    {
        return name;
    } // end of method name()

    /**
     * Returns the hitpoints of this sword.
     *
     * @return hitpoints
     */
    public int hitpoints()
    {
        return hitpoints;
    } // end of method hitpoints()

    /**
     * Returns the damageIncrease of this sword.
     *
     * @return damageIncrease
     */
    public int damageIncrease()
    {
        return damageIncrease;
    } // end of method damageIncrease()

    /**
     * Changes the name of this sword to the specified name.
     *
     * @param name the name of this sword
     */
    public void setName(String name)
    {
        this.name = name;
    } // end of method setName(String name)

    /**
     * Uses this sword when attacking an enemy, reduces hitpoints.
     */
    public void useSword()
    {
        hitpoints--;
    } // end of method useSword()
}
