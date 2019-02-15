package com.game.battlefield.game;


import com.game.battlefield.game.player.Enemy;
import com.game.battlefield.game.player.Player;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import com.game.battlefield.game.weapons.sword.SwordEnum;
import com.game.battlefield.util.GameSaveUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.game.battlefield.game.Menu.startBattle;
import static com.game.battlefield.game.Menu.yesNoMenuOption;
import static com.game.battlefield.game.GameConstant.*;
import static com.game.battlefield.util.PrintUtil.*;

public class BattleFieldGame {


    private Player player;
    private Bank bank;
    private int armourDropChance;
    private int healthPotionDropChance;
    private int swordDropChance;
    private boolean running;
    private boolean ranAway;


    public BattleFieldGame(){
        player = new Player();
        bank = player.getPlayerCoin();
        armourDropChance = 10;
        healthPotionDropChance = 50;
        swordDropChance = 10;
        running = true;
        ranAway = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void start() {

        while (running) {
            // Main enemy
            Enemy enemy = new Enemy();

            while (enemy.health() > 0) {
                printStatistics(player, enemy);

                startBattle();

                GameOptions choice = GameOptions.values()[getValidMenuOption() - 1];
                switch (choice) {
                    case ATTACK:
                        attack(enemy);
                        break;

                    case USEPOTION:
                        if (player.health() > FULL_HEALTH - POTION_HEALING) {
                            print("\nYou are healthy, and do not need a potion.");
                            delayMessage();
                            break;
                        }
                        player.usePotion();
                        print("\nYou drank the potion. Health restored by: " + POTION_HEALING + " HP");
                        print("Current HP: " + player.health());
                        delayMessage();
                        break;

                    case RUN:
                        /* Penalize the player by removing their coins or health */
                        runAway(enemy);
                        break;

                    case VISITSTORE:
                        Store.printStore(player);
                        break;

                    case EXIT:
                        exitGame();
                        return;
                }

                if (player.health() <= 0) {
                    print("\nYou died, game over.");

                    print("Would you like to replay? ");
                    yesNoMenuOption();

                    if (getValidMenuOption()==1) {
                        running = true;
                        player.reset();
                    }
                    else {
                        print("\nProgram terminated.");
                        enemy.takeDamage(enemy.health());
                        running = false;
                        return;
                    }
                }
            }

            if (!ranAway) {
                player.increaseEnemiesKilled();

                bank.addCoins(RANDOM.nextInt(MAXIMUM_GOLD_DROP));

                if (RANDOM.nextInt(100) < swordDropChance) {
                    if (player.hasSword()) {
                        print("\nThe " + enemy.name() + " dropped a sword, but you already have one.");
                    }
                    else {
                        player.addSword(SwordEnum.WOOD);
                        print("\nThe " + enemy.name() + " dropped a " + player.getSword().name() + ".\nYour attack damage has now increased by " + player.getSword().damageIncrease() + ".");
                    }
                    delayMessage();
                } else if (RANDOM.nextInt(100) < armourDropChance) {
                    if (player.hasArmour()) {
                        print("\nThe " + enemy.name() + " dropped some armour, but you already have some.");
                    }
                    else {
                        player.addArmour(ArmourEnum.LEATHER);
                        print("\nThe " + enemy.name() + " dropped " + player.getArmour().name() + ".\nYour damage taken has now decreased by " + player.getArmour().damageBlocked() + ".");
                    }
                    delayMessage();
                } else if (RANDOM.nextInt(100) < healthPotionDropChance) {
                    player.addPotions(1);
                    print("\nThe " + enemy.name() + " dropped a health potion.");
                    delayMessage();
                }
            }
        }
    }

    private void exitGame() {
        print("Exiting game...");
        print("Would you like to save your game? ");
        yesNoMenuOption();
        if (getValidMenuOption()==1) {
            GameSaveUtil.saveState(player);
        }

        running = false;
        displayExitMessage();
    }

    private void runAway(Enemy enemy) {
        if (player.getPlayerCoin().getCoins() > PENALTY_FOR_RUNNING) {
            print("\n" + PENALTY_FOR_RUNNING + " coins were taken by the " + enemy.name());
            bank.removeCoins(PENALTY_FOR_RUNNING);
        }
        /* Player does not have enough coins. Take away health instead of coins. */
        else {
            print("\nThe enemy did " + PENALTY_FOR_RUNNING + " damage before you managed to escape");
            player.takeDamage(PENALTY_FOR_RUNNING);
        }

        print("\nYou successfully ran away!");
        delayMessage();

        enemy.takeDamage(enemy.health());

        ranAway = true;
    }

    private void attack(Enemy enemy) {
        ranAway = false;
        int damageDealth = player.attack();
        int damageTaken = enemy.attack();

        print("You Strike the " + enemy.name() + " for " + damageDealth + " damage");
        print("You received  " + damageTaken + " in retaliation");

        enemy.takeDamage(damageDealth);
        player.takeDamage(damageTaken);

        delayMessage();
    }

    public void loadGame() {

        print("\nWhat is your name? ");
        String name = getStirngMenuOption();

        name = name.replaceAll("\\s+","");
        player.setName(name);

        try {
            GameSaveUtil.loadState(player);
        }
        catch (FileNotFoundException exception) {
            print("\nYour saved game was not found. Starting a new unsaved game.");
            delayMessage();
        }
        catch (IOException exception) {
            print("Input from the keyboard could not be read. Please restart the game.");
        }
    }
}
