package com.game.battlefield.game.weapons.armour;

public enum ArmourEnum {
    LEATHER("leather"),IRON("iron"),GOLD("gold"),CLOTHES("clothes");

    private String armourType;
    ArmourEnum(String armour) {
        this.armourType = armour;
    }
}
