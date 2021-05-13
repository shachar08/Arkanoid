package gamesettings;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Menu;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MenuAnimation<T> implements Menu<T> {
    private KeyboardSensor keyboardSensor;
    private TreeMap<String, T> dictionary;
    private List<String> messages;
    private boolean stop;
    private T option;
    private List<MenuSelection<T>> lll;
    public MenuAnimation (KeyboardSensor keyboardSensor) {
        this.lll = new ArrayList<>();
        this.keyboardSensor = keyboardSensor;
        this.stop = false;
        this.dictionary = new TreeMap<>();
        this.option = null;
        this.messages = new ArrayList<>();
    }

    public void addSelection(String key, String message, T returnVal) {
        this.lll.add(new MenuSelection<T>(key, message, returnVal));
    }

    public T getStatus() {
        return option;
    }
    public void resetMenu() {
        this.stop = false;
    }

    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.blue);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.GREEN);
        d.drawText(200, 150, "Arkanoid", 110);
        int line = 300;
        for (MenuSelection<T> ms : this.lll) {
            d.setColor(Color.RED);
            d.drawText(50, line, ms.getMessage() + ms.getKey(), 30);
            line = line + 100;
            if (keyboardSensor.isPressed(ms.getKey())) {
                this.option = ms.getReturnVal();
                this.stop = true;
            }
        }
    }

    public boolean shouldStop() {
        return this.stop;
    }
}
