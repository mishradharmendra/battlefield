package com.game.battlefield.util;

import com.game.battlefield.game.player.Enemy;
import com.game.battlefield.game.player.Player;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.game.battlefield.game.GameConstant.DELAY;

public class PrintUtil {

    private static final Scanner INPUT = new Scanner(System.in);

    private PrintUtil(){}

    public static void print(String inputMessage) {
        System.out.println(inputMessage);
    }

    public static int getValidMenuOption() {
        int option = -1;
        while (!INPUT.hasNextInt()) {
            print("Please enter valid option");
            INPUT.nextLine();
        }
        option = INPUT.nextInt();
        INPUT.nextLine();
        return option;
    }

    public static String getStirngMenuOption() {
        return INPUT.nextLine();
    }

    /**
     * Prints the statistics of this game, includes the player's and enemy's state.
     * It prints the statistics after every action
     */
    public static void printStatistics(Player player, Enemy villain)  {
        print("------------------------------------------------------------");
        print("                  CURRENT STATUS                            ");
        print("************************************************************");
        print("# An Enemy " + villain.name() + " appeared. You will be Fighting with " + villain.name());
        print("                                                            ");
        print("# You have " + player.health() + " HP                       ");
        print("# " + villain.name() +" has " + villain.health() + " HP     ");
        print("# Potions left: " + player.getPotions() +  "                ");
        print("# You have " + player.getPlayerCoin().getCoins() + " coins left in Bank");
        print("# Total Enemies killed: " + player.enemiesKilled() + "      ");

        // Print in case player has Sword
        if (player.hasSword()) {
            print("\n# Sword type: " + player.getSword().name() + " | hitpoints: " + player.getSword().hitpoints() + "  #");
        }

        // Print in case player has Armour
        if (player.hasArmour()) {
            print("\n# Armour type: " + player.getArmour().name() + " | Armour hitpoints: " + player.getArmour().hitpoints() + "  #");
        }
    }

    /**
     * Method to delay the message so the one can read message/instructions properly.
     */
    public static void delayMessage() {
        try {
            TimeUnit.MILLISECONDS.sleep(DELAY);
        }
        catch (InterruptedException exception) {
            print("Game has encountered an internal error.");
            print("Please restart the game.");
            System.exit(0);
        }
    }


    public static void displayExitMessage() {
        print("#################################################################");
        print("Thanks for playing the Battle Field. Please Visit again and Play.");
        print("#################################################################");
    }

}
