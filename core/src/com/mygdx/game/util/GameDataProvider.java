package com.mygdx.game.util;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.entity.Snake;

/**
 * Singleton class to hold game data relevant to multiple classes where passing it around would
 * be challenging
 */
public class GameDataProvider {
    /**
     * GameDataProvider instance
     */
    private static GameDataProvider instance;
    /**
     * Number of cells in a row
     */
    public static final int ROW_CELLS = 30;
    /**
     * Number of cells in a column
     */
    public static final int COL_CELLS = 30;
    /**
     * Width of movement grid
     */
    public static final int CELL_WIDTH = Gdx.graphics.getHeight()/ROW_CELLS;
    /**
     * Height of movement grid
     */
    public static final int CELL_HEIGHT = Gdx.graphics.getHeight()/COL_CELLS;
    /**
     * The initial length of the snake
     */
    public static final int INITIAL_SNAKE_LENGTH = 3;
    /**
     * The initial x of the snake
     */
    public static final int INITIAL_SNAKE_X = CELL_WIDTH * 20;
    /**
     * The initial y of the snake
     */
    public static final int INITIAL_SNAKE_Y = CELL_HEIGHT * 20;
    /**
     * The players character
     */
    private Snake snake;

    /**
     * Private GameDataProvider constructor
     */
    private GameDataProvider() {
        initialize();
    }

    /**
     * Resets the values held by the GameDataProvider
     */
    public void initialize() {
        snake = new Snake();
    }

    /**
     * Gets the instance of the GameDataProvider
     * @return The instance of the GameDataProvider
     */
    public static GameDataProvider instance() {
        if(instance == null) {
            instance = new GameDataProvider();
        }
        return instance;
    }

    /**
     * Gets the snake
     * @return The snake
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * Disposes of the GameDataProvider resources
     */
    public void dispose() {
        snake.dispose();
    }
}
