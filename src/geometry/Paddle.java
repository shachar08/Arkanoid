package geometry;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gamesettings.GameLevel;
import interfaces.Collidable;
import interfaces.Sprite;
import java.awt.Color;

/**
 * class Paddle.
 * creates a paddle from rectangle, color and the keyboard sensor. */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Color color;
    private Rectangle rect;
    private double paddleSpeed;
    /**
     * constructor.
     * @param rect - the rectangle we will create the paddle from.
     * @param color - the color the paddle will be.
     * @param paddleSpeed - the speed that the paddle the paddle will move.
     * @param keyboard - the keyboard the paddle will be controlled by. */
    public Paddle(Rectangle rect, Color color, KeyboardSensor keyboard, double paddleSpeed) {
        this.rect = rect;
        this.color = color;
        this.keyboard = keyboard;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * the method will recreate the paddle a little lefter from the current place of the paddle. */
    public void moveLeft() {
        double movement = paddleSpeed;
        if (rect.getUpperLeft().getX() >= 20 + movement) { // so the paddle won't get out of bounds
            keyboard.isPressed("the 'left arrow' key is pressed");
            rect = new Rectangle(new Point(rect.getUpperLeft().getX() - movement, rect.getUpperLeft().getY()),
                    rect.getWidth(), rect.getHeight()); // recreate the rectangle paddle
        }
    }

    /**
     * the method will recreate the paddle a little righter from the current place of the paddle. */
    public void moveRight() {
        double movement = paddleSpeed;
        if (rect.getUpperRight().getX() <= 780 - movement) { // so the paddle won't get out of bounds
            keyboard.isPressed("the 'right arrow' key is pressed");
            this.rect = new Rectangle(new Point(rect.getUpperLeft().getX() + movement, rect.getUpperLeft().getY()),
                    rect.getWidth(), rect.getHeight()); // recreate the rectangle paddle
        }
    }

    /**
     * the method notify the paddle that time has passed and will check if the "left" or "right" keys are pressed,
     * and if so move it accordingly by using the methods moveLeft() and moveRight(). */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) || keyboard.isPressed("A") || keyboard.isPressed("a")) {
            //System.out.println("the 'left arrow' key is pressed");
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) || keyboard.isPressed("D") || keyboard.isPressed("d")) {
            //System.out.println("the 'right arrow' key is pressed");
            moveRight();
        }
    }

    /**
     * the method will draw the paddle on the given DrawSurface.
     * @param d - the DrawSurface the method received. will draw the paddle with it. */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * The method return the collision rectangle.
     * @return - the collision rectangle . */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * The method receives the collision point and the current velocity until the collision occurs and returning the
     * matching velocity according to the rectangle side and location the collision point occurs and notify
     * that there was hit.
     * @param collisionPoint - the point the collision will occur.
     * @param currentVelocity - the velocity until the collision will occur.
     * @param hitter - the ball that was hitting the block.
     * @return - the velocity after the collision occurs. */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double w = rect.getWidth() / 5; // divide the rectangle to 5 parts of even rectangles
        double x = rect.getUpperLeft().getX();
        double y = rect.getUpperLeft().getY();
        Rectangle r1 = new Rectangle(rect.getUpperLeft(), w, rect.getHeight()); // first part of rectangle (the lefter)
        Rectangle r2 = new Rectangle(new Point(x + w, y), w, rect.getHeight()); // second part of rectangle
        Rectangle r3 = new Rectangle(new Point(x + (2 * w), y), w, rect.getHeight()); // third part of rectangle
        Rectangle r4 = new Rectangle(new Point(x + (3 * w), y), w, rect.getHeight()); // fourth part of rectangle
        Rectangle r5 = new Rectangle(new Point(x + (4 * w), y), w, rect.getHeight()); // fifth part of rectangle
        Line line = new Line(collisionPoint, collisionPoint);
        if (line.isIntersecting(rect.rectangleLines().get(2))) { // the left line of the rectangle
            if (collisionPoint.getX() <= line.intersectionWith(rect.rectangleLines().get(2)).getX()) {
                currentVelocity.setDx(-currentVelocity.getDx());
            }
        }
        if (line.isIntersecting(rect.rectangleLines().get(3))) { // the right line of the rectangle
            if (collisionPoint.getX() >= line.intersectionWith(rect.rectangleLines().get(3)).getX()) {
                currentVelocity.setDx(-currentVelocity.getDx());
            }
        }
        if (line.isIntersecting(r1.rectangleLines().get(0))) { // index 0 is the up line of the first part of rectangle
            if (collisionPoint.getY() <= line.intersectionWith(r1.rectangleLines().get(0)).getY()) {
                currentVelocity = Velocity.fromAngleAndSpeed(-60, 8);
            }
        }
        if (line.isIntersecting(r2.rectangleLines().get(0))) { //index 0 is the up line of the second part of rectangle
            if (collisionPoint.getY() <= line.intersectionWith(r2.rectangleLines().get(0)).getY()) {
                currentVelocity = Velocity.fromAngleAndSpeed(-30, 8);
            }
        }
        if (line.isIntersecting(r3.rectangleLines().get(0))) { // index 0 is the up line of the third part of rectangle
            if (collisionPoint.getY() <= line.intersectionWith(r3.rectangleLines().get(0)).getY()) {
                currentVelocity.setDy(-currentVelocity.getDy());
            }
        }
        if (line.isIntersecting(r4.rectangleLines().get(0))) { //index 0 is the up line of the fourth part of rectangle
            if (collisionPoint.getY() <= line.intersectionWith(r4.rectangleLines().get(0)).getY()) {
                currentVelocity = Velocity.fromAngleAndSpeed(30, 8);
            }
        }
        if (line.isIntersecting(r5.rectangleLines().get(0))) { // index 0 is the up line of the fifth part of rectangle
            if (collisionPoint.getY() <= line.intersectionWith(r5.rectangleLines().get(0)).getY()) {
                currentVelocity = Velocity.fromAngleAndSpeed(60, 8);
            }
        }
        return currentVelocity;
    }

    /**
     * the method will add the paddle to the game.
     * @param g - the game the paddle will be added to. */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * the method will remove the paddle from the game.
     * @param game - the game the paddle will be removed from. */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
}