package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Abstract super class representing a screen
 */
public abstract class Screen {

    /**
     * Screen Constructor
     */
    public Screen() {
    }
    /**
     * Renders the screen
     */
    public abstract void render(SpriteBatch entityBatch, SpriteBatch uiBatch);

    /**
     * Updates the state of the screen
     * @param elapsedTime The time elapsed since the previous frame
     */
    public abstract void update(float elapsedTime);

    /**
     * Disposes of the screen resources
     */
    public abstract void dispose();
}
