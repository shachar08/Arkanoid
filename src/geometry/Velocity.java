package geometry;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 06-04-2020
 */

/**
 * class Velocity.
 * to know what will be the ball position in the next step */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     * @param dx - the new value (destination) of x of the center point of the ball after one step.
     * @param dy - the new value (destination) of y of the center point of the ball after one step. */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The method return the new value (destination) of x of the center point of the ball after one step.
     * @return -  dx -the new value (destination) of x of the center point of the ball after one step. */
    public double getDx() {
        return dx;
    }

    /**
     * The method return the new value (destination) of y of the center point of the ball after one step.
     * @return -  dy -the new value (destination) of y of the center point of the ball after one step. */
    public double getDy() {
        return dy;
    }

    /**
     * The method sets a new dx value for the velocity.
     * @param newDx - the dx value of the updated velocity */
    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     * The method sets a new dy value for the velocity.
     * @param newDy - the dy value of the updated velocity */
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /**
     * The method takes a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p - the point of the ball that the method will change it's position in the next step;
     * @return - new point with position (x+dx, y+dy).  */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * the method receives angle and speed and return the Velocity(dx, dy) .
     * <p>
     * The method receives angle and speed and by them and by calculate with sin and cos it's finds
     * the Velocity(dx, dy) (the position of the center of the ball in the next step)
     * <p>
     * @param angle - the direction that the ball moves.
     * @param speed - the speed that the ball moves.
     * @return - Velocity(dx, dy). */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radAngle = Math.toRadians(angle);
        double dx = speed * Math.sin(radAngle);
        double dy = speed * Math.cos(radAngle) * -1;
        return new Velocity(dx, dy);
    }
}