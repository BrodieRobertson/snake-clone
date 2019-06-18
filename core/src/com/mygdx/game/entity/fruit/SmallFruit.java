package com.mygdx.game.entity.fruit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SmallFruit extends Fruit {
    /**
     * The amount of length gained by eating this fuit
     */
    public static final int LENGTH_VALUE = 1;
    /**
     * The amount of score gained by eating this fruit
     */
    public static final int SCORE_VALUE = 3;
    /**
     * Fruit constructor
     *
     * @param x           The x coordinate of the fruit
     * @param y           The y coordinate of the fruit
     */
    public SmallFruit(float x, float y) {
        super(new Texture(Gdx.files.internal("small_fruit.jpg")), x, y, LENGTH_VALUE, SCORE_VALUE);
    }
}
