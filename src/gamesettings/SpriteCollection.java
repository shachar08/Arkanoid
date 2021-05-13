package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 28-04-2020
 */
import biuoop.DrawSurface;
import interfaces.Sprite;
import java.util.ArrayList;
import java.util.Collection;
/**
 * class CollisionInfo.
 * will hold a collection of sprites. */
public class SpriteCollection {
    private Collection<Sprite> sprites;
    /**
     * constructor.
     * initialize new array list for the collection of all the sprite object. */
    public SpriteCollection() {
        sprites = new ArrayList<>();
    }

    /**
     * the method add a sprite item to the sprites array list.
     * @param s - the sprite item that the method will add to the sprites array list. */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * the method will call the method timePassed() on all sprite objects in the sprites array list. */
    public void notifyAllTimePassed() {
        Collection<Sprite> spr = new ArrayList<>(this.sprites); // copy of the sprites
                                                                // before iterating over them.
        for (Sprite s : spr) {
            s.timePassed();
        }
    }

    /**
     * the method will call the method drawOn(d) on all sprite objects in the sprites array list.
     * @param d - the DrawSurface the method received. will draw the sprite object with it. */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
    /**
     * the method removes a sprite item to the sprites array list.
     * @param s - the sprite item that the method will remove from the sprites array list. */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }
}