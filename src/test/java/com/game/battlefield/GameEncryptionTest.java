package com.game.battlefield;

import com.game.battlefield.game.player.Player;
import com.game.battlefield.game.player.PlayerRole;
import com.game.battlefield.game.weapons.armour.ArmourEnum;
import com.game.battlefield.game.weapons.sword.SwordEnum;
import com.game.battlefield.util.GameEncryption;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEncryptionTest {

    Player player = new Player();

    @BeforeAll
    public void setupPlayer() {
        player.setName("Tom");
        player.setRole(PlayerRole.WARRIOR);
        player.setNickName("Superman");
        player.setGender("Male");
        player.setEnemiesKilled(10);
        player.setHealth(50);
        player.addSword(SwordEnum.GOLD);
        player.addArmour(ArmourEnum.GOLD);
    }

    @Test
    public void encryptAndDecryptTest() {

        String encryptedData = GameEncryption.encrypt(player.getData());

        String decryptedData = GameEncryption.decrypt(encryptedData);

        String [] playerData = decryptedData.split("\\s+");

        String name = playerData[0];

        assertEquals(name,player.getName());
        assertEquals(player.enemiesKilled(), Integer.parseInt(playerData[6]));
        assertEquals(player.getSword().name(),SwordEnum.valueOf(playerData[10]) + " sword");


    }
}
