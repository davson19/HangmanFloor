import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayOutput extends JFrame {
	public static final int REFRESH = 80;

	public DisplayOutput() {}

	public static void main(String[] args) throws InterruptedException {
		DisplayOutput frame = new DisplayOutput();
        HangmanPanel p = new HangmanPanel();
        frame.add(p);

		frame.setTitle("Hangman!");
		frame.setSize(192, 192);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
        for (int i = 1; i <= 6; i++) {
            Thread.sleep(2000);
            p.increment();
            p.repaint();
        }
	}

}

class Panel extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x = getWidth();
		int y = getHeight();
		
		
		
		/* //
		boolean a = true;
		boolean b = true;

		for (int i = 0; i < 4; i++) {
			if (b)
				a = false;
			else
				a = true;
			for (int j = 0; j < 6; j++) {
				if (a) {
					g.setColor(Color.YELLOW);
					g.fillRect(j * x / 6, i * y / 4, x / 6, y / 4);
					g.setColor(Color.BLACK);
					g.fillOval(j * x / 6 + 4, i * y / 4 + 4, x / 6 - 8, y / 4 - 8);
					a = false;
				} else {
					g.setColor(Color.GREEN);
					g.fillRect(j * x / 6, i * y / 4, x / 6, y / 4);
					g.setColor(Color.RED);
					g.fillOval(j * x / 6 + 4, i * y / 4 + 4, x / 6 - 8, y / 4 - 8);
					a = true;
				}
				
			}
			if (b)
				b = false;
			else
				b = true;
		}
		// */
	}

}