package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Direction;
import com.mygdx.game.entity.Snake;
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
        dataProvider.getSnake().update(elapsedTime);

        Snake snake = dataProvider.getSnake();
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            snake.setDirection(Direction.UP);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            snake.setDirection(Direction.LEFT);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            snake.setDirection(Direction.DOWN);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            snake.setDirection(Direction.RIGHT);
        }
    }

    /**
     * Disposes of the screen resources
     */
    @Override
    public void dispose() {

    }
}
