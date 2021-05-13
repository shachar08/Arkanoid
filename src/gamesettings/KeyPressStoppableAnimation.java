package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
/**
 * class KeyPressStoppableAnimation.
 * decorator-class that will wrap an existing animation and add a "waiting-for-key" behavior to it. */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;
    /**
     * constructor.
     * @param sensor - the keyboard for the game.
     * @param key - the keyboard key for stop the animation and continue the game.
     * @param animation - the animation that the class will run. */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
        this.animation =  animation;
    }
    /**
     * the method will call the animation to draw the message on the given DrawSurface and will continue the game when
     * the given key will be pressed.
     * @param d - the surface of the game. */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(key)) {
            if (isAlreadyPressed) {
                return;
            }
            this.stop = true;
        }
        if (!this.sensor.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
    }
    /**
     * the method will return if we should stop the animation or not using boolean variable.
     * @return - true if we should stop the animation, false otherwise . */
    public boolean shouldStop()  {
        return this.stop;
    }
}
