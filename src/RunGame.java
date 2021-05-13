/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.KeyboardSensor;
import gamesettings.*;
import interfaces.LevelInformation;
import interfaces.Menu;
import interfaces.Task;
import levels.*;

import java.util.ArrayList;
import java.util.List;
/**
 * class Ass6Game.
 * will run the whole game. */
public class RunGame {
    public static final int STARTING_LIVE = 5;
    /**
     * the method will run the whole game.
     * @param args - can get the levels the player will play. */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        AnimationRunner runner = new AnimationRunner();
        Counter lives = new Counter();
        lives.increase(STARTING_LIVE);
        KeyboardSensor keyboardSensor = runner.getKeyboard();
        LevelInformation lil1 = new FirstLevel();
        LevelInformation lil2 = new SecondLevel();
        LevelInformation lil3 = new ThirdLevel();
        LevelInformation lil4 = new FourthLevel();
        for (int i = 0; i < args.length; i++) {
            if (!args[i].equals("1") && !args[i].equals("2") && !args[i].equals("3") && !args[i].equals("4")) {
                continue;
            }
            if (args[i].equals("1")) {
                levels.add(lil1); // add the first level to the levels list
            }
            if (args[i].equals("2")) {
                levels.add(lil2); // add the second level to the levels list
            }
            if (args[i].equals("3")) {
                levels.add(lil3); // add the third level to the levels list
            }
            if (args[i].equals("4")) {
                levels.add(lil4); // add the fourth level to the levels list
            }
        }
        if (levels.isEmpty()) { // if we didn't get correct levels in args
            levels.add(lil1); // add the first level to the levels list
            levels.add(lil2); // add the second level to the levels list
            levels.add(lil3); // add the third level to the levels list
            levels.add(lil4); // add the fourth level to the levels list
        }
//        GameFlow gw = new GameFlow(runner, keyboardSensor, lives);
//        gw.runLevels(levels);

        HighScoreFile hss = new HighScoreFile(0);
        while (true) {
            Menu<Task<Void>> m = new MenuAnimation<Task<Void>>(keyboardSensor);
            HighScoresAnimation hsa = new HighScoresAnimation(hss.getHighestScore());
            m.addSelection("s", "if you want to play press:                                    ", new Task<Void>() {
                @Override
                public Void run() {
                    GameFlow gw = new GameFlow(runner, keyboardSensor, lives, levels, STARTING_LIVE);
                    gw.runLevels();
                    return null;
                }
            });
            m.addSelection("q", "if you want to quit press:                                    ", new Task<Void>() {
                @Override
                public Void run() {
                    System.exit(0);
                    return null;
                }
            });
            m.addSelection("h", "if you want to see your highest score press:       ", new ShowHiScoresTask
                    (runner, new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, hsa)));
            runner.run(m);
            Task<Void> task = m.getStatus();
            task.run();
        }
    }
}
