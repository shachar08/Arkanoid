package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.Animation;
/**
 * class AnimationRunner.
 *  takes an animation object and runs it. */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();
    /**
     * constructor.
     * will create the gui and number of frames per seconds of the game. */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", 800, 600);
        this.framesPerSecond = 60;
    }
    /**
     * the method will run the animation using do one frame method.
     * @param animation - the animation the game will run.  */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
    /**
     * the method will return the keyboard of the game.
     * @return - the keyboard of the game. */
    public KeyboardSensor getKeyboard() {
        return gui.getKeyboardSensor();
    }
    /**
     * the method will return the GUI of the game.
     * @return - the GUI of the game. */
    public GUI getGui() {
        return gui;
    }
}