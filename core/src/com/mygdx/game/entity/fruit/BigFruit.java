package com.mygdx.game.entity.fruit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.util.AssetProvider;

public class BigFruit extends Fruit {
    /**
     * The amount of length gained by eating this fuit
     */
    public static final int LENGTH_VALUE = 3;
    /**
     * The amount of score gained by eating this fruit
     */
    public static final int SCORE_VALUE = 5;
    /**
     * FruitType constructor
     *
     * @param x           The x coordinate of the fruit
     * @param y           The y coordinate of the fruit
     */
    public BigFruit(float x, float y) {
        super(AssetProvider.instance().getAsset(AssetProvider.BIG_FRUIT, Texture.class), x, y, LENGTH_VALUE, SCORE_VALUE);
    }
}
