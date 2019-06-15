package com.mygdx.game.util;

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
     * Width of movement grid
     */
    public static final int GRID_WIDTH = 16;
    /**
     * Height of movement grid
     */
    public static final int GRID_HEIGHT = 16;
    /**
     * The initial length of the snake
     */
    public static final int INITIAL_SNAKE_LENGTH = 3;
    /**
     * The initial x of the snake
     */
    public static final int INITIAL_SNAKE_X = 0;
    /**
     * The initial y of the snake
     */
    public static final int INITIAL_SNAKE_Y = 0;
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
