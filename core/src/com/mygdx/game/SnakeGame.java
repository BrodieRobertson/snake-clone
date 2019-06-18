package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.screen.Screen;
import com.mygdx.game.util.GameDataProvider;

import java.util.HashMap;
import java.util.Map;

public class SnakeGame extends ApplicationAdapter {
	/**
     * Map of the available screens
     */
	private Map<GameState, Screen> screens;
	/**
	 * The batch used to render entites
	 */
	SpriteBatch entityBatch;
	/**
	 * The batch used to render the ui
	 */
	SpriteBatch uiBatch;

	@Override
	public void create () {
		entityBatch = new SpriteBatch();
		uiBatch = new SpriteBatch();

		screens = new HashMap<GameState, Screen>();
		screens.put(GameState.PLAYING, new GameScreen());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Screen currentScreen = screens.get(GameDataProvider.instance().getState());
		currentScreen.update(Gdx.graphics.getDeltaTime());
		currentScreen.render(entityBatch, uiBatch);
	}
	
	@Override
	public void dispose () {
		entityBatch.dispose();
		uiBatch.dispose();
	}
}
