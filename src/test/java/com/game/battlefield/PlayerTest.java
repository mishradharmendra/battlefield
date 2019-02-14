package com.game.battlefield;

import com.game.battlefield.game.player.Player;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    Player player = new Player();

    @Test
    public void playerPotionTest() {

        player.setName("Tom");
        int playerPotion = player.getPotions();

        player.usePotion();
        int playerPotionAfter = player.getPotions();
        assertEquals(playerPotion, playerPotionAfter+1);

        player.usePotion();
        player.usePotion();
        player.usePotion();
        player.usePotion();
        assertEquals(player.getPotions(), 0);


        player.addPotions(10);
        assertEquals(player.getPotions(), 10);

    }

    @Test
    public void leatherArmourTest() {
        int health = player.health();
        System.out.println("player health before damage :: "+ health);
        player.addArmour(ArmourEnum.LEATHER);
        int damageBlocked = player.getArmour().damageBlocked();
        System.out.println("damageBlocked by leather armour :: " +damageBlocked);
        player.takeDamage(20);

        System.out.println("Player health after attack::" + player.health());
        assertEquals(player.health(), (health - Math.max(20 - damageBlocked,0)));
    }

    @Test
    public void ironArmourTest() {
        int health = player.health();
        System.out.println("player health before damage :: "+ health);
        player.addArmour(ArmourEnum.IRON);
        int damageBlocked = player.getArmour().damageBlocked();
        System.out.println("damageBlocked by iron armour :: " +damageBlocked);
        player.takeDamage(20);

        System.out.println("Player health after attack::" + player.health());
        assertEquals(player.health(), (health - Math.max(20 - damageBlocked,0)));
    }

    @Test
    public void goldArmourTest() {
        int health = player.health();
        System.out.println("player health before damage :: "+ health);
        player.addArmour(ArmourEnum.GOLD);
        int damageBlocked = player.getArmour().damageBlocked();
        System.out.println("damageBlocked by gold armour :: " +damageBlocked);
        player.takeDamage(20);

        System.out.println("Player health after attack::" + player.health());
        assertEquals(player.health(), (health - Math.max(20 - damageBlocked,0)));
    }


}
