package com.game.battlefield.game.weapons.sword;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.game.battlefield.game.weapons.sword.SwordEnum.*;

public class SwordFactory {

    final static Map<SwordEnum, Supplier<Sword>> armourMap = new HashMap<>(3);
    static {
        armourMap.put(WOOD, () -> new WoodSword(WOOD.name()));
        armourMap.put(METAL, () -> new MetalSword(METAL.name()));
        armourMap.put(GOLD, () -> new GoldSword(GOLD.name()));
    }

    public static Sword getSword(SwordEnum type) {
        Supplier<Sword> swordSupplier = armourMap.get(type);
        if(swordSupplier != null) {
            return  swordSupplier.get();
        }
        throw new IllegalArgumentException("No such Sword " + type);
    }
}
