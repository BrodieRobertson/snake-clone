package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Abstract super class representing an entity in the game world
 */
public abstract class Entity {
    /**
     * The sprite of the entity
     */
    private Sprite sprite;

    public Entity(Texture texture, float x, float y) {
        this.sprite = new Sprite(texture);
        sprite.setX(x);
        sprite.setY(y);
    }

    /**
     * Gets the x coordinate of the entity
     * @return The x coordinates
     */
    public float getX() {
        return sprite.getX();
    }

    /**
     * Gets the y coordinates of the entity
     * @return The y coordinates
     */
    public float getY() {
        return sprite.getY();
    }

    /**
     * Gets the location of an entity
     * @return The position of the entity
     */
    public Vector2 getLocation() {
        return new Vector2(sprite.getX(), sprite.getY());
    }

    /**
     * Amount to translate x by
     * @param x The x translation amount
     */
    public void translateX(float x) {
        sprite.translateX(x);
    }

    /**
     * Amount to translate y by
     * @param y The y translation amount
     */
    public void translateY(float y) {
        sprite.translateY(y);
    }

    /**
     * Amount to translate x and y by
     * @param x The x translation amount
     * @param y The y translation amount
     */
    public void translate(float x, float y) {
        sprite.translate(x, y);
    }

    /**
     * Gets the width of the entity
     * @return The width
     */
    public float getWidth() {
        return sprite.getWidth();
    }

    /**
     * Gets the height of the entity
     * @return The height
     */
    public float getHeight() {
        return sprite.getHeight();
    }

    /**
     * Renders the entity to the screen
     * @param batch The sprite batch
     */
    public abstract void render(Sprite batch);

    /**
     * Updates the entities state
     * @param elapsedTime The time elapsed since the previous frame
     */
    public abstract void update(float elapsedTime);

    /**
     * Disposes of the entities resources
     */
    public void dispose() {
        sprite.getTexture().dispose();
    }
}
