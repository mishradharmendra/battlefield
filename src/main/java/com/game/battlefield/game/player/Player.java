package com.game.battlefield.game.player;

import com.game.battlefield.game.Bank;
import com.game.battlefield.game.weapons.armour.Armour;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import com.game.battlefield.game.weapons.armour.ArmourFactory;
import com.game.battlefield.game.weapons.sword.Sword;
import com.game.battlefield.game.weapons.sword.SwordEnum;
import com.game.battlefield.game.weapons.sword.SwordFactory;

import static com.game.battlefield.game.GameConstant.*;
import static com.game.battlefield.util.PrintUtil.delayMessage;
import static com.game.battlefield.util.PrintUtil.print;

/**
 * Player Entity class, contain all player details like coins, armour, sword etc
 */
public class Player {

    private Armour armour;
    private int enemiesKilled;
    private boolean hasSword;
    private boolean hasArmour;
    private int health;
    private Bank pouch;
    private String name;
    private int potionsRemaining;
    private Sword sword;
    private int age;
    private String gender;
    private String nickName;
    private PlayerRole role;

    /**
     * Constructs a new Player with initialising the variables
     */
    public Player()
    {
        name = DEFAULT_NAME;
        role = PlayerRole.WARRIOR;
        hasSword = false;
        hasArmour = false;
        health = FULL_HEALTH;
        potionsRemaining = DEFAULT_NUMBER_OF_POTIONS;
        enemiesKilled = 0;
        sword = SwordFactory.getSword(SwordEnum.WOOD); //default is wood sword
        armour = ArmourFactory.getArmour(ArmourEnum.LEATHER); //default is clothes
        pouch = new Bank();
    }

    /**
     * Returns the name of this player.
     *
     * @return the name of this player
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the health of this player.
     *
     * @return the health of this player
     */
    public int health()
    {
        return health;
    }

    /**
     * Returns the enemies killed of this player.
     *
     * @return enemiesKilled
     */
    public int enemiesKilled()
    {
        return enemiesKilled;
    }

    /**
     * Returns the number of potions this player has.
     *
     * @return the number of potions this player has
     */
    public int getPotions()
    {
        return potionsRemaining;
    }

    /**
     * Returns the sword of this player.
     *
     * @return the sword of this player
     */
    public Sword getSword()
    {
        return sword;
    }

    /**
     * Returns the armour of this player.
     *
     * @return the armour of this player
     */
    public Armour getArmour()
    {
        return armour;
    }

    /**
     * Returns the pouch of this player.
     *
     * @return the pouch of this player
     */
    public Bank getPouch()
    {
        return pouch;
    } // end of method getPouch()

    /**
     * Returns whether this player has a sword.
     *
     * @return <code>true</code> if this player has a sword, otherwise <code>false</code>
     */
    public boolean hasSword()
    {
        return hasSword;
    }

    /**
     * Returns whether this player has armour.
     *
     * @return <code>true</code> if this player has armour, otherwise <code>false</code>
     */
    public boolean hasArmour()
    {
        return hasArmour;
    }

    /**
     * Sets the number of enemies killed by this player. Used for importing saved data.
     *
     * @param enemiesKilled the number of enemies killed by this player
     */
    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

    /**
     * Sets the age of the Player
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the gender of Player
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets Nick name of Player
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Sets the Player Role
     * @param role
     */
    public void setRole(PlayerRole role) {
        this.role = role;
    }

    /**
     * Sets the number of health points of this player.
     *
     * @param healthPoints the number of health points to give this player
     */
    public void setHealth(int healthPoints) {
        if (healthPoints > 0 && healthPoints <= FULL_HEALTH) {
            health = healthPoints;
        }
    }

    /**
     * Sets the name of this player.
     *
     * @param name the new name of this player
     */
    public void setName(String name)
    {
        this.name = name;
    } // end of method setName(String name)

    /**
     * Sets the  of this player.
     *
     * @param potions the new name of this player
     */
    public void setNumberOfPotions(int potions) {
        if (potions >= 0) {
            potionsRemaining = potions;
        }
    }


    /**
     * Returns damage dealt by this player, accounting for their sword.
     *
     * @return the damage done by this player
     */
    public int attack() {
        if (hasSword) {
            sword.useSword();
            if (sword.hitpoints() <= 0) {
                print("\nYour " + sword.name() + " broke.");
                delayMessage();
                hasSword = false;
            }
            return RANDOM.nextInt(MAXIMUM_ATTACK_DAMAGE) + sword.damageIncrease();
        }
        return RANDOM.nextInt(MAXIMUM_ATTACK_DAMAGE);
    }

    /**
     * Reduce the Health Point of the player by a specified amount.
     *
     * @param damage the amount of damage to deal to this player
     */
    public void takeDamage(int damage) {
        if (hasArmour) {
            armour.useArmour();
            health = health - Math.max(damage - armour.damageBlocked(), 0);

            if (armour.hitpoints() <= 0) {
                print("\nYour " + armour.name() + " broke.");
                delayMessage();
                hasArmour = false;
            }
        }
        else {
            health = health - damage;
        }
    }

    /* This  Methods that affect the potions of the player. */
    /*
     * Uses a potion on the player.
     */
    public void usePotion() {
        if (potionsRemaining <= 0) return;
        health = health + POTION_HEALING;
        potionsRemaining--;
    }

    /**
     * Increases the amount of potions this player has by a specified amount.
     *
     * @param potions the number of potions to add to this player
     */
    public void addPotions(int potions) {
        potionsRemaining = potionsRemaining + potions;
    }

    /**
     * Increases the enemies kill count
     */
    public void increaseEnemiesKilled() {
        enemiesKilled++;
    }

    /* Methods that affect the equipment of this player. */
    /*
     * Gives a sword to this player.
     */
    public void addSword(SwordEnum type) {
        if (type == null) return;
        sword = SwordFactory.getSword(type);
        hasSword = true;
    }

    /**
     * Gives armour to this player.
     */
    public void addArmour(ArmourEnum type) {
        if (type == null) return;
        armour = ArmourFactory.getArmour(type);
        hasArmour = true;
    }

    /**
     * Returns this player's data to be saved in text format.
     */
    public String getData() {
        return
                name + " "
                        + age + " "
                        + gender + " "
                        + nickName + " "
                        + hasSword + " "
                        + hasArmour + " "
                        + enemiesKilled + " "
                        + health + " "
                        + potionsRemaining + " "
                        + pouch.getCoins() + " "
                        + sword.name() + " "
                        + armour.name() + " "
                        + role.name();
    }

    /**
     * Resets the state of this player.
     */
    public void reset() {
        health = FULL_HEALTH;
        potionsRemaining = DEFAULT_NUMBER_OF_POTIONS;
        enemiesKilled = 0;
        hasSword = false;
        hasArmour = false;
    }
}
