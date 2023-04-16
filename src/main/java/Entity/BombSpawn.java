package Entity;

import Main.GamePanel;

public class BombSpawn extends Entity {

    public BombSpawn(GamePanel gp) {
        super(gp);
    }

    public void set(int x, int y, String dir, boolean alive) {
        this.x = ((x + 24) / 48) * 48;
        this.y = ((y + 24) / 48) * 48;
        this.dir = dir;
        this.alive = alive;
        this.bombLife = this.bombMaxLife;

        bombImageNum = 1;
    }

    public void update() {
        bombLife--;
        if (bombLife <= 0) {
            alive = false;
        }

        if (bombLife > 150) {
            Count++;
            if (Count > 20) {
                if (bombImageNum == 1) {
                    bombImageNum = 2;
                } else if (bombImageNum == 2) {
                    bombImageNum = 1;
                }
                Count = 0;
            }
        } else if (bombLife > 90) {
            Count++;
            if (Count > 6) {
                if (bombImageNum == 1) {
                    bombImageNum = 2;
                } else if (bombImageNum == 2) {
                    bombImageNum = 1;
                }
                Count = 0;
            }
        } else if (bombLife > 30) {
            Count++;
            if (Count > 2) {
                if (bombImageNum == 1) {
                    bombImageNum = 2;
                } else if (bombImageNum == 2) {
                    bombImageNum = 1;
                }
                Count = 0;
            }
        } else if (bombLife > 0) {
            bombExplodeImage = 0;
            bombImageNum = bombExplodeImage;
        }
    }
}
