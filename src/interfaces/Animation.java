package interfaces;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.DrawSurface;
/**
 * interface Animation.
 * draw the sprite objects to the screen. */
public interface Animation {
    /**
     * the method will run the animation on the given DrawSurface.
     * @param d - the surface of the game. */
    void doOneFrame(DrawSurface d);
/**
 * the method will return if we should stop the animation or not using boolean variable.
 * @return - true if we should stop the animation, false otherwise . */
    boolean shouldStop();
}