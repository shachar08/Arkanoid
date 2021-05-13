package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */

import geometry.Line;
import geometry.Point;
import interfaces.Collidable;
import java.util.ArrayList;
import java.util.List;

/**
 * class GameEnvironment.
 * will hold a list of Collidable objects. */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor.
     * initialize new array list for the collidables object. */
    public GameEnvironment() {
        collidables = new ArrayList<>();
    }

    /**
     * the method add a colliidable item to the colliadables array list (to the game environment).
     * @param c - the colliidable item that the method will add to the colliadables array list. */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * The method search for the closest intersection point to the start point of line trajectory and returns this
     * intersection point and the colliadable object of this intersection point.
     * @param trajectory - the line that we will check it's intersection points with the rectangles.
     * @return - collisionInfo that will have information about the closest intersection point to the start point of
     * line trajectory with the closest collidable object to the start of trajectory and also have that collidable
     * object if there is intersection. null otherwise. */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestPoint = null;
        Collidable temp = null;
        for (Collidable c : collidables) {
            if (!c.getCollisionRectangle().intersectionPoints(trajectory).isEmpty()) {
                Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
                if (closestPoint == null) { // first assigning
                    closestPoint = p;
                    temp = c;
                }
                if (trajectory.start().distance(p) < trajectory.start().distance(closestPoint)) { //compare distance
                    closestPoint = p;
                    temp = c;
                }
            }
        }
        if (closestPoint != null) { // there was intersection
            return new CollisionInfo(closestPoint, temp);
        }
        return null;
    }
    /**
     * the method removes a colliidable item from the colliadables array list (to the game environment).
     * @param c - the colliidable item that the method will remove from the colliadables array list. */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }
}