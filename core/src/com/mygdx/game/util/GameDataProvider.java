package com.mygdx.game.util;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameState;
import com.mygdx.game.entity.Snake;
import com.mygdx.game.spawner.FruitSpawner;

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
     * Width of the map
     */
    public static final int MAP_WIDTH = CELL_WIDTH * ROW_CELLS;
    /**
     * Height of the map
     */
    public static final int MAP_HEIGHT = CELL_HEIGHT * COL_CELLS;
    /**
     * The x offset to center the game
     */
    public static final int X_OFFSET = (Gdx.graphics.getWidth() - MAP_WIDTH)/2;
    /**
     * The y offset to center the game
     */
    public static final int Y_OFFSET = (Gdx.graphics.getHeight() - MAP_HEIGHT)/2;
    /**
     * The minimum traversable x
     */
    public static final int MIN_X = X_OFFSET;
    /**
     * The maximum traversable x
     */
    public static final int MAX_X = MAP_WIDTH + X_OFFSET - CELL_WIDTH;
    /**
     * The minimum traversable y
     */
    public static final int MIN_Y = Y_OFFSET;
    /**
     * The maximum traverable x
     */
    public static final int MAX_Y = MAP_HEIGHT + Y_OFFSET - CELL_HEIGHT;
    /**
     * The initial length of the snake
     */
    public static final int INITIAL_SNAKE_LENGTH = 3;
    /**
     * The initial x of the snake
     */
    public static final int INITIAL_SNAKE_X = X_OFFSET + (CELL_WIDTH * 20);
    /**
     * The initial y of the snake
     */
    public static final int INITIAL_SNAKE_Y = Y_OFFSET + (CELL_HEIGHT * 20);
    /**
     * The starting round
     */
    public static final int STARTING_ROUND = 1;
    /**
     * The current state of the game
     */
    private GameState state;
    /**
     * The players character
     */
    private Snake snake;
    /**
     * Handles the spawning of the fruit
     */
    private FruitSpawner spawner;
    /**
     * If the game is touched
     */
    private boolean isTouched;
    /**
     * If the game was touched
     */
    private boolean wasTouched;

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
        System.out.println(MIN_X);
        System.out.println(MAX_Y);
        state = GameState.GAME_OVER;
        spawner = new FruitSpawner(STARTING_ROUND);
        snake = new Snake();
        spawner.start();
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
     * Checks if a cell of the map is empty
     * @param x The grid x, not the pixel x
     * @param y The grid y, not the pixel y
     * @return If the cell is empty
     */
    public boolean cellEmpty(float x, float y) {
        return !snake.isTouching(x, y) && !spawner.isTouching(x, y);
    }

    /**
     * If the game is touched
     * @return Is touched
     */
    public boolean isTouched() {
        return isTouched;
    }

    /**
     * If the game was touched
     * @return Was touched
     */
    public boolean wasTouched() {
        return wasTouched;
    }

    /**
     * Starts the next round of the game
     */
    public void startNewRound() {
        spawner.incrementRound();
        spawner.start();
    }

    /**
     * Starts a new game
     */
    public void startNewGame() {
        spawner.setRound(STARTING_ROUND);
        snake.initialize();
        spawner.start();
    }

    /**
     * Gets the snake
     * @return The snake
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * Gets the game state
     * @return The game state
     */
    public GameState getState() {
        return state;
    }

    /**
     * Gets the fruit spawner
     * @return The fruit spawner
     */
    public FruitSpawner getSpawner() {
        return spawner;
    }

    /**
     * Sets the game state
     * @param state The new game state
     */
    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * Sets if the game is touched
     * @param isTouched If the game is touched
     */
    public void setIsTouched(boolean isTouched) {
        this.wasTouched = this.isTouched;
        this.isTouched = isTouched;
    }

    /**
     * Disposes of the GameDataProvider resources
     */
    public void dispose() {
        snake.dispose();
    }
}
