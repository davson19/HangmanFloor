package HangmanFloor;

import java.awt.Image;

import javax.swing.JPanel;

public class KeyPanel extends JPanel {
	private static final long serialVersionUID = 1L; // ignore this
	
	private Image image;
	private char c;
	private boolean visibile;
	
	public KeyPanel(Image image, char c) {
		this.image = image;
		this.c = c;
		visibile = true;
	}

	public boolean isVisible() {
		return visibile;
	}
	
	public void setVisibile(boolean visible) {
		this.visibile = visible;
	}

	public Image getImage() {
		return image;
	}

	public char getC() {
		return c;
	}
	
	

}
