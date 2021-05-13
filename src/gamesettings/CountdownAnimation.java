package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.DrawSurface;
import biuoop.Sleeper;
import interfaces.Animation;
import java.awt.Color;
/**
 * class CountdownAnimation.
 * animation that will countdown before the turn starts. */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private double temp;
    /**
     * constructor.
     * @param numOfSeconds - the time the countdown will be.
     * @param countFrom - the number the count will start from.
     * @param gameScreen - the sprite collection of the game. */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds * 1000;
        this.temp = countFrom + 1;
        this.stop = false;
    }
    /**
     * the method will draw the countdown message on the given DrawSurface.
     * @param d - the surface of the game. */
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        gameScreen.drawAllOn(d);
        if (countFrom == 3) {
            d.setColor(new Color(196, 7, 238));
            d.drawText(d.getWidth() / 2 + 3, 70, Integer.toString(countFrom), 40);
            d.setColor(Color.GREEN);
            d.drawText(d.getWidth() / 2 - 70, 110, "GET READY", 30);
        }
        if (countFrom == 2) {
            d.setColor(new Color(196, 7, 238));
            d.drawText(d.getWidth() / 2 + 3, 70, Integer.toString(countFrom), 40);
            d.setColor(Color.GREEN);
            d.drawText(d.getWidth() / 2 - 70, 110, "GET READY", 30);
            sleeper.sleepFor(((long) (numOfSeconds / temp)));
        }
        if (countFrom == 1) {
            d.setColor(new Color(196, 7, 238));
            d.drawText(d.getWidth() / 2 + 3, 70, Integer.toString(countFrom), 40);
            d.setColor(Color.GREEN);
            d.drawText(d.getWidth() / 2 - 70, 110, "GET READY", 30);
            sleeper.sleepFor(((long) (numOfSeconds / temp)));
        }
        if (countFrom < 1) {
            d.setColor(new Color(196, 7, 238));
            d.drawText(d.getWidth() / 2 - 22, 90, "GO", 50);
            sleeper.sleepFor(((long) (numOfSeconds / temp)));
        }
        if (countFrom < 0) {
            this.stop = true;
        }
        countFrom--;
    }
    /**
     * the method will return if we should stop the animation or not using boolean variable.
     * @return - true if we should stop the animation, false otherwise . */
    public boolean shouldStop() {
        return this.stop;
    }
}