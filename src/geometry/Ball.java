package geometry;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */

import biuoop.DrawSurface;
import gamesettings.CollisionInfo;
import gamesettings.GameLevel;
import gamesettings.GameEnvironment;
import interfaces.Sprite;
import java.awt.Color;
/**
 * class Ball.
 * creating a ball and it's movement. */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment ge;
    private static final int MINHEIGHT = 0;
    private static final int MAXHEIGHT = 200;
    private static final int MINWIDTH = 0;
    private static final int MAXWIDTH = 200;

    /**
     * constructor.
     * @param center - the point of the center of the ball.
     * @param r - the size of the radius of the ball.
     * @param color - the color of the ball. */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.ge = null;
    }

    /**
     * constructor.
     * @param x - the x value of the point of the center of the ball.
     * @param y - the y value of the point of the center of the ball.
     * @param r - the size of the radius of the ball.
     * @param color - the color of the ball. */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.ge = null;
    }

    /**
     * The method return the game environment.
     * @return - the game environment. */
    public GameEnvironment getGE() {
        return this.ge;
    }

    /**
     * the method receive a game environment and sets the game environment to the one the method received.
     * @param gen - the game environment the method receives. */
    public void setGE(GameEnvironment gen) {
        this.ge = gen;
    }

    /**
     * The method return the x value (by int) of the center point of the ball.
     * @return - the x (by int) value of the center point. */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * The method return the y value (by int) of the center point of the ball.
     * @return - the y (by int) value of the center point. */
    public int getY() {
        return (int) center.getX();
    }

    /**
     * The method return radius length (by int) of the ball.
     * @return - the radius (by int) of the ball. */
    public int getSize() {
        return (int) r;
    }

    /**
     * The method return the color of the ball.
     * @return - the color of the ball. */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * the method will draw the ball on the given DrawSurface.
     * @param surface - the DrawSurface the method received. will draw the ball with it. */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), r);
        surface.setColor(Color.green);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), r);
    }

    /**
     * the method will set the velocity as the velocity v it received.
     * @param velocity - the velocity the method received. */
    public void setVelocity(Velocity velocity) {
        this.v = velocity;
    }

    /**
     * the method will set the velocity by the variables it received.
     * @param dx - the value of x of the new position of the center point of the ball.
     * @param dy - the value of y of the new position of the center point of the ball. */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * The method return the velocity of the ball.
     * @return - this.v - the velocity of the ball. */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * The method update the center point of the ball to be in the next position (moving the ball one step). */
    public void moveOneStepAss2() {
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * he method update the center point of the ball to be in the next position and set bounds for the ball.
     * <p>
     * The method update the center point of the ball to be in the next position (moving the ball one step) and set
     * bounds for the ball as the size of the screen the GUI created. if the ball gets to the edge of the screen it
     * will turn around and his velocity will be to the opposite direction (will change side of movement).
     * <p>
     * @param d - to know the size of screen the ball will move in. */
    public void moveOneStep(DrawSurface d) {
        double maxX = d.getWidth();
        double maxY = d.getHeight();
        if (this.center.getX() + r > maxX) {
            this.v = new Velocity(-v.getDx(), v.getDy());
        }
        if (this.center.getX() - r < 0) {
            this.v = new Velocity(Math.abs(v.getDx()), v.getDy());
        }
        if (this.center.getY() + r > maxY) {
            this.v = new Velocity(v.getDx(), -v.getDy());
        }
        if (this.center.getY() - r < 0) {
            this.v = new Velocity(v.getDx(), (Math.abs(v.getDy())));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * he method update the center point of the ball to be in the next position and set bounds for the ball.
     * <p>
     * The method update the center point of the ball to be in the next position (moving the ball one step) and set
     * bounds for the ball as the size of the screen the the four variables the function received. if the ball gets
     * to the edge of the screen it will turn around and his velocity will be to the opposite direction (will
     * change side of movement).
     * <p>
     * @param x1 - to know the minimum value of the width of screen the ball will move in.
     * @param x2 - to know the maximum value of the width of screen the ball will move in.
     * @param y1 - to know the minimum value of the height of screen the ball will move in.
     * @param y2 - to know the maximum value of the height of screen the ball will move in. */
    public void moveOneStep(int x1, int x2, int y1, int y2) {
        if (this.center.getX() + r > x2) {
            this.v = new Velocity(-v.getDx(), v.getDy());
        }
        if (this.center.getX() - r < x1) {
            this.v = new Velocity(Math.abs(v.getDx()), v.getDy());
        }
        if (this.center.getY() + r > y2) {
            this.v = new Velocity(v.getDx(), -v.getDy());
        }
        if (this.center.getY() - r < y1) {
            this.v = new Velocity(v.getDx(), (Math.abs(v.getDy())));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * The method update the center point of the ball to be in the next position (moving the ball one step).
     * if the ball hits a collidable item the method will use the method 'hit' for set the right velocity for
     * the next move of the ball according to it's hit. */
    public void moveOneStep() {
        Point start = new Point(center.getX(), center.getY());
        Point end = new Point(center.getX() + v.getDx(), center.getY() + v.getDy());
        Line trajectory = new Line(start, end); // will be the movement line of the ball
        CollisionInfo ci = ge.getClosestCollision(trajectory);
        if (ci == null) { // if there is no collision
            this.center = this.getVelocity().applyToPoint(this.center);
        }
        if (ci != null) { // if there is  collision
            v = ci.collisionObject().hit(this, ci.collisionPoint(), v);
        }
    }
    /**
     * the method will notify the ball that time has passed and move the ball one step. */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * the method will add the ball to the game.
     * @param g - the game the ball will be added to. */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * the method will remove the ball from the game.
     * @param game - the game the ball will be removed from. */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}


