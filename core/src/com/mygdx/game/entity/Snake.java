package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.util.GameDataProvider;

import org.omg.PortableInterceptor.DISCARDING;

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
     * Direction change since last update
     */
    private boolean directionChanged;
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
        direction = STARTING_DIRECTION;
        previousDirection = direction;
        movementCounter = MOVEMENT_DELAY;
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
            body.add(new SnakeBody(x - (i *GameDataProvider.CELL_WIDTH), y));
        }
        direction = STARTING_DIRECTION;
        previousDirection = direction;
        movementCounter = MOVEMENT_DELAY;
    }

    /**
     * Snake constructor
     * @param body The body of the snake
     */
    public Snake(LinkedList<SnakeBody> body) {
        this.body = body;
        direction = STARTING_DIRECTION;
        previousDirection = direction;
        movementCounter = MOVEMENT_DELAY;
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
        if(movementCounter <= 0) {
            SnakeBody newHead = body.removeLast();
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

            if((direction == Direction.DOWN && (previousDirection == Direction.RIGHT || previousDirection == Direction.LEFT))
                    || direction == Direction.UP && (previousDirection == Direction.LEFT || previousDirection == Direction.RIGHT)) {
                newHead.setX(body.getFirst().getX());
            }
            else {
                newHead.setY(body.getFirst().getY());
            }
            body.addFirst(newHead);
            movementCounter = MOVEMENT_DELAY;
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
