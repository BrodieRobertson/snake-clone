package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.util.GameDataProvider;

/**
 * Class representing the screen shown during general game player
 */
public class GameScreen extends Screen {
    /**
     * The game data provider
     */
    GameDataProvider dataProvider;

    /**
     * Game Screen constructor
     */
    public GameScreen() {
        dataProvider = GameDataProvider.instance();
    }

    /**
     * Renders the screen
     *
     * @param entityBatch Batch used to display the entities
     * @param uiBatch Batch used to display the ui
     */
    @Override
    public void render(SpriteBatch entityBatch, SpriteBatch uiBatch) {
        entityBatch.begin();
        dataProvider.getSnake().render(entityBatch);
        entityBatch.end();
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
