package HangmanFloor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by micpi on 5/30/2017.
 */
public class KeyboardPanel extends JPanel {
	private static final long serialVersionUID = 1L; // ignore dis

	boolean spacebar;
	JLabel[] keys = new JLabel[26];

	public KeyboardPanel(boolean spacebar) {
		this.spacebar = spacebar;

		for (int i = 0; i < keys.length; i++) {
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/" + Character.toString(((char)(i + 'a'))) + ".gif"));
			JLabel label = new JLabel(new ImageIcon(image));
			keys[i] = label;
			add(label);
		}
	}

	public void removeKey(char c) {
		keys[c - 'A'].setVisible(false);
		repaint();
	}

}
