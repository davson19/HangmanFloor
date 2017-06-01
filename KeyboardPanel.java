package HangmanFloor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by micpi on 5/30/2017.
 */
public class KeyboardPanel extends JPanel{
    boolean spacebar;
    Point[] positions;
    RectPanel[] keys = new RectPanel[26];
    public KeyboardPanel(boolean spacebar) {
        this.spacebar = spacebar;
        setLayout(new GridLayout(3, 12));
        for (int i = 0; i < keys.length; i++) {
            keys[i] = new RectPanel();
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
        //keys[c - 'A'].setVisibile(false);
        repaint();
    }


}
