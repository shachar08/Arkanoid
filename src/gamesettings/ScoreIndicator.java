package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 24-05-2020. */
import biuoop.DrawSurface;
import geometry.Rectangle;
import interfaces.Sprite;
import java.awt.Color;

/**
 * class ScoreIndicator.
 * indicates the score of the player. */
public class ScoreIndicator implements Sprite {
    private Color color;
    private Rectangle rect;
    private Counter scoreCounter;
    /**
     * constructor.
     * @param rect - the rectangle that the score will be draw on.
     * @param color - the color of the rectangle that the score will be draw on.
     * @param scoreCounter - the score counter of the player in the game. */
    public ScoreIndicator(Rectangle rect, Color color, Counter scoreCounter) {
        this.rect = rect;
        this.color = color;
        this.scoreCounter = scoreCounter;
    }
    /**
     * the method will draw the object on the given DrawSurface.
     * @param d - the surface of the game. */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(Color.black);
        d.drawText(380, 13, "score: " + scoreCounter.getValue(), 15);
    }
    /**
     * the method notify the block that time has passed - we didn't implement this method in this assignment. */
    public void timePassed() {
    }
    /**
     * the method will add the object to the game.
     * @param g - the game the object will be added to. */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
