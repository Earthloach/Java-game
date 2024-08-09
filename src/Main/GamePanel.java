package Main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.*;

import static utils.Constants.PlayerConstants.*;

public class GamePanel extends JPanel {
    private float DeltaX = 100, DeltaY = 100;
    private int frames = 0;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 10;
    private int player_action = IDLE;
    private int player_direction = -1;
    private boolean isMoving = false;

    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        setPanelSIze();
        addKeyListener(new KeyboardInputs(this));
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];
        for (int i = 0; i < animations.length; i++) {
            for (int j = 0; j < animations[i].length; j++) {
                animations[i][j] = img.getSubimage(j * 64, i * 40, 64, 40);
            }
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/player.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSIze() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void setDirection(int direction) {
        this.player_direction = direction;
        isMoving = true;
    }

    public void setMoving(boolean move) {
        this.isMoving = move;

    }

    private void updateAnimationTick() {

        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(player_action)) {
                aniIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if (isMoving) {
            player_action = RUNNING;
        } else {
            player_action = IDLE;
        }
    }

    private void updatePosition() {
        if (isMoving) {
            if (player_direction == LEFT) {
                DeltaX -= 3;
            } else if (player_direction == RIGHT) {
                DeltaX += 3;
            } else if (player_direction == UP) {
                DeltaY -= 3;
            } else if (player_direction == DOWN) {
                DeltaY += 3;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();
        setAnimation();
        updatePosition();
        g.drawImage(animations[player_action][aniIndex], (int) DeltaX, (int) DeltaY, 256, 160, null);
    }
}


