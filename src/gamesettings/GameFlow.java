//package gamesettings;
///**
// * @author Shachar Korall.
// * ID: 208486191
// * @version IntelliJ IDEA 2019.3.3
// * @since 08-06-2020 */
//import biuoop.KeyboardSensor;
//import interfaces.LevelInformation;
//import java.util.List;
///**
// * class GameFlow.
// * will be in charge of creating the different levels, and moving from one level to the next. */
//public class GameFlow {
//    private AnimationRunner ar;
//    private KeyboardSensor ks;
//    private Counter li;
//    private Counter sc;
//    /**
//     * constructor.
//     * @param ar - the animation the game runs.
//     * @param ks - the keyboard for the game.
//     * @param li - counter of lives of the player. */
//    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter li) {
//        this.ar = ar;
//        this.ks = ks;
//        this.li = li;
//        this.sc = new Counter();
//    }
//    /**
//     * the method runs all the level in the levels list one by one until we lose or end and win the game.
//     * @param levels - the list of levels of the game. */
//    public void runLevels(List<LevelInformation> levels) {
//        for (LevelInformation levelInfo : levels) {
//            GameLevel level = new GameLevel(levelInfo, ar, ks, li, sc);
//            level.initialize();
//            while (levelInfo.numberOfBlocksToRemove() > 0 && li.getValue() > 0) {
//                level.playOneTurn();
//                break;
//            }
//            if (li.getValue() == 0) {
//                break;
//            }
//        }
//        ar.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY, new EndScreen(ks, "WIN", sc))); // if
//        // we got out from the for loop and still in the game that means we won the game.
//        ar.getGui().close();
//    }
//}











package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import java.util.List;
/**
 * class GameFlow.
 * will be in charge of creating the different levels, and moving from one level to the next. */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter li;
    private Counter sc;
    private List<LevelInformation> levels;
    private int startinglives;
    private int flag;
    /**
     * constructor.
     * @param ar - the animation the game runs.
     * @param ks - the keyboard for the game.
     * @param li - counter of lives of the player. */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter li, List<LevelInformation> levels, int sl) {
        this.ar = ar;
        this.ks = ks;
        this.li = li;
        this.sc = new Counter();
        this.levels = levels;
        this.startinglives = sl;
        this.flag = 0; // for starting new game from menu
    }
    /**
     * the method runs all the level in the levels list one by one until we lose or end and win the game.*/
    public void runLevels() {
        resetLive();
        this.sc = new Counter();
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, ar, ks, li, sc);
            level.initialize();
            while (levelInfo.numberOfBlocksToRemove() > 0 && li.getValue() > 0) {
                level.playOneTurn();
                break;
            }
            if (li.getValue() == 0) { // if lose
                HighScoreFile score = new HighScoreFile(sc.getValue());
                HighScoresAnimation hsa = new HighScoresAnimation(score.getHighestScore());
                ar.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY,
                        new EndScreen(ks, "LOSE", sc)));
                ar.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY,
                        hsa));
                //li.increase(startinglives);
                flag = 1;
                break;
            }
        }
        if (flag == 0) { // if win
            resetLive();
            HighScoreFile score = new HighScoreFile(sc.getValue());
            HighScoresAnimation hsa = new HighScoresAnimation(score.getHighestScore());
            ar.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY, new EndScreen(ks, "WIN", sc)));
            ar.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY,
                    hsa));
        }
    }
    public void resetLive() {
        while(li.getValue() < startinglives) {
            li.increase(1);
        }
    }
}
