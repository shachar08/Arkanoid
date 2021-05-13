package interfaces;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */

import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

/**
 * interface Collidable.
 * will be used by things that can be collided with. */
public interface Collidable {
    /**
     * The method return the collision shape of the object.
     * @return  @return - the collision rectangle . */
    Rectangle getCollisionRectangle();

    /**
     * The method receives the collision point and the current velocity until the collision occurs and returning the
     * matching velocity according to the collision shape side the collision point occurs and notify that there was hit.
     * @param collisionPoint - the point the collision will occur.
     * @param currentVelocity - the velocity until the collision will occur.
     * @param hitter - the ball that was hitting the block.
     * @return - the velocity after the collision occurs.*/
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
