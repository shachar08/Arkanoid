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
 * class BlockRemover.
 * will remove block that were being hit. */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * constructor.
     * @param game - the game that the blocks will remove from.
     * @param removedBlocks - i will use it as remaining blocks. */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * The method is called whenever the beingHit object is hit.The hitter parameter is the Ball that is doing
     * the hitting and will remove that block from the game.
     * @param beingHit - the block that the ball hits.
     * @param hitter - the ball that was hitting the block. */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        beingHit.removeHitListener(this);
        hitter.getGE().removeCollidable(beingHit);
        remainingBlocks.decrease(1);
    }
}