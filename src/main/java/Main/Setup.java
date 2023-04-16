package Main;

import Entity.Enemy;
import Item.*;

public class Setup {
    GamePanel gp;

    public Setup(GamePanel gp) {
        this.gp = gp;
    }

    public void setItem() {
        gp.items[0] = new Shoes(gp);
        gp.items[0].x = 5 * gp.tileSize;
        gp.items[0].y = 5 * gp.tileSize;

        gp.items[1] = new Shoes(gp);
        gp.items[1].x = 3 * gp.tileSize;
        gp.items[1].y = 10 * gp.tileSize;

        gp.items[2] = new Heart(gp);
        gp.items[2].x = 7 * gp.tileSize;
        gp.items[2].y = 8 * gp.tileSize;

        gp.items[3] = new Bomb(gp);
        gp.items[3].x = 9 * gp.tileSize;
        gp.items[3].y = 8 * gp.tileSize;

        gp.items[4] = new Potion(gp);
        gp.items[4].x = 11 * gp.tileSize;
        gp.items[4].y = 4 * gp.tileSize;
    }

    public void setBomb() {
        gp.bombSpawn = new BombToUse(gp);
        gp.bombSpawn.x = 3 * gp.tileSize;
        gp.bombSpawn.y = 3 * gp.tileSize;
    }

    public void setEnemy() {
        gp.enemy[0] = new Enemy(gp);
        gp.enemy[0].x = gp.tileSize;
        gp.enemy[0].y = 13 * gp.tileSize;

        gp.enemy[1] = new Enemy(gp);
        gp.enemy[1].x = 13 * gp.tileSize;
        gp.enemy[1].y = gp.tileSize;

        gp.enemy[2] = new Enemy(gp);
        gp.enemy[2].x = 13 * gp.tileSize;
        gp.enemy[2].y = 13 * gp.tileSize;
    }
}
