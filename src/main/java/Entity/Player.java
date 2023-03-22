package Entity;

import Main.CheckCollision;
import Main.GamePanel;
import Main.KeyControl;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyControl keyC;
    public int shoesCount = 0;
    public int heartCount = 3;
    public int bombCount = 1;
    public int potionCount = 0;


    public Player(GamePanel gp, KeyControl keyC) {
        this.gp = gp;
        this.keyC = keyC;

        hitBox = new Rectangle();
        hitBox.x = 16;
        hitBox.y = 28;
        hitBox.width = 16;
        hitBox.height = 12;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = gp.tileSize;
        y = gp.tileSize;
        speed = 4;
        dir = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new FileInputStream("src/main/resources/player/up1.png"));
            up2 = ImageIO.read(new FileInputStream("src/main/resources/player/up2.png"));
            down1 = ImageIO.read(new FileInputStream("src/main/resources/player/down1.png"));
            down2 = ImageIO.read(new FileInputStream("src/main/resources/player/down2.png"));
            right1 = ImageIO.read(new FileInputStream("src/main/resources/player/right1.png"));
            right2 = ImageIO.read(new FileInputStream("src/main/resources/player/right2.png"));
            right3 = ImageIO.read(new FileInputStream("src/main/resources/player/right3.png"));
            right4 = ImageIO.read(new FileInputStream("src/main/resources/player/right4.png"));
            right5 = ImageIO.read(new FileInputStream("src/main/resources/player/right5.png"));
            right6 = ImageIO.read(new FileInputStream("src/main/resources/player/right6.png"));
            left1 = ImageIO.read(new FileInputStream("src/main/resources/player/left1.png"));
            left2 = ImageIO.read(new FileInputStream("src/main/resources/player/left2.png"));
            left3 = ImageIO.read(new FileInputStream("src/main/resources/player/left3.png"));
            left4 = ImageIO.read(new FileInputStream("src/main/resources/player/left4.png"));
            left5 = ImageIO.read(new FileInputStream("src/main/resources/player/left5.png"));
            left6 = ImageIO.read(new FileInputStream("src/main/resources/player/left6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (keyC.upPressed || keyC.downPressed || keyC.leftPressed || keyC.rightPressed) {
            if (keyC.upPressed) {
                dir = "up";
            } else if (keyC.downPressed) {
                dir = "down";
            } else if (keyC.rightPressed) {
                dir = "right";
            } else if (keyC.leftPressed) {
                dir = "left";
            }

            collisionOn = false;
            gp.CC.checkTile(this);

            int itemIndex = gp.CC.checkItem(this, true);
            pickUpItem(itemIndex);

            if (collisionOn == false) {
                switch (dir) {
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                }
            }

            Count++;
            if (Count > 5) {
                if (verticalNum == 1) {
                    verticalNum = 2;
                } else if (verticalNum == 2) {
                    verticalNum = 1;
                }
                if (horizontalNum == 1) {
                    horizontalNum = 2;
                } else if (horizontalNum == 2) {
                    horizontalNum = 3;
                } else if (horizontalNum == 3) {
                    horizontalNum = 4;
                } else if (horizontalNum == 4) {
                    horizontalNum = 5;
                } else if (horizontalNum == 5) {
                    horizontalNum = 6;
                } else if (horizontalNum == 6) {
                    horizontalNum = 1;
                }
                Count = 0;
            }
        }

    }

    public void pickUpItem(int index){
        if (index != -1){
            String itemName = gp.items[index].name;
            switch (itemName){
                case "shoes":
                    shoesCount++;
                    speed += 1;
                    gp.items[index] = null;
                    break;
                case "heart":
                    heartCount++;
                    gp.items[index] = null;
                    break;
                case "bomb":
                    bombCount++;
                    gp.items[index] = null;
                    break;
                case "potion":
                    potionCount++;
                    gp.items[index] = null;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (dir) {
            case "up":
                if (verticalNum == 1) {
                    image = up1;
                } else if (verticalNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (verticalNum == 1) {
                    image = down1;
                } else if (verticalNum == 2) {
                    image = down2;
                }
                break;
            case "right":
                if (horizontalNum == 1) {
                    image = right1;
                } else if (horizontalNum == 2) {
                    image = right2;
                } else if (horizontalNum == 3) {
                    image = right3;
                } else if (horizontalNum == 4) {
                    image = right4;
                } else if (horizontalNum == 5) {
                    image = right5;
                } else if (horizontalNum == 6) {
                    image = right6;
                }
                break;
            case "left":
                if (horizontalNum == 1) {
                    image = left1;
                } else if (horizontalNum == 2) {
                    image = left2;
                } else if (horizontalNum == 3) {
                    image = left3;
                } else if (horizontalNum == 4) {
                    image = left4;
                } else if (horizontalNum == 5) {
                    image = left5;
                } else if (horizontalNum == 6) {
                    image = left6;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}


