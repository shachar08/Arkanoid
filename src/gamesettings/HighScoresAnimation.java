package gamesettings;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
import java.awt.Color;

public class HighScoresAnimation implements Animation {
    private int score;
    private boolean stop;
    private KeyboardSensor keyboardSensor;
    public HighScoresAnimation(int score) {
        this.score = score;
        this.stop = false;
        this.keyboardSensor = keyboardSensor;
    }

    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.RED);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLUE.darker());
        d.drawText(50, 200, "The highest score so far is: " + score, 30);
        d.setColor(Color.yellow);
        d.drawText(250, 550, "press SPACE to return to the MENU", 20);
    }

    public boolean shouldStop() {
        return this.stop; }
}
