package HangmanFloor;

import javax.swing.*;

public class DisplayOutput extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int REFRESH = 80;

	public static void main(String[] args) throws InterruptedException {
		DisplayOutput frame = new DisplayOutput();

//        HangmanPanel p = new HangmanPanel();
//        frame.add(p);
<<<<<<< HEAD
        KeyboardPanel kp = new KeyboardPanel(false);
        frame.add(kp);
//        WordsPanel wp = new WordsPanel("Hello World");
//        frame.add(wp);
=======
//        KeyboardPanel kp = new KeyboardPanel(false);
//        frame.add(kp);
        WordsPanel wp = new WordsPanel("Hello World");
        frame.add(wp);
>>>>>>> origin/master

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