package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */

import geometry.Point;
import interfaces.Collidable;

/**
 * class CollisionInfo.
 * will have information about the point at which the collision occurs and the collidable object involved in the
 * collision. */
public class CollisionInfo {
    private Point collisionP;
    private Collidable c;

    /**
     * constructor.
     * @param collisionP - the point at which the collision occurs.
     * @param c - the collidable object involved in the collision. */
    public CollisionInfo(Point collisionP, Collidable c) {
        this.collisionP = collisionP;
        this.c = c;
    }

    /**
     * The method return the point at which the collision occurs.
     * @return - the point at which the collision occurs. */
    public Point collisionPoint() {
        return collisionP;
    }

    /**
     * The method return the collidable object involved in the collision.
     * @return - tthe collidable object involved in the collision */
    public Collidable collisionObject() {
        return c;
    }
}