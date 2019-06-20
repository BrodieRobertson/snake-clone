package com.mygdx.game.util;

import com.badlogic.gdx.audio.Music;

public class MusicController {
    /**
     * The instance of the MusicController
     */
    private static MusicController instance;
    /**
     * The current music being played
     */
    private Music currentMusic;
    /**
     * If the music is looping
     */
    private boolean loop;

    /**
     * Private MusicController constructor
     */
    private MusicController() {}

    /**
     * Gets the instance of the AudiController
     * @return The instance of the MusicController
     */
    public MusicController instance() {
        if(instance == null) {
            instance = new MusicController();
        }
        return instance;
    }

    /**
     * Checks if the music is looping
     * @return If the music is looping
     */
    public boolean isLooping() {
        return loop;
    }

    /**
     * Sets the current music
     * @param currentMusic The new current music
     */
    public void setCurrentMusic(Music currentMusic) {
        this.currentMusic = currentMusic;
    }

    /**
     * Sets the current music using an AssetManager path
     * @param path The path
     */
    public void setCurrentMusic(String path) {
        this.currentMusic = AssetProvider.instance().getAsset(path, Music.class);
    }

    /**
     * Sets if the music is looping
     * @param loop Sets if the music is looping
     */
    public void setLooping(boolean loop) {
        this.loop = loop;
        currentMusic.setLooping(loop);
    }

    /**
     * Checks if the music is playing
     * @return If the music is playing
     */
    public boolean isPlaying() {
        return currentMusic.isPlaying();
    }

    /**
     * Starts the music loop
     */
    public void startMusicLoop() {
        currentMusic.setLooping(true);
        loop = true;
        currentMusic.play();
    }

    /**
     * Stops the music loop
     */
    public void stopMusicLoop() {
        currentMusic.setLooping(false);
        loop = false;
        currentMusic.stop();
    }

    /**
     * Plays the music with the current loop setting
     */
    public void play() {
        currentMusic.setLooping(loop);
        currentMusic.stop();
    }

    /**
     * Pauses the music
     */
    public void pause() {
        currentMusic.pause();
    }

    /**
     * Stops the music
     */
    public void stop() {
        currentMusic.stop();
    }

    /**
     * Sets the volume of the current song
     * @param volume The volume
     */
    public void setVolume(float volume) {
        currentMusic.setVolume(volume);
    }

    /**
     * Gets the volume of the current song
     * @return The volume
     */
    public float getVolume() {
        return currentMusic.getVolume();
    }
}
