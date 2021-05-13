package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 24-05-2020. */
import biuoop.DrawSurface;
import interfaces.Sprite;
import java.awt.Color;
/**
 * class LivesIndicator.
 * indicates the lives that left for the player. */
public class LivesIndicator implements Sprite {
    private Counter countLive;
    /**
     * constructor.
     * @param countLive - the live counter of the player in the game. */
    public LivesIndicator(Counter countLive) {
        this.countLive = countLive;
    }
    /**
     * the method will draw the object on the given DrawSurface.
     * @param d - the surface of the game. */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.red);
        d.drawText(10, 13, "lives: " + countLive.getValue(), 15);
    }
    /**
     * the method will notify the sprite that time has passed and move the ball one step. */
    public void timePassed() {
    }
    /**
     * the method will add the object to the game.
     * @param g - the game the object will be added to. */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
