package com.mygdx.game.spawner;

import com.mygdx.game.FruitType;
import com.mygdx.game.entity.fruit.BadFruit;
import com.mygdx.game.entity.fruit.BigFruit;
import com.mygdx.game.entity.fruit.Fruit;
import com.mygdx.game.entity.fruit.SmallFruit;

import java.util.Random;

/**
 * Generates fruit
 */
public class FruitFactory {
    /**
     * Used to select random fruit
     */
    private Random random;
    /**
     * The number of fruit types in use
     */
    public static final int NUMBER_OF_FRUIT_TYPES = 3;

    /**
     * FruitType Factory constructor
     */
    public FruitFactory() {
        random = new Random();
    }

    /**
     * FruitFactory constructor
     * @param seed The seed of the number generator
     */
    public FruitFactory(long seed) {
        random = new Random(seed);
    }

    /**
     * Selects a random fruit to generate
     * @param x The x coordinate to place the fruit at
     * @param y The y coordinate to place the fruit at
     * @return The new fruit
     */
    public Fruit nextFruit(float x, float y) {
        return nextFruit(FruitType.getType(random.nextInt(NUMBER_OF_FRUIT_TYPES)), x, y);
    }

    /**
     * Generates a new fruit with a set type
     * @param type The type of fruit
     * @param x The x coordinates to place the fruit at
     * @param y The y coordinates to place the fruit at
     * @return The new fruit
     */
    public Fruit nextFruit(FruitType type, float x, float y) {
        switch (type) {
            case BAD:
                return new BadFruit(x, y);
            case BIG:
                return new BigFruit(x, y);
            case SMALL:
                return new SmallFruit(x, y);
            default:
                return null;
        }
    }
}
