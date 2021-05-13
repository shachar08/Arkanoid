package levels;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import gamesettings.LevelsSpriteBackground;
import geometry.Block;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
/**
 * class FirstLevel.
 * specifies the information required to fully describe the level. */
public class FirstLevel implements LevelInformation {
    /**
     * the method will return the number of ball that will be played in the start of a turn in the level.
     * @return - number of balls. */
    public int numberOfBalls() {
        return 1;
    }
    /**
     * the method will put in list and return the initial velocity of each ball.
     * @return - list of the the initial velocity of each ball. */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> arr = new ArrayList<>();
        arr.add(Velocity.fromAngleAndSpeed(0, 8));
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
        return "Direct Hit";
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
        Block b = new Block(new Rectangle(new Point(400, 100), 30, 30), Color.red);
        blocks.add(b);
        return blocks;
    }
    /**
     * the method returns of the number of blocks that should be removed before the level is considered to be "cleared".
     * @return - the number of blocks that should be removed before the level is considered to be "cleared". */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}