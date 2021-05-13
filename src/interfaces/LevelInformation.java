package interfaces;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import geometry.Block;
import geometry.Velocity;
import java.util.List;
/**
 * interface LevelInformation.
 * specifies the information required to fully describe a level. */
public interface LevelInformation {
    /**
     * the method will return the number of ball that will be played in the start of a turn in the level.
     * @return - number of balls. */
    int numberOfBalls();
    /**
     * the method will put in list and return the initial velocity of each ball.
     * @return - list of the the initial velocity of each ball. */
    List<Velocity> initialBallVelocities();
    /**
     * the method will return the paddle speed.
     * @return - the paddle speed. */
    int paddleSpeed();
    /**
     * the method will return the paddle width.
     * @return - the paddle width. */
    int paddleWidth();
    /**
     * the method will return the level name that will be displayed at the top of the screen.
     * @return - the level name. */
    String levelName();
    /**
     * the method will return a sprite with the background of the level.
     * @return - a sprite with the background of the level. */
    Sprite getBackground();
    /**
     * the method will put in list the blocks that make up this level and return the list.
     * @return - list of the ist the blocks that make up this level. */
    java.util.List<Block> blocks();
    /**
     * the method returns of the number of blocks that should be removed before the level is considered to be "cleared".
     * @return - the number of blocks that should be removed before the level is considered to be "cleared". */
    int numberOfBlocksToRemove();
}