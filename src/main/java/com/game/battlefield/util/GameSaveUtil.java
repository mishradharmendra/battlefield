package com.game.battlefield.util;


import com.game.battlefield.game.player.Player;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import com.game.battlefield.game.weapons.sword.SwordEnum;

import java.io.*;

import static com.game.battlefield.util.PrintUtil.print;

/**
 * Class saves data to the file and load data from file.
 * It encrypt the data before exporting to file
 * It used SHA 256 encryption to encrypt data
 */
public class GameSaveUtil {

    /**
     * Saves the state of this player to a text file.
     *
     * @param player the player whose state should be saved
     */
    public static void saveState(Player player) {
        /* Check if the user does not have a name, if so get the name */
        if (player.getName().equals("")) {
            System.out.print("Enter your name: ");
            String name = PrintUtil.getStirngMenuOption();

            /* Remove whitespace from the name. */
            name = name.replaceAll("\\s+","");
            player.setName(name);
        }

        try {
            File userData = new File("users/" + player.getName() + ".txt");
            userData.getParentFile().mkdirs();
            PrintWriter writer = new PrintWriter(userData);
            String encrypted = GameEncryption.encrypt(player.getData());
            writer.println(encrypted);
            writer.close();
            print("Your data was saved. You may now safely close the console.");
        }
        catch (FileNotFoundException exception) {
            System.out.println("File could not be written. Data was not saved.");
        }
    }

    /**
     * Loads the state of a player from a text file and updates the player using those data.
     */
    public static void loadState(Player player) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("users/" + player.getName() + ".txt"));
        String[] data = GameEncryption.decrypt(reader.readLine()).split(" ");

        reader.close();

        String name = data[0];
        int age = Integer.parseInt(data[1]);
        String gender = data[2];
        String nickName = data[3];
        boolean hasSword = Boolean.parseBoolean(data[4]);
        boolean hasArmour = Boolean.parseBoolean(data[5]);
        int enemiesKilled = Integer.parseInt(data[6]);
        int health = Integer.parseInt(data[7]);
        int numberOfPotions = Integer.parseInt(data[8]);
        int coins = Integer.parseInt(data[9]);
        String sword = data[10];
        String armour = data[11];

        player.setName(name);
        player.setAge(age);
        player.setGender(gender);
        player.setNickName(nickName);

        if (hasSword) player.addSword(SwordEnum.valueOf(sword));

        if (hasArmour) player.addArmour(ArmourEnum.valueOf(armour));

        player.setEnemiesKilled(enemiesKilled);
        player.setHealth(health);
        player.setNumberOfPotions(numberOfPotions);
        player.getPlayerCoin().setCoins(coins);
    }
}
