package com.mygdx.game.entity;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Direction;
import com.mygdx.game.GameState;
import com.mygdx.game.entity.fruit.Fruit;
import com.mygdx.game.util.GameDataProvider;

import java.util.LinkedList;

/**
 * Represents a snake in the game, acts like an entity but is not actually one.
 */
public class Snake {
    /**
     * The current time left until the next movement
     */
    private float movementCounter;
    /**
     * Time between each move
     */
    private static final float MOVEMENT_DELAY = 0.1f;
    /**
     * The starting direction
     */
    private static final Direction STARTING_DIRECTION = Direction.RIGHT;
    /**
     * The direction the snake is currently moving
     */
    private Direction direction;
    /**
     * The previous direction
     */
    private Direction previousDirection;
    /**
     * The snake body parts
     */
    private LinkedList<SnakeBody> body;
    /**
     * The score of this snake
     */
    private int score;
    /**
     * The growth remaining from eating fruit
     */
    private int growthRemaining;

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
        initialize(x, y, length);
    }

    /**
     * Snake constructor
     * @param body The body of the snake
     * @param startingDirection The starting direction of the snake
     */
    public Snake(LinkedList<SnakeBody> body, Direction startingDirection) {
        initialize(body, startingDirection);
    }

    /**
     * Initializes the snake with the values provided by the GameDataProvider
     */
    public void initialize() {
        initialize(GameDataProvider.INITIAL_SNAKE_X, GameDataProvider.INITIAL_SNAKE_Y,
                GameDataProvider.INITIAL_SNAKE_LENGTH);
    }
    /**
     * Initializes the snake
     * @param x The x coordinate of the head
     * @param y The y coordinate of the header
     */
    public void initialize(float x, float y, int length) {
        body = new LinkedList<SnakeBody>();

        for(int i = 0; i < length; ++i) {
            body.add(new SnakeBody(x - (i *GameDataProvider.CELL_WIDTH), y));
        }
        direction = STARTING_DIRECTION;
        previousDirection = direction;
        movementCounter = MOVEMENT_DELAY;
        score = 0;
        growthRemaining = 0;
        movementCounter = 0;
    }

    /**
     * Initializes the snake
     * @param body The body of the snake
     * @param startingDirection The starting direction
     */
    public void initialize(LinkedList<SnakeBody> body, Direction startingDirection) {
        this.body = body;
        direction = startingDirection;
        previousDirection = direction;
        movementCounter = MOVEMENT_DELAY;
        score = 0;
        growthRemaining = 0;
        movementCounter = 0;
    }

    /**
     * Gets the score of this snake
     * @return The score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the length of this snake
     * @return The length
     */
    public int getLength() {
        return body.size();
    }

    /**
     * Sets the direction of the snake
     * @param direction The new direction
     */
    public void setDirection(Direction direction) {
        if(direction != this.direction && ((direction == Direction.UP && this.direction != Direction.DOWN) ||
                (direction == Direction.DOWN && this.direction != Direction.UP) ||
                (direction == Direction.RIGHT && this.direction != Direction.LEFT) ||
                (direction == Direction.LEFT && this.direction != Direction.RIGHT))) {
            previousDirection = this.direction;
            this.direction = direction;
        }
    }

    /**
     * Checks if a set of points is touching any part of the snake
     * @param x The x coordinate
     * @param y The y coordinate
     * @return True if touching, false otherwise
     */
    public boolean isTouching(float x, float y) {
        for(SnakeBody sb : body) {
            if(sb.isTouching(x, y)) {
                return true;
            }
        }
        return false;
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
        movementCounter -= elapsedTime;
        handleMovement();
        handleCollisions();
        if(getLength() < 2) {
            GameDataProvider.instance().setState(GameState.GAME_OVER);
        }
    }

    /**
     * Handles the movement
     */
    private void handleMovement() {
        SnakeBody newHead = selectNewHead();
        if(newHead != null) {
            moveHead(newHead);
        }
    }

    private SnakeBody selectNewHead() {
        if(movementCounter <= 0) {
            if(growthRemaining == 0) {
                 return body.removeLast();
            }
            else {
                return handleGrowth();
            }
        }
        return null;
    }

    /**
     * Handles movement when the snake does not need to grow
     */
    private void moveHead(SnakeBody newHead) {
        switch (direction) {
            case UP:
                newHead.setY(body.getFirst().getY() + GameDataProvider.CELL_HEIGHT);
                break;
            case DOWN:
                newHead.setY(body.getFirst().getY() - GameDataProvider.CELL_HEIGHT);
                break;
            case LEFT:
                newHead.setX(body.getFirst().getX() - GameDataProvider.CELL_WIDTH);
                break;
            case RIGHT:
                newHead.setX(body.getFirst().getX() + GameDataProvider.CELL_WIDTH);
                break;
        }

        // Fix location if changing direction
        if((direction == Direction.DOWN && (previousDirection == Direction.RIGHT || previousDirection == Direction.LEFT))
                || direction == Direction.UP && (previousDirection == Direction.LEFT || previousDirection == Direction.RIGHT)) {
            newHead.setX(body.getFirst().getX());
        }
        else {
            newHead.setY(body.getFirst().getY());
        }

        // Spit out head on other side of map
        if(newHead.getX() < 0) {
            newHead.setX(GameDataProvider.MAP_WIDTH);
        }
        else if(newHead.getX() > GameDataProvider.MAP_WIDTH) {
            newHead.setX(0);
        }

        if(newHead.getY() < 0) {
            newHead.setY(GameDataProvider.MAP_HEIGHT);
        }
        else if(newHead.getY() > GameDataProvider.MAP_HEIGHT) {
            newHead.setY(0);
        }

        body.addFirst(newHead);
        movementCounter = MOVEMENT_DELAY;
    }

    /**
     * Handles the growth of the snake
     */
    private SnakeBody handleGrowth() {
        if(growthRemaining > 0) {
            --growthRemaining;
            return new SnakeBody(0, 0);
        }
        else if(growthRemaining < 0) {
            body.removeLast();
            ++growthRemaining;
            if(getLength() > 1) {
                return body.removeLast();
            }
            else {
                return body.getLast();
            }
        }
        return null;
    }

    /**
     * Handles the collisions with other entities
     */
    private void handleCollisions() {
        SnakeBody head = body.getFirst();
        Fruit fruit = GameDataProvider.instance().getSpawner().eatFruit(head.getX(), head.getY());

        if(fruit != null) {
            score += fruit.getScoreValue();
            growthRemaining += fruit.getScoreValue();
        }

        // Check if the the snake is colliding with itself
        for(int i = 1; i < body.size(); ++i) {
            if(head.isTouching(body.get(i))) {
                GameDataProvider.instance().setState(GameState.GAME_OVER);
            }
        }
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
