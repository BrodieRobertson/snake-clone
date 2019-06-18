package com.mygdx.game;

/**
 * The types of fruit available
 */
public enum FruitType {
    SMALL(0), BIG(1), BAD(2);

    /**
     * FruitType constructor with an ordinal value
     * @param code The ordinal value
     */
    FruitType(int code) { }

    /**
     * Gets the enum type based on it's ordinal value
     * @param type The type
     * @return The type
     */
    public static FruitType getType(int type) {
        if(type < 0 || type > FruitType.values().length) {
            return null;
        }

        return FruitType.values()[type];
    }
}
