package com.game.battlefield.game;

import com.game.battlefield.game.player.PlayerRole;

import java.util.Arrays;

import static com.game.battlefield.util.PrintUtil.*;

public class Menu {

    private Menu(){}
    public static void load(){
        while(true){

            //Menu Screen
            print("------------------------------------------------");
            print("|   WELCOME TO CONDITION ZERO BATTLE FIELD     |");
            print("|**********************************************|");
            print("|                                              |");
            print("| Enter the following options to get Started   |");
            print("|                                              |");
            print("| 1) Start New Game                            |");
            print("| 2) Load Previously Saved Game                |");
            print("| 3) Exit                                      |");
            print("-----------------------------------------------");

            switch (getValidMenuOption()) {
                case 1:
                    print("Create you character");
                    print("What's your name?");
                    String name = getStirngMenuOption();
                    print("What's you age?");
                    int age = getValidMenuOption();
                    print("Who are you Male/Female?");
                    String gender = getStirngMenuOption();
                    print("What nick name you wanted to use?");
                    String nickName = getStirngMenuOption();

                    print("What role you wanted to play?");
                    print(Arrays.toString(PlayerRole.values()));
                    String role = getStirngMenuOption();

                    BattleFieldGame game = new BattleFieldGame();
                    game.getPlayer().setAge(age);
                    game.getPlayer().setName(name);
                    game.getPlayer().setGender(gender);
                    game.getPlayer().setNickName(nickName);
                    game.getPlayer().setRole(PlayerRole.valueOf(role));
                    game.start();
                    return;
                case 2:
                    game = new BattleFieldGame();
                    game.loadGame();
                    print("Welcome Back "+ game.getPlayer().getName() + " you game is loaded please resume it.");
                    delayMessage();
                    game.start();
                    return;
                case 3:
                    displayExitMessage();
                    return;
                default:
                    print("Please enter correct Menu option");
                    continue;
            }
        }
    }

    /**
     * The battle prompt menu of this program.
     */
    public static void startBattle() {
        print("\nWhat you you like to do?");
        print("1. Attack.");
        print("2. Use potion.");
        print("3. Run!");
        print("4. Visit Store.");
        print("5. Exit Game.");

        print("\nYour Choice? ");
    }


    public static void yesNoMenuOption() {
        print("1. Yes.");
        print("2. No.");

        print("\nYour Choice? ");
    }

    public static void swordMenuOption() {
        print("1. Wood Sword. Price 75");
        print("2. Metal Sward. Price 90");
        print("2. Gold Sward. Price 100");

        print("\nYour Choice? ");
    }

    public static void armourMenuOption() {
        print("1. Leather Armour. Price 30");
        print("2. Iron Armour. Price 40");
        print("2. Gold Armour. Price 50");

        print("\nYour Choice? ");
    }
}
