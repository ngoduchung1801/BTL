package Main;

import Item.Bomb;
import Item.Heart;
import Item.Potion;
import Item.Shoes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UI {
    GamePanel gp;
    BufferedImage image;
    Font font;
    BufferedImage Heart, Potion, Bomb, Shoes;
    NumberFormat numberFormat = new DecimalFormat("#00");
    public int count = 0;

    public UI(GamePanel gp) {
        this.gp = gp;

        try {
            File file = new File("src/main/resources/font/Retro Gaming.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        Heart heart = new Heart(gp);
        Heart = heart.down1;

        Potion potion = new Potion(gp);
        Potion = potion.down1;

        Bomb bomb = new Bomb(gp);
        Bomb = bomb.down1;

        Shoes shoes = new Shoes(gp);
        Shoes = shoes.down1;
    }

    public void draw(Graphics2D g2) {
        if (gp.gameState == gp.titleState) {
            g2.setFont(font);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 90));

            try {
                image = ImageIO.read(new FileInputStream("src/main/resources/wallpaper/w.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2.drawImage(image, 0, 0, gp.screenWidth, gp.screenHeight, null);

            g2.setColor(Color.black);
            g2.drawString("BOMBERMAN", gp.screenWidth / 2 - 315, 275);
            g2.setColor(Color.white);
            g2.drawString("BOMBERMAN", gp.screenWidth / 2 - 320, 270);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));

            g2.setColor(Color.black);
            g2.drawString("PLAY", gp.screenWidth / 2 - 67, 403);
            g2.setColor(Color.white);
            g2.drawString("PLAY", gp.screenWidth / 2 - 70, 400);
            if (count == 0) {
                g2.setColor(Color.black);
                g2.drawString(">", gp.screenWidth / 2 - 106, 403);
                g2.setColor(Color.white);
                g2.drawString(">", gp.screenWidth / 2 - 110, 400);
            }

            g2.setColor(Color.black);
            g2.drawString("QUIT", gp.screenWidth / 2 - 67, 483);
            g2.setColor(Color.white);
            g2.drawString("QUIT", gp.screenWidth / 2 - 70, 480);
            if (count == 1) {
                g2.setColor(Color.black);
                g2.drawString(">", gp.screenWidth / 2 - 106, 483);
                g2.setColor(Color.white);
                g2.drawString(">", gp.screenWidth / 2 - 110, 480);
            }
        }
        if (gp.gameState == gp.playState) {
            if (gp.player.introTime > 0) {
                g2.setColor(Color.black);
                g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

                g2.setFont(font);
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));
                g2.setColor(Color.white);
                g2.drawString("Stage 1", gp.screenWidth / 2 - 100, gp.screenHeight / 2);
            } else {
                // display stats
                g2.setFont(font);
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
                g2.setColor(Color.black);

                g2.drawImage(Heart, 725, 50, gp.tileSize, gp.tileSize, null);
                g2.drawString("x" + gp.player.heartCount, 730 + gp.tileSize, 85);

                g2.drawImage(Potion, 725, 90, gp.tileSize, gp.tileSize, null);
                g2.drawString("+" + gp.player.potionCount, 730 + gp.tileSize, 130);

                g2.drawImage(Bomb, 725, 140, gp.tileSize, gp.tileSize, null);
                g2.drawString("x" + gp.player.bombCount, 730 + gp.tileSize, 175);

                g2.drawImage(Shoes, 730, 185, gp.tileSize, gp.tileSize, null);
                g2.drawString("+" + gp.player.shoesCount, 730 + gp.tileSize, 220);

                if (gp.player.minute == 0 && gp.player.second <= 0.0000001) {
                    gp.gameState = gp.endState;
                } else if (gp.player.minute > 0 && gp.player.second <= 0) {
                    gp.player.minute--;
                    gp.player.second = 59;
                } else {
                    gp.player.second -= (double) 1 / gp.FPS;
                    g2.drawString(gp.player.minute + ":" + numberFormat.format(gp.player.second), 745, 660);
                }

                // Check hitbox, just for testing
//            g2.setColor(Color.red);
//            g2.drawRect(gp.player.x + gp.player.hitBox.x, gp.player.y + gp.player.hitBox.y,
//                    gp.player.hitBox.width, gp.player.hitBox.height);
//            g2.drawRect(gp.enemy[0].x + gp.enemy[0].hitBox.x, gp.enemy[0].y + gp.enemy[0].hitBox.y,
//                    gp.enemy[0].hitBox.width, gp.enemy[0].hitBox.height);
//            g2.drawRect(5 * 48, 5 * 48, 48, 48);
//            g2.drawRect(2 * 48, 2 * 48, 48, 48);

                // draw grid, for testing too
//            g2.setColor(Color.black);
//            for (int i = 1; i < gp.maxScreenCol - 3; i++) {
//                for (int j = 1; j < gp.maxScreenRow - 2; j++) {
//                    g2.drawRect(i * 48, j * 48, 48, 48);
//                }
//            }
//            if (gp.items[0] != null) {
//                g2.drawRect(gp.items[0].x + gp.items[0].hitBox.x, gp.items[0].y + gp.items[0].hitBox.y,
//                        gp.items[0].hitBox.width, gp.items[0].hitBox.height);
//            }
//            if (gp.brick[8] != null) {
//                g2.drawRect(gp.brick[8].x + gp.brick[8].hitBox.x, gp.brick[8].y + gp.brick[8].hitBox.y,
//                        gp.brick[8].hitBox.width, gp.brick[8].hitBox.height);
//            }

            }

        }
        if (gp.gameState == gp.stage2State) {
            if (gp.player.introTime > 0) {
                g2.setColor(Color.black);
                g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

                g2.setFont(font);
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));
                g2.setColor(Color.white);
                g2.drawString("Stage 2", gp.screenWidth / 2 - 100, gp.screenHeight / 2);
            } else {
                // display stats
                g2.setFont(font);
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
                g2.setColor(Color.black);

                g2.drawImage(Heart, 725, 50, gp.tileSize, gp.tileSize, null);
                g2.drawString("x" + gp.player.heartCount, 730 + gp.tileSize, 85);

                g2.drawImage(Potion, 725, 90, gp.tileSize, gp.tileSize, null);
                g2.drawString("+" + gp.player.potionCount, 730 + gp.tileSize, 130);

                g2.drawImage(Bomb, 725, 140, gp.tileSize, gp.tileSize, null);
                g2.drawString("x" + gp.player.bombCount, 730 + gp.tileSize, 175);

                g2.drawImage(Shoes, 730, 185, gp.tileSize, gp.tileSize, null);
                g2.drawString("+" + gp.player.shoesCount, 730 + gp.tileSize, 220);

                if (gp.player.minute == 0 && gp.player.second <= 0.0000001) {
                    gp.gameState = gp.endState;
                } else if (gp.player.minute > 0 && gp.player.second <= 0) {
                    gp.player.minute--;
                    gp.player.second = 59;
                } else {
                    gp.player.second -= (double) 1 / gp.FPS;
                    g2.drawString(gp.player.minute + ":" + numberFormat.format(gp.player.second), 745, 660);
                }
//            g2.setColor(Color.RED);
//            g2.drawRect(gp.monster[0].x + gp.monster[0].hitBox.x, gp.monster[0].y + gp.monster[0].hitBox.y,
//                    gp.monster[0].hitBox.width, gp.monster[0].hitBox.height);
            }
        }
        if (gp.gameState == gp.pauseState) {
            // display stats, same like playState
            g2.setFont(font);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
            g2.setColor(Color.black);

            g2.drawImage(Heart, 725, 50, gp.tileSize, gp.tileSize, null);
            g2.drawString("x" + gp.player.heartCount, 730 + gp.tileSize, 85);

            g2.drawImage(Potion, 725, 90, gp.tileSize, gp.tileSize, null);
            g2.drawString("+" + gp.player.potionCount, 730 + gp.tileSize, 130);

            g2.drawImage(Bomb, 725, 140, gp.tileSize, gp.tileSize, null);
            g2.drawString("x" + gp.player.bombCount, 730 + gp.tileSize, 175);

            g2.drawImage(Shoes, 730, 185, gp.tileSize, gp.tileSize, null);
            g2.drawString("+" + gp.player.shoesCount, 730 + gp.tileSize, 220);

            g2.setColor(Color.black);
            g2.drawString(gp.player.minute + ":" + numberFormat.format(gp.player.second), 745, 660);

            // draw noti and selection
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            g2.setFont(font);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));

            g2.setColor(Color.black);
            g2.drawString("PAUSE", gp.screenWidth / 2 - 165, 275);
            g2.setColor(Color.white);
            g2.drawString("PAUSE", gp.screenWidth / 2 - 170, 270);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));

            g2.drawString("RESUME", gp.screenWidth / 2 - 100, 400);
            if (count == 0) {
                g2.drawString(">", gp.screenWidth / 2 - 140, 400);
            }

            g2.drawString("QUIT", gp.screenWidth / 2 - 70, 480);
            if (count == 1) {
                g2.drawString(">", gp.screenWidth / 2 - 110, 480);
            }
        }
        if (gp.gameState == gp.endState) {
            // display stats, same like playState
            g2.setFont(font);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
            g2.setColor(Color.black);

            g2.drawImage(Heart, 725, 50, gp.tileSize, gp.tileSize, null);
            g2.drawString("x" + gp.player.heartCount, 730 + gp.tileSize, 85);

            g2.drawImage(Potion, 725, 90, gp.tileSize, gp.tileSize, null);
            g2.drawString("+" + gp.player.potionCount, 730 + gp.tileSize, 130);

            g2.drawImage(Bomb, 725, 140, gp.tileSize, gp.tileSize, null);
            g2.drawString("x" + gp.player.bombCount, 730 + gp.tileSize, 175);

            g2.drawImage(Shoes, 730, 185, gp.tileSize, gp.tileSize, null);
            g2.drawString("+" + gp.player.shoesCount, 730 + gp.tileSize, 220);

            g2.setColor(Color.black);
            g2.drawString(gp.player.minute + ":" + numberFormat.format(gp.player.second), 745, 660);

            // draw noti and selection
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            g2.setFont(font);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));

            g2.setColor(Color.black);
            g2.drawString("GAME OVER", gp.screenWidth / 2 - 250, 275);
            g2.setColor(Color.white);
            g2.drawString("GAME OVER", gp.screenWidth / 2 - 255, 270);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));

            g2.drawString("RESTART", gp.screenWidth / 2 - 120, 400);
            if (count == 0) {
                g2.drawString(">", gp.screenWidth / 2 - 160, 400);
            }

            g2.drawString("QUIT", gp.screenWidth / 2 - 70, 480);
            if (count == 1) {
                g2.drawString(">", gp.screenWidth / 2 - 110, 480);
            }
        }
        if (gp.gameState == gp.winState) {
            // display stats, same like playState
            g2.setFont(font);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
            g2.setColor(Color.black);

            g2.drawImage(Heart, 725, 50, gp.tileSize, gp.tileSize, null);
            g2.drawString("x" + gp.player.heartCount, 730 + gp.tileSize, 85);

            g2.drawImage(Potion, 725, 90, gp.tileSize, gp.tileSize, null);
            g2.drawString("+" + gp.player.potionCount, 730 + gp.tileSize, 130);

            g2.drawImage(Bomb, 725, 140, gp.tileSize, gp.tileSize, null);
            g2.drawString("x" + gp.player.bombCount, 730 + gp.tileSize, 175);

            g2.drawImage(Shoes, 730, 185, gp.tileSize, gp.tileSize, null);
            g2.drawString("+" + gp.player.shoesCount, 730 + gp.tileSize, 220);

            g2.setColor(Color.black);
            g2.drawString(gp.player.minute + ":" + numberFormat.format(gp.player.second), 745, 660);

            // draw noti and selection
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            g2.setFont(font);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));

            g2.setColor(Color.black);
            g2.drawString("YOU WIN!", gp.screenWidth / 2 - 230, 275);
            g2.setColor(Color.white);
            g2.drawString("YOU WIN!", gp.screenWidth / 2 - 235, 270);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));

            g2.drawString("PLAY AGAIN", gp.screenWidth / 2 - 140, 400);
            if (count == 0) {
                g2.drawString(">", gp.screenWidth / 2 - 180, 400);
            }

            g2.drawString("QUIT", gp.screenWidth / 2 - 65, 480);
            if (count == 1) {
                g2.drawString(">", gp.screenWidth / 2 - 105, 480);
            }
        }
    }
}


