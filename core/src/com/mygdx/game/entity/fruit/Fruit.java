package com.mygdx.game.entity.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.entity.Entity;
import com.mygdx.game.util.GameDataProvider;

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
     * If this fruit has been ate
     */
    private boolean isAte;

    /**
     * FruitType constructor
     * @param texture The texture of the fruit
     * @param x The x coordinate of the fruit
     * @param y The y coordinate of the fruit
     * @param lengthValue The length value gained
     * @param scoreValue The score value gained
     */
    public Fruit(Texture texture, float x, float y, int lengthValue, int scoreValue) {
        super(texture, x, y, GameDataProvider.CELL_WIDTH, GameDataProvider.CELL_HEIGHT);
        this.lengthValue = lengthValue;
        this.scoreValue = scoreValue;
        isAte = false;
    }

    /**
     * Gets if this fruit has been ate
     * @return If this fruit has been ate
     */
    public boolean isAte(){
        return isAte;
    }

    /**
     * Sets if this fruit has been ate
     * @param ate If this fruit has been ate
     */
    public void setAte(boolean ate) {
        isAte = ate;
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

    @Override
    public void update(float elapsedTime) {

    }
}
