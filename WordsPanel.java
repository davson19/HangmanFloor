package HangmanFloor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by micpi on 6/1/2017.
 */
public class WordsPanel extends JPanel {
    private String solved;
    private String unsolved = "";

    public WordsPanel (String str) {
        solved = str;
        for (int i  = 0; i < solved.length(); i++) {
            char c = solved.charAt(i);
            if (c == ' ')
                unsolved += ' ';
            else
                unsolved += '-';
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(unsolved, getWidth() / 2, getHeight() / 2);
    }

    public boolean update (char c) {
        boolean inString = false;
        for (int i ) {
            if (c == solved.charAt(i++)) {
                inString = true;
            }
        }
    }
}
