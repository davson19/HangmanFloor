package HangmanFloor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Created by micpi on 5/31/2017.
 */
public class RectPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	@Override
    protected void paintComponent(Graphics g) {
        setBackground(new Color(149, 151, 148));
        Color[] c = {Color.red, Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLACK, Color.CYAN, Color.PINK, Color.ORANGE};
        Random r = new Random();
        g.setColor(c[r.nextInt(c.length)]);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
