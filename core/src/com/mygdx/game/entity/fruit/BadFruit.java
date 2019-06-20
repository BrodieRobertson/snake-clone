package com.mygdx.game.entity.fruit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.util.AssetProvider;

public class BadFruit extends Fruit {
    /**
     * The amount of length gained by eating this fuit
     */
    public static final int LENGTH_VALUE = -1;
    /**
     * The amount of score gained by eating this fruit
     */
    public static final int SCORE_VALUE = -1;
    /**
     * FruitType constructor
     *
     * @param x           The x coordinate of the fruit
     * @param y           The y coordinate of the fruit
     */
    public BadFruit(float x, float y) {
        super(AssetProvider.instance().getAsset(AssetProvider.BAD_FRUIT, Texture.class), x, y, LENGTH_VALUE, SCORE_VALUE);
    }

    /**
     * Disposes of the entities resources
     */
    @Override
    public void dispose() {

    }
}
