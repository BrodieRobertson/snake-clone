package com.mygdx.game.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetProvider {
    /**
     * Instance of the asset provider
     */
    private static AssetProvider instance;
    /**
     * The manager object
     */
    private AssetManager manager;
    /**
     * Path to the snake body
     */
    public static final String SNAKE_BODY = "snake_body.jpg";
    /**
     * Path to the small fruit
     */
    public static final String SMALL_FRUIT = "small_fruit.jpg";
    /**
     * Path to the big fruit
     */
    public static final String BIG_FRUIT = "big_fruit.jpg";
    /**
     * Path to the bad fruit
     */
    public static final String BAD_FRUIT = "bad_fruit.jpg";
    /**
     * Path to the font
     */
    public static final String FONT = "good_neighbors.fnt";

    /**
     * AssetProvider constructor
     */
    private AssetProvider() {
        manager = new AssetManager();
        manager.load(SNAKE_BODY, Texture.class);
        manager.load(SMALL_FRUIT, Texture.class);
        manager.load(BIG_FRUIT, Texture.class);
        manager.load(BAD_FRUIT, Texture.class);
        manager.load(FONT, BitmapFont.class);
        manager.finishLoading();
    }

    /**
     * Gets the instance of the AssetProvider
     * @return The instance
     */
    public static AssetProvider instance() {
        if(instance == null) {
            instance = new AssetProvider();
        }
        return instance;
    }

    /**
     * Gets an asset
     * @param path The asset path
     * @param type The type of asset
     * @return The asset or null if it's unavailable
     */
    public <T> T getAsset(String path, Class<T> type) {
        return manager.get(path, type);
    }

    /**
     * Loads an asset
     * @param path The asset path
     * @param type The type of asset
     */
    public void loadAsset(String path, Class type) {
        manager.load(path, type);
    }
}
