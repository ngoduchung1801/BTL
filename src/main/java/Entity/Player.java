package Entity;

import Item.BombToUse;
import Main.GamePanel;
import Main.KeyControl;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends Entity {
    KeyControl keyC;
    public int introTime, outroTime;

    public Player(GamePanel gp, KeyControl keyC) {
        super(gp);
        this.keyC = keyC;

        hitBox = new Rectangle();
        hitBox.x = 16; // 16
        hitBox.y = 24; // 28
        hitBox.width = 16; //16
        hitBox.height = 12; // 12
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        bombSpawn = new BombToUse(gp);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = gp.tileSize;
        y = gp.tileSize;
        speed = 1;
        dir = "down";
        invincible = false;
        dying = false;
        dyingCounter = 0;

        shoesCount = 0;
        heartCount = 1;
        bombCount = 1;
        potionCount = 0;

        minute = 5;
        second = 0;
        introTime = 180;
        outroTime = 150;

        enemyCount = 3;
        monsterCount = -1;
    }

    public void stage2DefaultValues(){
        x = gp.tileSize;
        y = gp.tileSize;
        speed = 1;
        dir = "down";
        invincible = false;
        dying = false;
        dyingCounter = 0;

        shoesCount = 0;
        heartCount = 1;
        bombCount = 1;
        potionCount = 0;

        minute = 5;
        second = 0;
        introTime = 180;

        enemyCount = -1;
        monsterCount = 3;
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

            itemIndex = gp.CC.checkItem(this);
            pickUpItem(itemIndex);

            int enemyIndex = gp.CC.checkEntity(this, gp.enemy);
            interactEnemy(enemyIndex);
            int monsterIndex = gp.CC.checkEntity(this, gp.monster);
            interactMonster(monsterIndex);

            gp.CC.playerCheckBomb();

            gp.CC.checkBrick(this);

            if (!collisionOn) {
                switch (dir) {
                    case "up" -> y -= speed;
                    case "down" -> y += speed;
                    case "right" -> x += speed;
                    case "left" -> x -= speed;
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

        if (heartCount == 0) {
            dying = true;
            if (dyingCounter > 60) {
                gp.gameState = gp.endState;
            }
        }

        if (heartCount >= 1 && invincible) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

        if (keyC.spawnBomb && !bombSpawn.alive) {
            bombCount--;
            bombSpawn.set(x, y, dir, true);
            gp.bombList.add(bombSpawn);
//            spawnTime = 60;
        }
//        spawnTime--;
//        if (enemyCount == 2){
//            gp.playSound(2);
//        } else if (enemyCount == 1) {
//            gp.playSound(3);
//        } else if (enemyCount == 0){
//            gp.playSound(4);
//        } else if (monsterCount == 2) {
//            gp.playSound(5);
//        } else if (monsterCount == 1) {
//            gp.playSound(6);
//        } else if (monsterCount == 0) {
//            gp.playSound(7);
//        }
    }

    public void pickUpItem(int index) {
        if (index != -1) {
            gp.playSound(1);
            switch (gp.items[index].name) {
                case "shoes" -> {
                    shoesCount++;
                    speed++;
                }
                case "heart" -> heartCount++;
                case "bomb" -> bombCount++;
                case "potion" -> potionCount++;
            }
            gp.items[index] = null;
        }
    }

    public void interactEnemy(int index) {
        if (index != -1) {
            if (!invincible) {
                gp.playSound(9);
                heartCount--;
                invincible = true;
            }
        }
    }

    public void interactMonster(int index){
        if (index != -1){
            if (!invincible){
                gp.playSound(9);
                heartCount--;
                invincible = true;
            }
        }
    }

    public void draw(Graphics2D g2) {
        switch (dir) {
            case "up" -> {
                if (verticalNum == 1) {
                    image = up1;
                } else if (verticalNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (verticalNum == 1) {
                    image = down1;
                } else if (verticalNum == 2) {
                    image = down2;
                }
            }
            case "right" -> {
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
            }
            case "left" -> {
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
            }
        }
        if (invincible) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }
        if (dying) {
            dyingCounter++;
            if (dyingCounter > 60) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (dyingCounter > 55) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            } else if (dyingCounter > 50) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (dyingCounter > 45) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (dyingCounter > 40) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            } else if (dyingCounter > 35) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (dyingCounter > 30) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            } else if (dyingCounter > 25) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (dyingCounter > 20) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            } else if (dyingCounter > 15) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (dyingCounter > 10) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            } else if (dyingCounter > 5) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (dyingCounter > 0) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            }
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
