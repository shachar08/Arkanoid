package interfaces;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */
import geometry.Ball;
import geometry.Block;
/**
 * interface HitListener.
 * Objects that want to be notified of hit events, should implement the HitListener */
public interface HitListener {
    /**
     * The method is called whenever the beingHit object is hit.The hitter parameter is the Ball that is doing
     * the hitting.
     * @param beingHit - the block that the ball hits.
     * @param hitter - the ball that was hitting the block. */
    void hitEvent(Block beingHit, Ball hitter);
}
