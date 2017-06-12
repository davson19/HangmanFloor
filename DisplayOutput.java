package HangmanFloor;

import java.awt.*;
import java.util.Scanner;

import javax.swing.JFrame;

public class DisplayOutput extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int REFRESH = 80;

	public static void main(String[] args) throws InterruptedException {
	        Point[] pos = new Point[26];
	        int count = 0;
            for (int j = 18; j < 21; j+=2) {
                System.out.println("j: " + j);
                for (int i = 3; i < 20; i+=2) {
                    System.out.println("i: " + i);
                    pos[count++] = new Point(i, j);
                }
            }

            for (int i = 4; i < 19; i+=2) {
                int j = 22;
                pos[count++] = new Point(i, j);
            }
			DisplayOutput frame = new DisplayOutput();
			frame.setLayout(new GridBagLayout());

			GridBagConstraints ch = new GridBagConstraints();
			ch.gridx = 0;
			ch.gridy = 0;
			HangmanPanel hp = new HangmanPanel();
			hp.setPreferredSize(new Dimension(192 / 2, 192 / 2));
			frame.add(hp, ch);

            GridBagConstraints cw = new GridBagConstraints();
			cw.gridx = 1;
			cw.gridy = 0;
			WordsPanel wp = new WordsPanel();
			wp.setPreferredSize(new Dimension(192 / 2, 192 / 2));
			frame.add(wp, cw);

            GridBagConstraints ck = new GridBagConstraints();
			ck.gridx = 0;
			ck.gridy = 1;
			ck.gridwidth = 2;
			KeyboardPanel kp = new KeyboardPanel(false);
			kp.setPreferredSize(new Dimension(192, 192 / 2));
			frame.add(kp, ck);

			frame.setTitle("Hangman!");
			frame.setSize(250, 250);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			Scanner scan = new Scanner(System.in);

			while (true) {
                frame.repaint();
				System.out.println("What is the word/phrase that will be used");
				wp.setWord(scan.nextLine().toUpperCase());
				wp.repaint();
                boolean[][] arr = new boolean[0][];
				try {
				    arr = ArrayFromXML.getArray(new DataReader());
				} catch (Exception e) {
					System.err.println("Error: Make sure that the board is turned on and plugged in.");
				}
				
				while (!hp.gameOver() && !wp.isSolved()) {
					int c = 0;

                    for (int i = 0; i < pos.length; i++) {
                        if (arr[pos[i].x][pos[i].y]) {
                            c = 'A' + i;
                        }
                    }
					if (c != 0) {
						kp.removeKey((char) c);
						if (!(wp.update((char) c))) {
							hp.increment();
						}
					}
					Thread.sleep(REFRESH);
				}
				
				GameOverPanel end = new GameOverPanel(true);
				end.setPreferredSize(new Dimension(192, 192));
				GridBagConstraints cg = new GridBagConstraints();
				cg.gridx = 0;
				cg.gridy = 0;
				cg.gridwidth = 2;
				cg.gridheight = 2;
				frame.remove(hp);
                frame.remove(wp);
                frame.remove(kp);
				frame.add(end, cg);
				end.repaint();
                frame.repaint();
                Thread.sleep(5000);
                frame.remove(end);
                frame.add(hp, ch);
                frame.add(wp, cw);
                frame.add(kp, ck);
			}

	}

}