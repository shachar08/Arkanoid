package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.DrawSurface;
import geometry.Point;
import interfaces.Sprite;
import java.awt.Color;
/**
 * class LevelsSpriteBackground.
 * will create the backgrounds for the levels */
public class LevelsSpriteBackground implements Sprite {
    private String levelname;
    private int cloud1locationx = 620;
    private int cloud1locationy = 500;
    private int cloud2locationx = 150;
    private int cloud2locationy = 400;
    /**
     * constructor.
     * @param levelname - the name of the level. */
    public LevelsSpriteBackground(String levelname) {
        this.levelname = levelname;
    }
    /**
     * the method call the method of drawing level background according to the name of the level.
     * @param d - the surface of the game. */
    public void drawOn(DrawSurface d) {
        if (levelname.equals("Direct Hit")) {
            getBackgroundSprites1(d);
        }
        if (levelname.equals("Wide Easy")) {
            getBackgroundSprites2(d);
        }
        if (levelname.equals("Green 3")) {
            getBackgroundSprites3(d);
        }
        if (levelname.equals("Final Four")) {
            getBackgroundSprites4(d);
        }
    }
    /**
     * the method will draw the background of the first level on the given DrawSurface.
     * @param d - the surface of the level. */
    public void getBackgroundSprites1(DrawSurface d) {
        d.setColor(new Color(0x070707));
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(620, 13, "Level Name: " + levelname, 13);
        d.setColor(Color.BLUE);
        d.drawCircle(415, 115, 100);
        d.drawCircle(415, 115, 70);
        d.drawCircle(415, 115, 40);
        d.drawLine(390, 115, 280, 115);
        d.drawLine(440, 115, 550, 115);
        d.drawLine(415, 140, 415, 250);
        d.drawLine(415, 90, 415, 25);
    }
    /**
     * the method will draw the background of the second level on the given DrawSurface.
     * @param d - the surface of the level. */
    public void getBackgroundSprites2(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(620, 13, "Level Name: " + levelname, 13);
        d.setColor(new Color(0xD4D333));
        int p = 30;
        for (int i = 0; i < 100; i++) {
            d.drawLine(100, 130, p, 220);
            p = p + 6;
        }
        d.setColor(new Color(0xF6EDBB));
        d.fillCircle(100, 130, 60);
        d.setColor(new Color(0xE8E782));
        d.fillCircle(100, 130, 50);
        d.setColor(new Color(0xD4D333));
        d.fillCircle(100, 130, 40);
    }
    /**
     * the method will draw the background of the third level on the given DrawSurface.
     * @param d - the surface of the level. */
    public void getBackgroundSprites3(DrawSurface d) {
        d.setColor(new Color(0x256C16));
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(620, 13, "Level Name: " + levelname, 13);
        d.fillRectangle(50, 450, 100, 150);
        d.setColor(Color.GRAY);
        d.fillRectangle(85, 400, 30, 50);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(95, 250, 10, 150);
        d.setColor(Color.ORANGE);
        d.fillCircle(100, 240, 10);
        d.setColor(Color.RED);
        d.fillCircle(100, 240, 7);
        d.setColor(Color.WHITE);
        d.fillCircle(100, 240, 3);
        Point p = new Point(56, 453);
        for (int i = 0; i < 5; i++) { // create all the other blocks for the game
            for (int j = 0; j < 5; j++) {
                d.setColor(Color.LIGHT_GRAY);
                d.fillRectangle((int) p.getX(), (int) p.getY(), 10, 23);
                p = new Point(p.getX() + 20, p.getY());
            }
            p = new Point(56, p.getY() + 30);
        }
    }
    /**
     * the method will draw the background of the fourth level on the given DrawSurface.
     * @param d - the surface of the level. */
    public void getBackgroundSprites4(DrawSurface d) {
        d.setColor(new Color(0x149CDB));
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(620, 13, "Level Name: " + levelname, 13);
        int x1 = cloud1locationx - 70;
        d.setColor(new Color(0xFAF0F0));
        for (int i = 0; i < 10; i++) {
            d.drawLine(x1, cloud1locationy - 10, x1 - 20, d.getHeight());
            x1 = x1 + 10;
        }
        int x2 = cloud2locationx - 70;
        d.setColor(new Color(0xFAF0F0));
        for (int i = 0; i < 10; i++) {
            d.drawLine(x2, cloud2locationy - 10, x2 - 25, d.getHeight());
            x2 = x2 + 10;
        }
        d.setColor(new Color(0xB4B3B3));
        d.fillCircle(cloud1locationx, cloud1locationy, 25);
        d.setColor(new Color(0xE3F6F6));
        d.fillCircle(cloud1locationx - 50, cloud1locationy - 20, 25);
        d.setColor(new Color(0xD5D5CB));
        d.fillCircle(cloud1locationx - 10, cloud1locationy - 10, 25);
        d.setColor(new Color(0xFAF0F0));
        d.fillCircle(cloud1locationx - 50, cloud1locationy + 5, 25);
        d.setColor(new Color(0xE3E3DA));
        d.fillCircle(cloud1locationx - 30, cloud1locationy, 25);
        d.setColor(new Color(0xB4B3B3));
        d.fillCircle(cloud2locationx, cloud2locationy, 25);
        d.setColor(new Color(0xE3F6F6));
        d.fillCircle(cloud2locationx - 50, cloud2locationy - 20, 25);
        d.setColor(new Color(0xD5D5CB));
        d.fillCircle(cloud2locationx - 10, cloud2locationy - 10, 25);
        d.setColor(new Color(0xFAF0F0));
        d.fillCircle(cloud2locationx - 50, cloud2locationy + 5, 25);
        d.setColor(new Color(0xE3E3DA));
        d.fillCircle(cloud2locationx - 30, cloud2locationy, 25);
    }
    /**
     * the method notify the block that time has passed - I didn't implement this method in this assignment. */
    public void timePassed() {

    }
    /**
     * the method will add the object to the game - I didn't implement this method in this assignment.
     * @param g - the game the object will be added to. */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
