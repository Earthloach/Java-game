package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(100, 200, 300, 400);
    }
}
