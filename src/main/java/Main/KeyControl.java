package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, rightPressed, leftPressed;
    public boolean spawnBomb;

    public KeyControl(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gp.gameState == gp.titleState) {
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                gp.ui.count--;
                if (gp.ui.count < 0) {
                    gp.ui.count = 1;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                gp.ui.count++;
                if (gp.ui.count > 1) {
                    gp.ui.count = 0;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (gp.ui.count == 0){
                    gp.gameState = gp.playState;
                }
                if (gp.ui.count == 1){
                    System.exit(0);
                }
            }
        }
        else if (gp.gameState == gp.stage2State) {
            if (gp.player.heartCount > 0){
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gp.gameState = gp.pauseState;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spawnBomb = true;
                }
            }
        }
        else if (gp.gameState == gp.playState) {
            if (gp.player.heartCount > 0){
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gp.gameState = gp.pauseState;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spawnBomb = true;
                }
            }
        }
        else if (gp.gameState == gp.pauseState) {
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                gp.ui.count--;
                if (gp.ui.count < 0) {
                    gp.ui.count = 1;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                gp.ui.count++;
                if (gp.ui.count > 1) {
                    gp.ui.count = 0;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                if (gp.ui.count == 0){
                    gp.gameState = gp.playState;
                }
                if (gp.ui.count == 1){
                    System.exit(0);
                }
            }
        }
        else if (gp.gameState == gp.endState){
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                gp.ui.count--;
                if (gp.ui.count < 0) {
                    gp.ui.count = 1;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                gp.ui.count++;
                if (gp.ui.count > 1) {
                    gp.ui.count = 0;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (gp.ui.count == 0){
                    gp.gameState = gp.playState;
                    gp.restart();
                }
                if (gp.ui.count == 1){
                    System.exit(0);
                }
            }
        }
        else if (gp.gameState == gp.winState) {
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                gp.ui.count--;
                if (gp.ui.count < 0) {
                    gp.ui.count = 1;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                gp.ui.count++;
                if (gp.ui.count > 1) {
                    gp.ui.count = 0;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (gp.ui.count == 0){
                    gp.gameState = gp.playState;
                    gp.restart();
                }
                if (gp.ui.count == 1){
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            spawnBomb = false;
        }
    }
}
