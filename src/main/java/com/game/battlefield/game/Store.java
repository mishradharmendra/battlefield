package com.game.battlefield.game;


import com.game.battlefield.game.player.Player;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import com.game.battlefield.game.weapons.sword.SwordEnum;

import java.util.InputMismatchException;

import static com.game.battlefield.game.Menu.armourMenuOption;
import static com.game.battlefield.game.Menu.swordMenuOption;
import static com.game.battlefield.util.PrintUtil.*;

public class Store {

    public static final String[] ITEM = {"Sword", "Armour", "Potions"};

    public static final String[] STORE_ITEM_PRICE = {"75-100", "30-50", "10"};

    public static final int POTION_PRICE = 10;
    public static final int[] SWORD_PRICE = {75, 90, 100};
    public static final int[] ARMOUR_PRICE = {30, 40, 50};

    public static void printStore(Player player) {
        print("Welcome to the Battle Field store.\n");
        print("You have " + player.getPouch().getCoins() + " coins.\n");
        for (int i = 0; i < ITEM.length; i++) {
            print(i + 1 + ". " + ITEM[i] + ", Price: " + STORE_ITEM_PRICE[i]);
        }
        print(ITEM.length+1 + ". to return back to play");
        print("\nWhat would you like to buy? ");
        getInput(player);
    }

    private static void getInput(Player player) {
        int itemIndex;
        try {
            itemIndex = getValidMenuOption() - 1;
           if (itemIndex < 0 || itemIndex >= ITEM.length) return;
        }
        catch (InputMismatchException exception) {
            print("\nInvalid input given Exiting store...");
            delayMessage();
            return;
        }
        buyItem(player, itemIndex);
    }

    private static void buyItem(Player player, int itemIndex) {
        switch (itemIndex) {
            case 0:
                print("Please select the type of Sword you wanted to buy");
                swordMenuOption();
                int swordMenuChoice = getValidMenuOption();
                switch (swordMenuChoice) {
                    case 1:
                        if (player.getPouch().getCoins() < SWORD_PRICE[0]) {
                            print("\nYou have insufficient coins to buy Wood sword. Please purchase an afforable item.");
                            delayMessage();
                            printStore(player);
                            return;
                        }
                        player.addSword(SwordEnum.WOOD);

                        player.getPouch().removeCoins(SWORD_PRICE[0]);
                        print("\nYou purchased: Wood Sword  for " + SWORD_PRICE[0] + " coins");
                        break;
                    case 2:
                        if (player.getPouch().getCoins() < SWORD_PRICE[1]) {
                            print("\nYou have insufficient coins to buy Metal sword. Please purchase an afforable item.");
                            delayMessage();
                            printStore(player);
                            return;
                        }
                        player.addSword(SwordEnum.METAL);
                        player.getPouch().removeCoins(SWORD_PRICE[1]);
                        print("\nYou purchased: Metal Sword  for " + SWORD_PRICE[1] + " coins");

                        break;
                    case 3:
                        if (player.getPouch().getCoins() < SWORD_PRICE[2]) {
                            print("\nYou have insufficient coins to buy Gold sword. Please purchase an afforable item.");
                            delayMessage();
                            printStore(player);
                            return;
                        }
                        player.addSword(SwordEnum.GOLD);

                        player.getPouch().removeCoins(SWORD_PRICE[2]);
                        print("\nYou purchased: Gold Sword  for " + SWORD_PRICE[2] + " coins");

                        break;
                        default:
                            if (player.getPouch().getCoins() < SWORD_PRICE[0]) {
                                print("\nYou have insufficient coins to buy Wood sword. Please purchase an afforable item.");
                                delayMessage();
                                printStore(player);
                                return;
                            }
                            player.addSword(SwordEnum.WOOD);
                            player.getPouch().removeCoins(SWORD_PRICE[0]);
                            print("\nYou purchased: Wood Sword  for " + SWORD_PRICE[0] + " coins");

                }

                break;

            case 1:
                print("Please select the type of Armour you wanted to buy");
                armourMenuOption();
                int armourMenuChoice = getValidMenuOption();
                switch (armourMenuChoice) {
                    case 1:
                        if (player.getPouch().getCoins() < ARMOUR_PRICE[0]) {
                            print("\nYou have insufficient coins to buy Leather Armour. Please purchase an afforable item.");
                            delayMessage();
                            printStore(player);
                            return;
                        }
                        player.addArmour(ArmourEnum.LEATHER);

                        player.getPouch().removeCoins(ARMOUR_PRICE[0]);
                        print("\nYou purchased: Leather Armour  for " + ARMOUR_PRICE[0] + " coins");

                        break;
                    case 2:
                        if (player.getPouch().getCoins() < ARMOUR_PRICE[1]) {
                            print("\nYou have insufficient coins to buy Iron Armour. Please purchase an afforable item.");
                            delayMessage();
                            printStore(player);
                            return;
                        }
                        player.addArmour(ArmourEnum.IRON);
                        player.getPouch().removeCoins(ARMOUR_PRICE[1]);
                        print("\nYou purchased: Iron Armour  for " + ARMOUR_PRICE[1] + " coins");

                        break;
                    case 3:
                        if (player.getPouch().getCoins() < ARMOUR_PRICE[2]) {
                            print("\nYou have insufficient coins to buy Gold Armour. Please purchase an afforable item.");
                            delayMessage();
                            printStore(player);
                            return;
                        }
                        player.addArmour(ArmourEnum.GOLD);

                        player.getPouch().removeCoins(ARMOUR_PRICE[2]);
                        print("\nYou purchased: Gold Armour  for " + ARMOUR_PRICE[2] + " coins");

                        break;
                    default:
                        player.addArmour(ArmourEnum.CLOTHES);
                }
                break;

            case 2:
                player.addPotions(1);
                player.getPouch().removeCoins(POTION_PRICE);
                print("\nYou purchased: potion for " + POTION_PRICE + " coins");
                break;
        }
        delayMessage();
    }
}