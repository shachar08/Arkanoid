//package gamesettings;
///**
// * @author Shachar Korall.
// * ID: 208486191
// * @version IntelliJ IDEA 2019.3.3
// * @since 08-06-2020 */
//import biuoop.DrawSurface;
//import biuoop.KeyboardSensor;
//import geometry.Block;
//import geometry.Rectangle;
//import geometry.Point;
//import geometry.Paddle;
//import geometry.Ball;
//import interfaces.Animation;
//import interfaces.Collidable;
//import interfaces.LevelInformation;
//import interfaces.Sprite;
//import java.awt.Color;
///**
// * class GameLevel.
// * hold the sprites and the collidables, and will be in charge of the animation of the level. */
//public class GameLevel implements Animation {
//    private SpriteCollection sprites;
//    private GameEnvironment environment;
//    private Counter countBlock;
//    private Counter countBall;
//    private Counter currentScore;
//    private Counter countLive;
//    private Paddle paddle;
//    private AnimationRunner runner;
//    private boolean running;
//    private LevelInformation levelInformation;
//    private KeyboardSensor keyboardSensor;
//    private int flag = 1;
//    private int exit;
//    /**
//     * constructor.
//     * @param li - the information of the level.
//     * @param runner - the animation the game runs.
//     * @param keyboard - the keyboard for the game.
//     * @param cl - counter of lives of the player.
//     * @param cs - the counter of the score of the player. */
//    public GameLevel(LevelInformation li, AnimationRunner runner, KeyboardSensor keyboard, Counter cl, Counter cs) {
//        this.sprites = new SpriteCollection();
//        this.environment = new GameEnvironment();
//        this.countBlock = new Counter();
//        this.countBall = new Counter();
//        this.currentScore = cs;
//        this.countLive = cl;
//        this.runner = runner;
//        this.running = true;
//        this.levelInformation = li;
//        this.keyboardSensor = keyboard;
//        this.exit = 0;
//    }
//    /**
//     * the method add a colliidable item to the colliadables array list (to the game environment).
//     * @param c - the colliidable item that the method will add to the colliadables array list. */
//    public void addCollidable(Collidable c) {
//        environment.addCollidable(c);
//    }
//    /**
//     * the method add a sprite item to the sprites array list.
//     * @param s - the sprite item that the method will add to the sprites array list. */
//    public void addSprite(Sprite s) {
//        sprites.addSprite(s);
//    }
//    /**
//     * the method creates a ball and add it to the game.
//     * @param x - the x value of the center point of the ball.
//     * @param y - the y value of the center point of the ball.
//     * @param r - the radius of the ball.
//     * @param c - the color of the ball
//     * @param g - the game environment of the ball.
//     * @param bl - add hit listener to the ball if hits death block.
//     * @return - the created ball. */
//    public Ball createBall(double x, double y, int r, Color c, GameEnvironment g, BallRemover bl) {
//        Ball b = new Ball(new Point(x, y), r, c);
//        b.setVelocity(levelInformation.initialBallVelocities().get(0));
//        b.setGE(g);
//        b.addToGame(this);
//        b.moveOneStep();
//        Block death = new Block(new Rectangle(new Point(20, 600), 760, 1), Color.GRAY);
//        b.getGE().addCollidable(death);
//        death.addHitListener(bl);
//        countBall.increase(1);
//        return b;
//    }
//    /**
//     * the method creates the border blocks, add it to the game and update the balls in the game to "know"
//     * it is collidable.
//     * @param x - the x value of the upper left point of the block.
//     * @param y - the y value of the upper left point of the block.
//     * @param w - the width of the block.
//     * @param h - the height of the block.
//     * @param c - the color of the block.
//     * @param b - a ball in the game.
//     * @return - the created block. */
//    public Block createBorderBlock(double x, double y, double w, double h, Color c, Ball b) {
//        Block block = new Block(new Rectangle(new Point(x, y), w, h), c);
//        block.addToGame(this);
//        b.getGE().addCollidable(block); // so the b1 will "know" that b is collidable with it.
//        return block;
//    }
//    /**
//     * the method initialize a new game by creating the Blocks, paddle and the Ball by using other methods and add
//     * them to the game. */
//    public void initialize() {
//        ScoreIndicator sco = new ScoreIndicator(new Rectangle(new Point(0, 0), 800, 15),
//                Color.cyan, currentScore);
//        sco.addToGame(this); // add the score indicator to the game
//        sprites.addSprite(levelInformation.getBackground());
//        BlockRemover br = new BlockRemover(this, countBlock);
//        BallRemover bl = new BallRemover(this, countBall);
//        Ball ball = createBall(410, 558, 5, Color.RED, environment, bl);
//        for (int i = 1; i < levelInformation.numberOfBalls(); i++) {
//            createBall(403, 558, 5, Color.RED, environment, bl);
//        }
//        ScoreTrackingListener stl = new ScoreTrackingListener(currentScore);
//        createBorderBlock(0, 35, 20, 600, Color.GRAY, ball); // left border
//        createBorderBlock(780, 35, 20, 600, Color.GRAY, ball); // right border
//        createBorderBlock(0, 15, 800, 20, Color.GRAY, ball); // up border
//        LivesIndicator li = new LivesIndicator(countLive);
//        li.addToGame(this);
//        for (Block b : levelInformation.blocks()) {
//            countBlock.increase(1);
//            b.addToGame(this);
//            ball.getGE().addCollidable(b); // so the b1 will "know" that b is collidable with it.
//            b.addHitListener(br);
//            b.addHitListener(stl);
//        }
//    }
//    /**
//     * the method run one turn of the game. */
//    public void playOneTurn() {
//        createBallsOnTopOfPaddle();
//        this.running = true;
//        runner.run(this);
//        if (countLive.getValue() == 0) {
//            runner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
//                    new EndScreen(keyboardSensor, "LOSE", currentScore)));
//            runner.getGui().close();
//        }
//        if (countBall.getValue() == 0) {
//            playOneTurn();
//        }
//    }
//    /**
//     * the method will do one frame of the the animation on the given DrawSurface.
//     * @param d - the surface of the game. */
//    public void doOneFrame(DrawSurface d) {
//        sprites.drawAllOn(d);
//        sprites.notifyAllTimePassed();
//        if (countBall.getValue() <= 0) {
//            countLive.decrease(1);
//            this.running = false;
//        }
//        if (this.runner.getKeyboard().isPressed("p")) {
//            this.runner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
//                    new PauseScreen(keyboardSensor)));
//        }
//        if (countBlock.getValue() == 0) {
//            exit++;
//        }
//        if (exit == 2) { // for doing more frames so I would see the last block removing before moving to next level.
//            currentScore.increase(100);
//            this.running = false;
//        }
//    }
//    /**
//     * the method will return if we should stop the animation or not using boolean variable.
//     * @return - true if we should stop the animation, false otherwise . */
//    public boolean shouldStop() {
//        return !this.running;
//    }
//    /**
//     * the method will create the paddle and the block in their places in every new turn and will call the countdown
//     * animation before every turn starts. */
//    public void createBallsOnTopOfPaddle() {
//        BallRemover bl = new BallRemover(this, countBall);
//        if (flag == 0) {
//            Ball ball = createBall(403, 558, 5, Color.RED, environment, bl);
//            for (int i = 1; i < levelInformation.numberOfBalls(); i++) {
//                createBall(403, 558, 5, Color.RED, environment, bl);
//            }
//            paddle.removeFromGame(this);
//            ball.getGE().removeCollidable(paddle);
//        }
//        flag = 0;
//        paddle = new Paddle(new Rectangle(new Point((800 - levelInformation.paddleWidth()) / 2.0, 575),
//                levelInformation.paddleWidth(), 15), Color.ORANGE, keyboardSensor, levelInformation.paddleSpeed());
//        paddle.addToGame(this);
//        this.runner.run(new CountdownAnimation(2, 3, sprites));
//    }
//    /**
//     * the method removes a colliidable item from the colliadables array list (to the game environment).
//     * @param c - the colliidable item that the method will remove from the colliadables array list. */
//    public void removeCollidable(Collidable c) {
//        environment.removeCollidable(c);
//    }
//    /**
//     * the method removes a sprite item to the sprites array list.
//     * @param s - the sprite item that the method will remove from the sprites array list. */
//    public void removeSprite(Sprite s) {
//        sprites.removeSprite(s);
//    }
//}






















package gamesettings;
/**
 * @author Shachar Korall.
 * ID: 208486191
 * @version IntelliJ IDEA 2019.3.3
 * @since 08-06-2020 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.*;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;

import javax.swing.*;
import java.awt.Color;
/**
 * class GameLevel.
 * hold the sprites and the collidables, and will be in charge of the animation of the level. */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter countBlock;
    private Counter countBall;
    private Counter currentScore;
    private Counter countLive;
    private Paddle paddle;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInformation;
    private KeyboardSensor keyboardSensor;
    private int flag = 1;
    private int exit;
    private int highestScore;
    private int velocity = 0;
    private BallRemover bl;
    /**
     * constructor.
     * @param li - the information of the level.
     * @param runner - the animation the game runs.
     * @param keyboard - the keyboard for the game.
     * @param cl - counter of lives of the player.
     * @param cs - the counter of the score of the player. */
    public GameLevel(LevelInformation li, AnimationRunner runner, KeyboardSensor keyboard, Counter cl, Counter cs) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.countBlock = new Counter();
        this.countBall = new Counter();
        this.currentScore = cs;
        this.countLive = cl;
        this.runner = runner;
        this.running = true;
        this.levelInformation = li;
        this.keyboardSensor = keyboard;
        this.exit = 0;
        this.highestScore = cs.getValue();
        this.bl = new BallRemover(this, countBall);
    }
    /**
     * the method add a colliidable item to the colliadables array list (to the game environment).
     * @param c - the colliidable item that the method will add to the colliadables array list. */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }
    /**
     * the method add a sprite item to the sprites array list.
     * @param s - the sprite item that the method will add to the sprites array list. */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }
    /**
     * the method creates a ball and add it to the game.
     * @param x - the x value of the center point of the ball.
     * @param y - the y value of the center point of the ball.
     * @param r - the radius of the ball.
     * @param c - the color of the ball
     * @param g - the game environment of the ball.
     * @param bl - add hit listener to the ball if hits death block.
     * @return - the created ball. */
    public Ball createBall(double x, double y, int r, Color c, GameEnvironment g, BallRemover bl) {
        Ball b = new Ball(new Point(x, y), r, c);
        b.setVelocity(levelInformation.initialBallVelocities().get(velocity));
        b.setGE(g);
        b.addToGame(this);
        b.moveOneStep();
        Block death = new Block(new Rectangle(new Point(20, 600), 760, 1), Color.GRAY);
        b.getGE().addCollidable(death);
        death.addHitListener(bl);
        countBall.increase(1);
        velocity++;
        return b;
    }
    /**
     * the method creates the border blocks, add it to the game and update the balls in the game to "know"
     * it is collidable.
     * @param x - the x value of the upper left point of the block.
     * @param y - the y value of the upper left point of the block.
     * @param w - the width of the block.
     * @param h - the height of the block.
     * @param c - the color of the block.
     * @param b - a ball in the game.
     * @return - the created block. */
    public Block createBorderBlock(double x, double y, double w, double h, Color c, Ball b) {
        Block block = new Block(new Rectangle(new Point(x, y), w, h), c);
        block.addToGame(this);
        b.getGE().addCollidable(block); // so the b1 will "know" that b is collidable with it.
        return block;
    }
    /**
     * the method initialize a new game by creating the Blocks, paddle and the Ball by using other methods and add
     * them to the game. */
    public void initialize() {
        ScoreIndicator sco = new ScoreIndicator(new Rectangle(new Point(0, 0), 800, 15),
                Color.cyan, currentScore);
        sco.addToGame(this); // add the score indicator to the game
        sprites.addSprite(levelInformation.getBackground());
        BlockRemover br = new BlockRemover(this, countBlock);
        //BallRemover bl = new BallRemover(this, countBall);
        Ball ball = createBall(410, 558, 5, Color.RED, environment, bl);
        for (int i = 1; i < levelInformation.numberOfBalls(); i++) {
            createBall(403, 558, 5, Color.RED, environment, bl);
        }
        ScoreTrackingListener stl = new ScoreTrackingListener(currentScore);
        createBorderBlock(0, 35, 20, 600, Color.GRAY, ball); // left border
        createBorderBlock(780, 35, 20, 600, Color.GRAY, ball); // right border
        createBorderBlock(0, 15, 800, 20, Color.GRAY, ball); // up border
        LivesIndicator li = new LivesIndicator(countLive);
        li.addToGame(this);
        for (Block b : levelInformation.blocks()) {
            countBlock.increase(1);
            b.addToGame(this);
            ball.getGE().addCollidable(b); // so the b1 will "know" that b is collidable with it.
            b.addHitListener(br);
            b.addHitListener(stl);
        }
    }
    /**
     * the method run one turn of the game. */
    public void playOneTurn() {
        createBallsOnTopOfPaddle();
        this.running = true;
        runner.run(this);
        if (countLive.getValue() == 0) {
//            HighScoreFile sc = new HighScoreFile(currentScore.getValue());
//            sc.printScore();
//            HighScoresAnimation hsa = new HighScoresAnimation(sc.getHighestScore());
//            runner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
//                    new EndScreen(keyboardSensor, "LOSE", currentScore)));
//            runner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
//                    hsa));
//            this.running = false;

//            //runner.getGui().close();
        }
        if (countBall.getValue() == 0 && countLive.getValue() > 0) {
            playOneTurn();
        }
    }
    /**
     * the method will do one frame of the the animation on the given DrawSurface.
     * @param d - the surface of the game. */
    public void doOneFrame(DrawSurface d) {
        sprites.drawAllOn(d);
        sprites.notifyAllTimePassed();
        if (countBall.getValue() <= 0) {
            countLive.decrease(1);
            this.running = false;
        }
        if (this.runner.getKeyboard().isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(keyboardSensor)));
        }
//        if (this.runner.getKeyboard().isPressed("b")) {
//            if (x == 0) {
//                this.runner.run(new AddBall(410, 558, 5, Color.RED, environment, bl, this, sprites, countBall, paddle));
//                x = 1;
//            }
//        }
//        if (x != 0) {
//            y++;
//        }
//        if (y == 30) {
//            x = 0;
//            y = 0;
//        }
        if (countBlock.getValue() == 0) {
            exit++;
        }
        if (exit == 2) { // for doing more frames so I would see the last block removing before moving to next level.
            currentScore.increase(100);
            this.running = false;
        }
    }
    /**
     * the method will return if we should stop the animation or not using boolean variable.
     * @return - true if we should stop the animation, false otherwise . */
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * the method will create the paddle and the block in their places in every new turn and will call the countdown
     * animation before every turn starts. */
    public void createBallsOnTopOfPaddle() {
        BallRemover bl = new BallRemover(this, countBall);
        velocity = 0;
        if (flag == 0) {
            Ball ball = createBall(403, 558, 5, Color.RED, environment, bl);
            for (int i = 1; i < levelInformation.numberOfBalls(); i++) {
                createBall(403, 558, 5, Color.RED, environment, bl);
            }
            paddle.removeFromGame(this);
            ball.getGE().removeCollidable(paddle);
        }
        flag = 0;
        paddle = new Paddle(new Rectangle(new Point((800 - levelInformation.paddleWidth()) / 2.0, 575),
                levelInformation.paddleWidth(), 15), Color.ORANGE, keyboardSensor, levelInformation.paddleSpeed());
        paddle.addToGame(this);
        this.runner.run(new CountdownAnimation(2, 3, sprites));
    }
    /**
     * the method removes a colliidable item from the colliadables array list (to the game environment).
     * @param c - the colliidable item that the method will remove from the colliadables array list. */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }
    /**
     * the method removes a sprite item to the sprites array list.
     * @param s - the sprite item that the method will remove from the sprites array list. */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }
}