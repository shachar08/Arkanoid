package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 24-05-2020. */
import geometry.Ball;
import geometry.Block;
import interfaces.HitListener;
/**
 * class BallRemover.
 * will remove balls that got out of the screen bounds. */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * constructor.
     * @param game - the game that the balls will remove from.
     * @param removedBalls - i will use it as remaining balls. */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }
    /**
     * The method is called whenever the "death" object is hit.The hitter parameter is the Ball that is doing
     * the hitting and will remove that ball from the game.
     * @param beingHit - the block that the ball hits.
     * @param hitter - the ball that was hitting the block. */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);
    }
}
