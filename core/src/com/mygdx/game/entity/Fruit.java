package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;

/**
 * Abstract class to represent the kinds of fruit
 */
public abstract class Fruit extends Entity {
    /**
     * Length acquired by eating this fruit
     */
    private int lengthValue;
    /**
     * Score acquired by eating this fruit
     */
    private int scoreValue;

    /**
     * Fruit constructor
     * @param texture The texture of the fruit
     * @param x The x coordinate of the fruit
     * @param y The y coordinate of the fruit
     * @param lengthValue The length value gained
     * @param scoreValue The score value gained
     */
    public Fruit(Texture texture, float x, float y, int lengthValue, int scoreValue) {
        super(texture, x, y);
        this.lengthValue = lengthValue;
        this.scoreValue = scoreValue;
    }

    /**
     * Gets the length value
     * @return The length value
     */
    public int getLengthValue() {
        return lengthValue;
    }

    /**
     * Gets the score value
     * @return The score value
     */
    public int getScoreValue() {
        return scoreValue;
    }
}
