package Main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int DeltaX = 100, DeltaY = 100;
    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeX(int value) {
        DeltaX += value;
        repaint();
    }
    public void changeY(int value) {
        DeltaY += value;
        repaint();
    }
    public void setRectPos(int x, int y) {
        DeltaX = x;
        DeltaY = y;
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(DeltaX, DeltaY, 200, 50);
    }
}
