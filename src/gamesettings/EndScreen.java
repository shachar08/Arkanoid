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
 * class EndScreen.
 * animation that will appear when the game ends. */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private String result;
    private Counter score;
    /**
     * constructor.
     * @param sensor - the keyboard for the game.
     * @param result - string that notify if the player won the game or lost.
     * @param score - the counter of the current score of the player. */
    public EndScreen(KeyboardSensor sensor, String result, Counter score) {
        this.keyboard = sensor;
        this.result = result;
        this.score = score;
    }
    /**
     * the method will draw the message on the given DrawSurface.
     * @param d - the surface of the game. */
    public void doOneFrame(DrawSurface d) {
        if (result.equals("WIN")) {
            d.setColor(Color.BLUE);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.red);
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 50);
        }
        if (result.equals("LOSE")) {
            d.setColor(Color.BLUE);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.red);
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), 50);
        }
    }
    /**
     * the method will return if we should stop the animation or not using boolean variable.
     * @return - true if we should stop the animation, false otherwise . */
    public boolean shouldStop() {
        return this.stop; }
}