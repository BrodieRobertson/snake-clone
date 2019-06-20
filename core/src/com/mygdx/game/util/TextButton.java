package com.mygdx.game.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextButton extends Button {
    /**
     * The text of the button
     */
    private Text text;

    /**
     * TextButton constructor with no parameters
     */
    public TextButton() {
        super();
        this.text = new Text();
    }

    /**
     * TextButton constructor
     * @param text The text
     */
    public TextButton(Text text) {
        super();
        this.text = text;
        setCollider(text.getX(), text.getY(), text.getWidth(), text.getHeight());
    }

    /**
     * Gets the text of the text button
     * @return The text
     */
    public Text getText() {
        return text;
    }

    /**
     * Sets the text of the text button
     * @param text The text
     * @return The new text
     */
    public void setText(Text text) {
        this.text = text;
        setCollider(text.getX(), text.getY(), text.getWidth(), text.getHeight());
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        text.setY(y);
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        text.setX(x);
    }

    @Override
    public void setLocation(float x, float y) {
        super.setLocation(x, y);
        setX(x);
        setY(y);
    }

    /**
     * Renders the button to the screen
     *
     * @param batch The batch
     */
    @Override
    public void render(SpriteBatch batch) {
        text.render(batch);
    }

    /**
     * Updates the state of the button
     *
     * @param elapsedTime The time elapsed since the previous frame
     * @param checkTouch  Check if the button is touched
     */
    @Override
    public void update(float elapsedTime, boolean checkTouch) {

    }

    /**
     * Disposed of the button resources
     */
    @Override
    public void dispose() {

    }
}
