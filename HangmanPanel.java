package HangmanFloor;

import javax.swing.*;
import java.awt.*;

public class HangmanPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int numWrong = 0;

    public void increment() {numWrong++;}

    public boolean gameOver () {
        return numWrong >= 6;
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(149, 151, 148));
        int x = getWidth();
        int y = getHeight();
        g.drawLine(x / 5, y / 5, 3 * x / 5, y / 5);
        g.drawLine(3 * x / 5, y / 5, 3 * x / 5, 3 * y / 10);
        g.drawLine(x / 5, y / 5, x / 5, 19 * y / 20);
        g.drawArc(3 * x / 20, 19 * y / 20, x / 10, y / 10, 0, 180);
        switch (numWrong) {
            case(6):
            g.drawLine(3 * x / 5, 7 * y / 10, 13 * x / 20, 9 * y / 10);
            case(5):
            g.drawLine(3 * x / 5, 7 * y / 10, 11 * x / 20, 9 * y / 10);
            case(4):
            g.drawLine(3 * x / 5, 5 * y / 10, 7 * x / 10, 3 * y / 5);
            case(3):
            g.drawLine(3 * x / 5, 5 * y / 10, 5 * x / 10, 3 * y / 5);
            case(2):
            g.drawLine(3 * x / 5, 5 * y / 10, 3 * x / 5, 7 * y / 10);
            case(1):
            g.drawArc(10 * x / 20, 3 * y / 10, x / 5, y / 5, 0, 360);
        }
    }

}