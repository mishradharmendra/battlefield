package com.game.battlefield;

import com.game.battlefield.game.Store;
import com.game.battlefield.game.player.Player;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    Player player = new Player();

    @Test
    public void canBuyArmour(){
        player.getPouch().addCoins(500);
        int initialBalance = player.getPouch().getCoins();
        System.out.println("Player has total coin in bank :: " + player.getPouch().getCoins());

        assertEquals(player.hasArmour(),false);
        if(player.getPouch().getCoins() > Store.ARMOUR_PRICE[2]) {
            player.addArmour(ArmourEnum.GOLD);
            player.getPouch().removeCoins(Store.ARMOUR_PRICE[2]);
        }

        assertEquals(player.getPouch().getCoins(), (initialBalance - Store.ARMOUR_PRICE[2]));
        assertEquals(player.hasArmour(),true);
    }

    @Test
    public void canBuySWord(){
        player.getPouch().addCoins(500);
        int initialBalance = player.getPouch().getCoins();
        System.out.println("Player has total coin in bank :: " + player.getPouch().getCoins());

        assertEquals(player.hasSword(), false);
        if(player.getPouch().getCoins() > Store.SWORD_PRICE[2]) {
            player.addArmour(ArmourEnum.GOLD);
            player.getPouch().removeCoins(Store.SWORD_PRICE[2]);
        }

        assertEquals(player.getPouch().getCoins(), (initialBalance - Store.SWORD_PRICE[2]));
        assertEquals(player.hasSword(), true);
    }
    @Test
    public void canBuyPotion() {
        player.getPouch().addCoins(500);
        int initialBalance = player.getPouch().getCoins();
        int initialPotion = player.getPotions();
        System.out.println("Player has total coin in bank :: " + player.getPouch().getCoins());
        System.out.println("initial potion for player " + initialPotion);

        if(player.getPouch().getCoins() > Store.POTION_PRICE) {
            player.addPotions(5);
            player.getPouch().removeCoins(Store.POTION_PRICE * 5);
        }

        assertEquals(player.getPouch().getCoins(), (initialBalance - Store.POTION_PRICE * 5));
        assertEquals(player.getPotions(), initialPotion+5);
    }

}
