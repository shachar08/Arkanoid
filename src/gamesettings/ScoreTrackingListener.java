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
 * class ScoreTrackingListener.
 * update the counter when blocks are being hit. */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * constructor.
     * @param scoreCounter - the score counter of the player in the game. */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * The method is called whenever the beingHit object is hit and adding 5 point to the score of the player.
     * @param beingHit - the block that the ball hits.
     * @param hitter - the ball that was hitting the block. */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}
