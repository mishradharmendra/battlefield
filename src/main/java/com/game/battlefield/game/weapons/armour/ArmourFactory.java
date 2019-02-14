package com.game.battlefield.game.weapons.armour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.game.battlefield.game.weapons.armour.ArmourEnum.*;

public class ArmourFactory {

    final static Map<ArmourEnum, Supplier<Armour>> armourMap = new HashMap<>(3);
    static {
        armourMap.put(LEATHER, () -> new LeatherArmour(LEATHER.name()));
        armourMap.put(IRON, () -> new IronArmour(IRON.name()));
        armourMap.put(GOLD, () -> new GoldArmour(GOLD.name()));
    }
    public static Armour getArmour(ArmourEnum type) {
        Supplier<Armour> armourSupplier = armourMap.get(type);
        if(armourSupplier != null) {
            return  armourSupplier.get();
        }
        throw new IllegalArgumentException("No such Armour " + type);
    }
}
