package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.util.GameDataProvider;

import java.util.LinkedList;

/**
 * Represents a snake in the game, acts like an entity but is not actually one.
 */
public class Snake {
    /**
     * The snake body parts
     */
    private LinkedList<SnakeBody> body;

    /**
     * Snake constructor with no parameters, initializes body to values set in GameDataProvider
     */
    public Snake() {
        this(GameDataProvider.INITIAL_SNAKE_X, GameDataProvider.INITIAL_SNAKE_Y,
                GameDataProvider.INITIAL_SNAKE_LENGTH);
    }
    /**
     * Snake constructor
     * @param x The x of the head
     * @param y The y of the head
     * @param length The length of the snake
     */
    public Snake(float x, float y, int length) {
        body = new LinkedList<SnakeBody>();

        for(int i = 0; i < length; ++i) {
            body.add(new SnakeBody(x + i, y));
        }
    }

    /**
     * Snake constructor
     * @param body The body of the snake
     */
    public Snake(LinkedList<SnakeBody> body) {
        this.body = body;
    }

    /**
     * Renders the snake to the screen
     * @param batch The sprite batch
     */
    public void render(SpriteBatch batch) {
        for(SnakeBody sb : body) {
            sb.render(batch);
        }
    }

    /**
     * Updates the state of the snake
     * @param elapsedTime The time elapsed since the previous frame
     */
    public void update(float elapsedTime) {

    }

    /**
     * Disposes of the snake resources
     */
    public void dispose() {
        for(SnakeBody sb : body) {
            sb.dispose();
        }
    }
}
