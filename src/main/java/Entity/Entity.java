package Entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    // basic stats
    public int x;
    public int y;
    public int speed;
    public String dir = "down";
    public String name;
    // Image
    public BufferedImage image;
    public BufferedImage up1, up2, up3, up4,
            down1, down2, down3, down4,
            right1, right2, right3, right4, right5, right6,
            left1, left2, left3, left4, left5, left6;
    public BufferedImage bomb1, bomb2, center, vertical, horizontal, up, down, right, left;
    public int Count = 0;
    public int verticalNum = 1;
    public int horizontalNum = 1;
    // Bomb
    public int bombImageNum = 1;
    public int bombLife;
    public int bombMaxLife;
    public int cost;
    public boolean alive;
    public BombSpawn bombSpawn;

    // Hitbox
    public Rectangle hitBox = new Rectangle(0, 0, 48, 48);
    public int hitBoxDefaultX = 0, hitBoxDefaultY = 0;
    public boolean collisionOn = false;
    public boolean bombCollisionToPlayer = false;
    public boolean bombCollisionToEntity = false;
    public int moveCounter = 0; // to change direction for enemy
    public boolean invincible = false; // for player to be invincible for a sec after contact to enemy
    public int invincibleCounter = 0; // count time for invincible
    // Items, also is stats
    public int shoesCount;
    public int heartCount;
    public int bombCount;
    public int potionCount;
    public int itemIndex;
    // Time
    public int minute;
    public double second;
    public Flame flame0, flame1, flame2, flame3, flame4, flame5, flame6, flame7, flame8;
    public String flameDir;
    public int flameLife;
    public int flameMaxLife;
    public int enemyCount;
    public int enemyLife = -1;
    public int monsterLife = -1;
    public int monsterCount;
    public int spawnTime = 60;
    public boolean dying = false;
    public int dyingCounter = 0;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setMove() {
    }

    public void update() {
        setMove();

        collisionOn = false;
        gp.CC.checkTile(this);

        itemIndex = gp.CC.checkItem(this);
        pickUpItem(itemIndex);

        boolean interactPlayer = gp.CC.checkPlayer(this);
        if (interactPlayer && !gp.player.invincible) {
            gp.playSound(9);
            gp.player.heartCount--;
            gp.player.invincible = true;
        }

        gp.CC.entityCheckBomb(this);
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
                verticalNum = 3;
            } else if (verticalNum == 3) {
                verticalNum = 4;
            } else if (verticalNum == 4) {
                verticalNum = 1;
            }
            if (horizontalNum == 1) {
                horizontalNum = 2;
            } else if (horizontalNum == 2) {
                horizontalNum = 3;
            } else if (horizontalNum == 3) {
                horizontalNum = 4;
            } else if (horizontalNum == 4) {
                horizontalNum = 1;
            }
            Count = 0;
        }
        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

        if (monsterLife == 1) {
            speed = 3;
            getImage2();
        }
    }

    public void getImage2() {

    }

    public void pickUpItem(int index) {
        if (index != -1) {
            switch (gp.items[index].name) {
                case "shoes" -> speed++;
                case "heart" -> {
                    enemyLife++;
                    monsterLife++;
                }
            }
            gp.items[index] = null;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (name.equals("explodeBomb")) {
            if (bombImageNum == 1) {
                image = bomb1;
            } else if (bombImageNum == 2) {
                image = bomb2;
            }
        } else {
            switch (dir) {
                case "up" -> {
                    if (verticalNum == 1) {
                        image = up1;
                    } else if (verticalNum == 2) {
                        image = up2;
                    } else if (verticalNum == 3) {
                        image = up3;
                    } else if (verticalNum == 4) {
                        image = up4;
                    }
                }
                case "down" -> {
                    if (verticalNum == 1) {
                        image = down1;
                    } else if (verticalNum == 2) {
                        image = down2;
                    } else if (verticalNum == 3) {
                        image = down3;
                    } else if (verticalNum == 4) {
                        image = down4;
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
                    }
                }
            }
        }
        if (invincible) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}