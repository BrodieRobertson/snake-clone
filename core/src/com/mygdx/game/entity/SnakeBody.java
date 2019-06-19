package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.util.AssetProvider;
import com.mygdx.game.util.GameDataProvider;

/**
 * Represents one piece of the snake body
 */
public class SnakeBody extends Entity {
    /**
     * SnakeBody constructor
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public SnakeBody(float x, float y) {
        super(AssetProvider.instance().getAsset(AssetProvider.SNAKE_BODY, Texture.class), x, y,
                GameDataProvider.CELL_WIDTH, GameDataProvider.CELL_HEIGHT);
    }

    /**
     * Updates the entities state
     *
     * @param elapsedTime The time elapsed since the previous frame
     */
    @Override
    public void update(float elapsedTime) {

    }
}
