package inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeY(-5);
                System.out.println("w pressed");
                break;
            case KeyEvent.VK_A:
                gamePanel.changeX(-5);
                System.out.println("a pressed");
                break;
            case KeyEvent.VK_S:
                gamePanel.changeY(5);
                System.out.println("s pressed");
                break;
            case KeyEvent.VK_D:
                gamePanel.changeX(5);
                System.out.println("d pressed");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
