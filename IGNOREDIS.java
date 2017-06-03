package HangmanFloor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by micpi on 5/30/2017.
 */
public class IGNOREDIS extends JPanel {
	private static final long serialVersionUID = 1L;
	boolean spacebar;
	
    Point[] positions;
    KeyPanel[] keys = new KeyPanel[26];
    
    public IGNOREDIS(boolean spacebar) {
        this.spacebar = spacebar;
        setLayout(new GridLayout());
        
        for (int i = 0; i < keys.length; i++) {
        	//Image image = new Image("\\images\\a.gif");
            //keys[i] = new KeyPanel(image, (char)(i + 33));
            keys[i].setSize(new Dimension(16, 16));
            add(keys[i]);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < keys.length; i++) {
            keys[i].repaint();
        }
    }

    public Point findPosition (char c) {
        return positions[c - 'A'];
    }

    public void removeKey (char c) {
        //keys[c - 'A'].setVisible(false);
        repaint();
    }


}
