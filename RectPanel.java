package HangmanFloor;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by micpi on 5/31/2017.
 */
public class RectPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	@Override
    protected void paintComponent(Graphics g) {
        Color[] c = {Color.red, Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLACK, Color.CYAN, Color.PINK, Color.ORANGE};
        Random r = new Random();
        g.setColor(c[r.nextInt(c.length)]);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
