package levels;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import gamesettings.LevelsSpriteBackground;
import interfaces.LevelInformation;
import geometry.Block;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Sprite;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
/**
 * class ThirdLevel.
 * specifies the information required to fully describe the level. */
public class ThirdLevel implements LevelInformation {
    /**
     * the method will return the number of ball that will be played in the start of a turn in the level.
     * @return - number of balls. */
    public int numberOfBalls() {
        return 50;
    }
    /**
     * the method will put in list and return the initial velocity of each ball.
     * @return - list of the the initial velocity of each ball. */
    public List<Velocity> initialBallVelocities() {
        Random random = new Random();
        List<Integer> angles = new ArrayList<>(); // create list of different angels for the balls velocity
        for (int i = 0; i < numberOfBalls(); i++) {
            int angle = random.nextInt(120) - 60; // randomise an angle
            if (!angles.contains(angle)) {
                angles.add(angle);
            } else {
                i--;
            }
        }
        List<Velocity> arr = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            arr.add(Velocity.fromAngleAndSpeed(angles.get(i), 8));
        }
        return arr;
    }
    /**
     * the method will return the paddle speed.
     * @return - the paddle speed. */
    public int paddleSpeed() {
        return 10;
    }
    /**
     * the method will return the paddle width.
     * @return - the paddle width. */
    public int paddleWidth() {
        return 100;
    }
    /**
     * the method will return the level name that will be displayed at the top of the screen.
     * @return - the level name. */
    public String levelName() {
        return "Green 3";
    }
    /**
     * the method will return a sprite with the background of the level.
     * @return - a sprite with the background of the level. */
    public Sprite getBackground() {
        return new LevelsSpriteBackground(levelName());
    }
    /**
     * the method will put in list the blocks that make up this level and return the list.
     * @return - list of the ist the blocks that make up this level. */
    public java.util.List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] arr = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
        Point p = new Point(730, 150);
        for (int i = 0; i < 5; i++) { // create all the other blocks for the game
            for (int j = i; j < 10; j++) {
                blocks.add(new Block(new Rectangle(new Point(p.getX(), p.getY()), 50, 25), arr[i]));
                p = new Point(p.getX() - 50, p.getY());
            }
            p = new Point(730, p.getY() + 25);
        }
        return blocks;
    }
    /**
     * the method returns of the number of blocks that should be removed before the level is considered to be "cleared".
     * @return - the number of blocks that should be removed before the level is considered to be "cleared". */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}































