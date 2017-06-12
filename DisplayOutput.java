package HangmanFloor;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayOutput extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int REFRESH = 80;

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			DisplayOutput frame = new DisplayOutput();
			frame.setLayout(new GridBagLayout());

			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			HangmanPanel hp = new HangmanPanel();
			hp.setPreferredSize(new Dimension(192 / 2, 192 / 2));
			frame.add(hp, c);

			c.gridx = 1;
			WordsPanel wp = new WordsPanel();
			wp.setPreferredSize(new Dimension(192 / 2, 192 / 2));
			frame.add(wp, c);

			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 2;
			KeyboardPanel kp = new KeyboardPanel(false);
			kp.setPreferredSize(new Dimension(192, 192 / 2));
			frame.add(kp, c);

			frame.setTitle("Hangman!");
			frame.setSize(250, 250);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			Scanner scan = new Scanner(System.in);

			while (true) {
				System.out.println("What is the word/phrase that will be used");
				wp.setWord(scan.nextLine().toUpperCase());
				wp.repaint();
				try {
					boolean[][] arr = ArrayFromXML.getArray(new DataReader());
					// do the code to check input here
				} catch (Exception e) {
					System.err.println("Error: Make sure that the board is turned on and plugged in.");
				}
				
				while (!hp.gameOver() && !wp.isSolved()) {
					int ch = 0;

					if (ch != 0) {
						kp.removeKey((char) ch);
						if (!(wp.update((char) ch))) {
							hp.increment();
						}
					}
					Thread.sleep(REFRESH);
				}
				frame.remove(kp);
				frame.remove(wp);
				frame.remove(hp);
				
				JPanel end = new JPanel();
				
				JLabel[] letters = new JLabel[10];
				letters[0] = new JLabel(new ImageIcon("src/HangmanFloor/images/y.gif"));
				letters[1] = new JLabel(new ImageIcon("src/HangmanFloor/images/o.gif"));
				letters[2] = new JLabel(new ImageIcon("src/HangmanFloor/images/u.gif"));
				letters[3] = new JLabel(new ImageIcon("src/HangmanFloor/images/w.gif"));
				letters[4] = new JLabel(new ImageIcon("src/HangmanFloor/images/i.gif"));
				letters[5] = new JLabel(new ImageIcon("src/HangmanFloor/images/n.gif"));
				letters[6] = new JLabel(new ImageIcon("src/HangmanFloor/images/l.gif"));
				letters[7] = new JLabel(new ImageIcon("src/HangmanFloor/images/o.gif"));
				letters[8] = new JLabel(new ImageIcon("src/HangmanFloor/images/s.gif"));
				letters[9] = new JLabel(new ImageIcon("src/HangmanFloor/images/e.gif"));
				
				for (int i = 0; i < 10; i++) {
					end.add(letters[i]);
					
					if (i == 2)
						if (!wp.isSolved())
							i = 5;
					
					if (i == 5 && wp.isSolved())
						break;
				}
				frame.add(end);
				Thread.sleep(2000);
				// check if the array is empty. While it's empty, Thread.sleep the refresh rate.
				while (true /* input array is empty */) {
					Thread.sleep(REFRESH);
				}
			}
			
			
		}
	}

}