package HangmanFloor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by micpi on 6/12/2017.
 */
public class GameOverPanel extends JPanel {
    boolean win;
    public GameOverPanel (boolean win) {
        this.win = win;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String s = "lose";
        if (win) {
            s = "win";
        }
        g.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        g.drawString("Game Over \n You " + s, getWidth() / 2, getHeight() / 2);
    }

}
