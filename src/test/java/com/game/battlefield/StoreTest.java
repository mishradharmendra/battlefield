package com.game.battlefield;

import com.game.battlefield.game.Store;
import com.game.battlefield.game.player.Player;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import com.game.battlefield.game.weapons.sword.SwordEnum;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    Player player = new Player();

    @Test
    public void canBuyArmour(){
        player.getPlayerCoin().addCoins(500);
        int initialBalance = player.getPlayerCoin().getCoins();
        System.out.println("Player has total coin in bank :: " + player.getPlayerCoin().getCoins());

        assertEquals(player.hasArmour(),false);
        if(player.getPlayerCoin().getCoins() > Store.ARMOUR_PRICE[2]) {
            player.addArmour(ArmourEnum.GOLD);
            player.getPlayerCoin().removeCoins(Store.ARMOUR_PRICE[2]);
        }

        assertEquals(player.getPlayerCoin().getCoins(), (initialBalance - Store.ARMOUR_PRICE[2]));
        assertEquals(player.hasArmour(),true);
    }

    @Test
    public void canBuySWord(){
        player.getPlayerCoin().addCoins(500);
        int initialBalance = player.getPlayerCoin().getCoins();
        System.out.println("Player has total coin in bank :: " + player.getPlayerCoin().getCoins());

        assertEquals(player.hasSword(), false);
        if(player.getPlayerCoin().getCoins() > Store.SWORD_PRICE[2]) {
            player.addSword(SwordEnum.GOLD);
            player.getPlayerCoin().removeCoins(Store.SWORD_PRICE[2]);
        }

        assertEquals(player.getPlayerCoin().getCoins(), (initialBalance - Store.SWORD_PRICE[2]));
        assertEquals(player.hasSword(), true);
    }
    @Test
    public void canBuyPotion() {
        player.getPlayerCoin().addCoins(500);
        int initialBalance = player.getPlayerCoin().getCoins();
        int initialPotion = player.getPotions();
        System.out.println("Player has total coin in bank :: " + player.getPlayerCoin().getCoins());
        System.out.println("initial potion for player " + initialPotion);

        if(player.getPlayerCoin().getCoins() > Store.POTION_PRICE) {
            player.addPotions(5);
            player.getPlayerCoin().removeCoins(Store.POTION_PRICE * 5);
        }

        assertEquals(player.getPlayerCoin().getCoins(), (initialBalance - Store.POTION_PRICE * 5));
        assertEquals(player.getPotions(), initialPotion+5);
    }

}
