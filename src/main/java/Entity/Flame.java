package Entity;

import Item.Shoes;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Flame extends Entity {
    public int itemInvincibleTime;

    public Flame(GamePanel gp) {
        super(gp);

        flameMaxLife = 20;
        speed = 0;
        alive = false;

        hitBox.x = 0;
        hitBox.y = 0;
        hitBox.width = 48;
        hitBox.height = 48;
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        getImage();
    }

    public void getImage() {
        try {
            center = ImageIO.read(new FileInputStream("src/main/resources/explode/center.png"));
            vertical = ImageIO.read(new FileInputStream("src/main/resources/explode/vertical.png"));
            horizontal = ImageIO.read(new FileInputStream("src/main/resources/explode/horizontal.png"));
            up = ImageIO.read(new FileInputStream("src/main/resources/explode/up.png"));
            down = ImageIO.read(new FileInputStream("src/main/resources/explode/down.png"));
            right = ImageIO.read(new FileInputStream("src/main/resources/explode/right.png"));
            left = ImageIO.read(new FileInputStream("src/main/resources/explode/left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void set(int x, int y, String flameDir, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
        this.flameDir = flameDir;
        this.flameLife = this.flameMaxLife;
        gp.playSound(12);
    }

    public void update() {
        gp.CC.flameCheckWall(this);

        int enemyIndex = gp.CC.checkEntity(this, gp.enemy);
        interactEnemy(enemyIndex);

        int monsterIndex = gp.CC.checkEntity(this, gp.monster);
        interactMonster(monsterIndex);

        int brickIndex = gp.CC.flameCheckBrick(this);
        destroyBrick(brickIndex);

        itemInvincibleTime--;
        if (itemInvincibleTime <= 0) {
            itemIndex = gp.CC.checkItem(this);
            destroyItem(itemIndex);
        }

        boolean interactPlayer = gp.CC.checkPlayer(this);
        if (interactPlayer && !gp.player.invincible) {
            gp.playSound(9);
            gp.player.heartCount--;
            gp.player.invincible = true;
        }

        flameLife--;
        if (flameLife <= 0) {
            alive = false;
        }

        if (gp.player.enemyCount == 0) {
//            if (gp.player.outroTime < 0) {
                gp.gameState = gp.stage2State;
                gp.stage2SetUp();
//            } else {
//                gp.player.outroTime--;
//            }
        }

        if (gp.player.monsterCount == 0) {
            gp.gameState = gp.winState;
        }
    }


    public void interactEnemy(int index) {
        if (index != -1) {
            if (!gp.enemy[index].invincible && gp.enemy[index].enemyLife >= 1) {
                gp.playSound(10);
                gp.enemy[index].enemyLife--;
                gp.enemy[index].invincible = true;
            }
            if (gp.enemy[index].enemyLife == 0) {
                gp.enemy[index] = null;
                gp.player.enemyCount--;
                if (gp.player.enemyCount == 2) {
                    gp.playSound(2);
                } else if (gp.player.enemyCount == 1) {
                    gp.playSound(3);
                } else if (gp.player.enemyCount == 0) {
                    gp.playSound(4);
                }
            }
        }
    }

    public void interactMonster(int index) {
        if (index != -1) {
            if (!gp.monster[index].invincible && gp.monster[index].monsterLife >= 1) {
                gp.playSound(10);
                gp.monster[index].monsterLife--;
                gp.monster[index].invincible = true;
            }
            if (gp.monster[index].monsterLife == 0) {
                gp.monster[index] = null;
                gp.player.monsterCount--;
                if (gp.player.monsterCount == 2) {
                    gp.playSound(5);
                } else if (gp.player.monsterCount == 1) {
                    gp.playSound(6);
                } else if (gp.player.monsterCount == 0) {
                    gp.playSound(8);
                }
            }
        }
    }

    public void destroyItem(int index) {
        if (index != -1) {
            gp.items[index] = null;
        }
    }

    public void destroyBrick(int index) {
        if (index != -1) {
            itemInvincibleTime = 30;
            gp.brick[index] = null;
        }
    }

    public void checkDrop(int index) {
        if (index == 8) {
            dropItem(new Shoes(gp));
        }
    }

    public void dropItem(Entity dropItem) {
        for (int i = 0; i < gp.items.length; i++) {
            if (gp.items[i] == null) {
                gp.items[i] = dropItem;
                gp.items[i].x = 144;
                gp.items[i].y = 240;
                break;
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if (alive) {
            image = null;
            switch (flameDir) {
                case "center" -> image = center;
                case "up" -> image = up;
                case "down" -> image = down;
                case "right" -> image = right;
                case "left" -> image = left;
                case "vertical" -> image = vertical;
                case "horizontal" -> image = horizontal;
            }
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }
    }
}