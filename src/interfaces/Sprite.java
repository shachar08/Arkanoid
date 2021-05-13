package interfaces;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */

import biuoop.DrawSurface;
import gamesettings.GameLevel;

/**
 * interface Sprite.
 * draw the sprite objects to the screen. */
public interface Sprite {
    /**
     * the method will draw the object on the given DrawSurface.
     * @param d - the surface of the game. */
    void drawOn(DrawSurface d);

    /**
     * the method will notify the sprite that time has passed and move the ball one step. */
    void timePassed();

    /**
     * the method will add the object to the game.
     * @param g - the game the object will be added to. */
    void addToGame(GameLevel g);
}