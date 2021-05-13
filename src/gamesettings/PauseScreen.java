//package gamesettings;
///**
// * @author Shachar Korall.
// * ID: 208486191
// * @version IntelliJ IDEA 2019.3.3
// * @since 08-06-2020 */
//import biuoop.DrawSurface;
//import biuoop.KeyboardSensor;
//import interfaces.Animation;
//import java.awt.Color;
///**
// * class PauseScreen.
// * animation that will pause the game. */
//public class PauseScreen implements Animation {
//    private KeyboardSensor keyboard;
//    private boolean stop;
//    /**
//     * constructor.
//     * @param k - the keyboard for the game. */
//    public PauseScreen(KeyboardSensor k) {
//        this.keyboard = k;
//        this.stop = false;
//    }
//    /**
//     * the method will draw the message on the given DrawSurface.
//     * @param d - the surface of the game. */
//    public void doOneFrame(DrawSurface d) {
//        d.setColor(Color.BLUE);
//        d.fillRectangle(0, 0, 800, 600);
//        d.setColor(Color.red);
//        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 50);
//    }
//    /**
//     * the method will return if we should stop the animation or not using boolean variable.
//     * @return - true if we should stop the animation, false otherwise . */
//    public boolean shouldStop() {
//        return this.stop; }
//}

package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import java.awt.Color;
/**
 * class PauseScreen.
 * animation that will pause the game. */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * constructor.
     * @param k - the keyboard for the game. */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * the method will draw the message on the given DrawSurface.
     * @param d - the surface of the game. */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLUE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.red);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 50);
        d.setColor(Color.yellow);
        d.drawText(250, 500, "press q for exit game", 30);
        if (keyboard.isPressed("q")) {
            System.exit(1);
        }
    }
    /**
     * the method will return if we should stop the animation or not using boolean variable.
     * @return - true if we should stop the animation, false otherwise . */
    public boolean shouldStop() {
        return this.stop; }
}