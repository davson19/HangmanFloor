package HangmanFloor;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class DisplayOutput extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int REFRESH = 80;

	public static void main(String[] args) {
		DisplayOutput frame = new DisplayOutput();
        frame.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        HangmanPanel hp = new HangmanPanel();
        hp.setPreferredSize(new Dimension(192 / 2, 192 / 2));
        frame.add(hp, c);
        c.gridx = 1;
        WordsPanel wp = new WordsPanel("LOL");
        wp.setPreferredSize(new Dimension(192 / 2, 192 / 2));
        frame.add(wp, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        KeyboardPanel kp = new KeyboardPanel(false);
        kp.setPreferredSize(new Dimension(192, 192 / 2));
        frame.add(kp, c);
        wp.update('L');
        wp.update('O');

		frame.setTitle("Hangman!");
		frame.setSize(250, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("What is the word/phrase that will be used");
            wp.setWord(scan.nextLine().toUpperCase());
            while (!hp.gameOver() && !wp.isSolved()) {
                try {
                    boolean[][] arr = ArrayFromXML.getArray(new DataReader());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                int ch = 0;
                //find char in arr stuff
                if (ch != 0) {
                    kp.removeKey((char) ch);
                    if (!(wp.update((char) ch))) {
                        hp.increment();
                    }
                }
            }

            //show game over screen
        }
	}

}