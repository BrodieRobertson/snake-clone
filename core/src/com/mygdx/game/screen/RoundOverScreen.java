package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.util.Text;

public class RoundOverScreen extends Screen {
    /**
     * The text showing round over
     */
    private Text roundOverText;

    public RoundOverScreen() {
        super();
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

    }
    /**
     * Renders the screen
     *
     * @param entityBatch
     * @param uiBatch
     */
    @Override
    public void render(SpriteBatch entityBatch, SpriteBatch uiBatch) {

    }

    /**
     * Updates the state of the screen
     *
     * @param elapsedTime The time elapsed since the previous frame
     */
    @Override
    public void update(float elapsedTime) {

    }

    /**
     * Disposes of the screen resources
     */
    @Override
    public void dispose() {

    }
}
