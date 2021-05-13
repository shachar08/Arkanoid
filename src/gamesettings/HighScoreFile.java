package gamesettings;

import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
public class HighScoreFile {
    private int score;
    private int highest;
    /**
     * constructor.
     *
     * @param score - the keyboard for the game.
     */
    public HighScoreFile(int score) {
        this.score = score;
        //this.flag = 0;
        this.highest = 0;
    }

    public void printScore() {
        //if (flag == 0) {
        try {
            File f = new File("highscores.txt");
            if (f.createNewFile()) {
                PrintWriter p = new PrintWriter(f);
                p.write("The highest score so far is: " + score);
                this.highest = this.score;
                p.close();
            } else {
                BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("highscores.txt")));
                String s = bf.readLine();
                int b = s.indexOf(":");
                String a = s.substring(b + 2);
                int sum = Integer.parseInt(a);
                this.highest = sum;
                if (score > sum) {
                    this.highest = this.score;
                    PrintWriter p = new PrintWriter(f);
                    p.write("The highest score so far is: " + score);
                    p.close();
                }
                bf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getHighestScore() {
        printScore();
        return this.highest;
    }
}

