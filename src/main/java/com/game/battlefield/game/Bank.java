package com.game.battlefield.game;

/**
 * This class holds all the coins collected by a player. For each victory Player gets coins which
 * he/she uses to buy the Potion or weapons etc.
 */
public class Bank {

    private int coins;

    public Bank() {
        coins = 0;
    }

    /**
     * Returns the coins in this pouch.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Adds coins to this pouch.
     *
     * @param coins the number of coins to add to this pouch
     */
    public void addCoins(int coins) {
        this.coins += coins;
    }

    /**
     * Removes coins from this pouch.
     *
     * @param coins the number of coins to remove from this pouch
     */
    public void removeCoins(int coins) {
        this.coins -= coins;
    }

    /**
     * Sets the coins of this pouch.
     *
     * @param coins the number of coins in this pouch
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }
}
