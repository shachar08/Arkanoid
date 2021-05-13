package geometry;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020. */
import biuoop.DrawSurface;
import gamesettings.GameLevel;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class Block.
 * creates a block from rectangle and color. */
public class Block implements Collidable, Sprite, HitNotifier {
    private Color color;
    private Rectangle rect;
    private List<HitListener> hitListeners;
    /**
     * constructor.
     * @param rect - the rectangle we will create the block from.
     * @param color - the color the block will be. */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        hitListeners = new ArrayList<>();
    }

    /**
     * The method return the collision rectangle.
     * @return - the collision rectangle . */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * The method receives the collision point and the current velocity until the collision occurs and returning the
     * matching velocity according to the rectangle side the collision point occurs and notify that there was hit.
     * @param collisionPoint - the point the collision will occur.
     * @param currentVelocity - the velocity until the collision will occur.
     * @param hitter - the ball that was hitting the block.
     * @return - the velocity after the collision occurs. */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line line = new Line(collisionPoint, collisionPoint);
        if (line.isIntersecting(rect.rectangleLines().get(0))) { // index 0 is up line
            if (collisionPoint.getY() <= line.intersectionWith(rect.rectangleLines().get(0)).getY()) {
                currentVelocity.setDy(-currentVelocity.getDy());
                this.notifyHit(hitter);
            }
        }
        if (line.isIntersecting(rect.rectangleLines().get(1))) { // index 1 is down line
            if (collisionPoint.getY() >= line.intersectionWith(rect.rectangleLines().get(1)).getY()) {
                currentVelocity.setDy(-currentVelocity.getDy());
                this.notifyHit(hitter);
            }
        }
        if (line.isIntersecting(rect.rectangleLines().get(2))) { // index 2 is left line
            if (collisionPoint.getX() <= line.intersectionWith(rect.rectangleLines().get(2)).getX()) {
                currentVelocity.setDx(-currentVelocity.getDx());
                this.notifyHit(hitter);
            }
        }
        if (line.isIntersecting(rect.rectangleLines().get(3))) { // index 3 is right line
            if (collisionPoint.getX() >= line.intersectionWith(rect.rectangleLines().get(3)).getX()) {
                currentVelocity.setDx(-currentVelocity.getDx());
                this.notifyHit(hitter);
            }
        }
        return currentVelocity;
    }

    /**
     * the method will draw the block on the given DrawSurface.
     * @param d - the DrawSurface the method received. will draw the block with it. */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        if (this.rect.getWidth() < 300 && this.rect.getHeight() < 300) {
            d.setColor(Color.black);
        }
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * the method notify the block that time has passed - we didn't implement this method in this assignment. */
    public void timePassed() {
    }
    /**
     * the method will add the block to the game.
     * @param g - the game the block will be added to. */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
    /**
     * the method will remove the block from the game.
     * @param game - the game the block will be removed from. */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
    /**
     * the method add a hitListener item to the hitListeners array list for hit events.
     * @param hl - the hitListener item that the method will add to the hitListeners array list. */
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }
    /**
     * the method remove a hitListener item to the hitListeners array list for hit events.
     * @param hl - the hitListener item that the method will remove from the hitListeners array list. */
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
    /**
     * the method is called whenever the beingHit object is hit and call the method hitEvent about the hit.
     * @param hitter - the Ball that is doing the hitting. */
    public void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners); // copy of the hitListeners
                                                                        // before iterating over them.
        for (HitListener hl : listeners) {
            if (!listeners.contains(hl)) {
                addHitListener(hl);
            }
            hl.hitEvent(this, hitter); // there was a hit in this block with the hitter ball
        }
    }
}
