package HangmanFloor;

import javax.swing.*;
import java.awt.*;

public class DisplayOutput extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int REFRESH = 80;

	public static void main(String[] args) throws InterruptedException {
		DisplayOutput frame = new DisplayOutput();
        frame.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        HangmanPanel p = new HangmanPanel();
        p.setPreferredSize(new Dimension(192 / 2, 192 / 2));
        frame.add(p, c);
        c.gridx = 1;
        WordsPanel wp = new WordsPanel("Hello World");
        wp.setPreferredSize(new Dimension(192 / 2, 192 / 2));
        frame.add(wp, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        KeyboardPanel kp = new KeyboardPanel(false);
        kp.setPreferredSize(new Dimension(192, 192 / 2));
        frame.add(kp, c);

		frame.setTitle("Hangman!");
		frame.setSize(192, 192);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
//        for (int i = 1; i <= 6; i++) {
//            Thread.sleep(2000);
//            p.increment();
//            p.repaint();
//        }
	}

}