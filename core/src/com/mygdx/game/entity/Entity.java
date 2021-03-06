package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Abstract super class representing an entity in the game world
 */
public abstract class Entity {
    /**
     * The sprite of the entity
     */
    private Sprite sprite;

    /**
     * Entity constructor with no parameters
     */
    public Entity() {
        sprite = new Sprite();
    }

    public Entity(Texture texture, float x, float y) {
        this.sprite = new Sprite(texture);
        sprite.setX(x);
        sprite.setY(y);
    }

    /**
     * Entity constructor
     *
     * @param texture The texture of the entity
     * @param x The x coordinate
     * @param y The y coordinate
     * @param width The width
     * @param height The height
     */
    public Entity(Texture texture, float x, float y, float width, float height) {
        this(texture, x, y);
        sprite.setSize(width, height);
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
     * Gets the collider for this entity
     * @return The collider
     */
    public Rectangle getCollider() {
        return (sprite != null ? sprite.getBoundingRectangle() : null);
    }

    /**
     * Sets the texture of the sprite
     * @param texture The texture
     */
    public void setTexture(Texture texture) {
        this.sprite.setTexture(texture);
    }

    /**
     * Sets the rotation of the entity using degree
     * @param degree The degree
     */
    public void setRotation(float degree) {
        sprite.setRotation(degree);
    }

    /**
     * Sets the x coordinate for the entity
     * @param x The x coordinate
     */
    public void setX(float x) {
        sprite.setX(x);
    }

    /**
     * Sets the y coordinate for the entity
     * @param y The y coordinate
     */
    public void setY(float y) {
        sprite.setY(y);
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
     * Checks if a set of points is touching this entity
     * @param x The x coordinate
     * @param y The y coordinate
     * @return True if touching, false otherwise
     */
    public boolean isTouching(float x, float y) {
        return sprite.getBoundingRectangle().contains(x, y);
    }

    /**
     * Checks if a rectangle collider is overlapping this entity
     * @param collider The collider
     * @return True if overlapping, false otherwise
     */
    public boolean isTouching(Rectangle collider) {
        return collider != null && sprite.getBoundingRectangle().overlaps(collider);
    }

    /**
     * Checks if this entity is touching another entity
     * @param entity The other entity
     * @return True if touching, false otherwise
     */
    public boolean isTouching(Entity entity) {
        return entity != null && sprite.getBoundingRectangle().overlaps(entity.getCollider());
    }

    /**
     * Renders the entity to the screen
     * @param batch The sprite batch
     * @param alpha The alpha level of the entity
     */
    public void render(SpriteBatch batch, float alpha) {
        sprite.draw(batch, alpha);
    }

    /**
     * Renders the entity to the screen
     * @param batch The sprite batch
     */
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    /**
     * Updates the entities state
     * @param elapsedTime The time elapsed since the previous frame
     */
    public abstract void update(float elapsedTime);

    /**
     * Disposes of the entities resources
     */
    public abstract void dispose();

}
