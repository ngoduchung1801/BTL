package Main;

import Entity.Enemy;
import Entity.Monster;
import Item.*;
import Tile.DestroyableTile;

public class Setup {
    GamePanel gp;

    public Setup(GamePanel gp) {
        this.gp = gp;
    }

    public void setItem() {
        gp.items[0] = new Shoes(gp);
        gp.items[0].x = 3 * gp.tileSize;
        gp.items[0].y = 5 * gp.tileSize;

        gp.items[1] = new Heart(gp);
        gp.items[1].x = 13 * gp.tileSize;
        gp.items[1].y = 3 * gp.tileSize;

        gp.items[2] = new Shoes(gp);
        gp.items[2].x = 11 * gp.tileSize;
        gp.items[2].y = 13 * gp.tileSize;

        gp.items[3] = new Heart(gp);
        gp.items[3].x = 7 * gp.tileSize;
        gp.items[3].y = 7 * gp.tileSize;

//        gp.items[4] = new Potion(gp);
//        gp.items[4].x = gp.tileSize;
//        gp.items[4].y = 2 * gp.tileSize;
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

    public void setBrick_1() {
        gp.brick[0] = new DestroyableTile(gp);
        gp.brick[0].x = gp.tileSize;
        gp.brick[0].y = 11 * gp.tileSize;

        gp.brick[1] = new DestroyableTile(gp);
        gp.brick[1].x = 3 * gp.tileSize;
        gp.brick[1].y = 13 * gp.tileSize;

        gp.brick[2] = new DestroyableTile(gp);
        gp.brick[2].x = 3 * gp.tileSize;
        gp.brick[2].y = gp.tileSize;

        gp.brick[3] = new DestroyableTile(gp);
        gp.brick[3].x = gp.tileSize;
        gp.brick[3].y = 3 * gp.tileSize;

        gp.brick[4] = new DestroyableTile(gp);
        gp.brick[4].x = 4 * gp.tileSize;
        gp.brick[4].y = gp.tileSize;

        gp.brick[5] = new DestroyableTile(gp);
        gp.brick[5].x = 5 * gp.tileSize;
        gp.brick[5].y = 2 * gp.tileSize;

        gp.brick[6] = new DestroyableTile(gp);
        gp.brick[6].x = 3 * gp.tileSize;
        gp.brick[6].y = 3 * gp.tileSize;

        gp.brick[7] = new DestroyableTile(gp);
        gp.brick[7].x = 3 * gp.tileSize;
        gp.brick[7].y = 4 * gp.tileSize;

        gp.brick[8] = new DestroyableTile(gp);
        gp.brick[8].x = 3 * gp.tileSize;
        gp.brick[8].y = 5 * gp.tileSize;

        gp.brick[9] = new DestroyableTile(gp);
        gp.brick[9].x = gp.tileSize;
        gp.brick[9].y = 10 * gp.tileSize;

        gp.brick[10] = new DestroyableTile(gp);
        gp.brick[10].x = 13 * gp.tileSize;
        gp.brick[10].y = 11 * gp.tileSize;

        gp.brick[11] = new DestroyableTile(gp);
        gp.brick[11].x = 11 * gp.tileSize;
        gp.brick[11].y = 12 * gp.tileSize;

        gp.brick[12] = new DestroyableTile(gp);
        gp.brick[12].x = 9 * gp.tileSize;
        gp.brick[12].y = 13 * gp.tileSize;

        gp.brick[13] = new DestroyableTile(gp);
        gp.brick[13].x = 3 * gp.tileSize;
        gp.brick[13].y = 11 * gp.tileSize;

        gp.brick[14] = new DestroyableTile(gp);
        gp.brick[14].x = 4 * gp.tileSize;
        gp.brick[14].y = 11 * gp.tileSize;

        gp.brick[15] = new DestroyableTile(gp);
        gp.brick[15].x = 5 * gp.tileSize;
        gp.brick[15].y = 10 * gp.tileSize;

        gp.brick[16] = new DestroyableTile(gp);
        gp.brick[16].x = 7 * gp.tileSize;
        gp.brick[16].y = 7 * gp.tileSize;

        gp.brick[17] = new DestroyableTile(gp);
        gp.brick[17].x = 5 * gp.tileSize;
        gp.brick[17].y = 12 * gp.tileSize;

        gp.brick[18] = new DestroyableTile(gp);
        gp.brick[18].x = 5 * gp.tileSize;
        gp.brick[18].y = 13 * gp.tileSize;

        gp.brick[19] = new DestroyableTile(gp);
        gp.brick[19].x = 11 * gp.tileSize;
        gp.brick[19].y = gp.tileSize;

        gp.brick[20] = new DestroyableTile(gp);
        gp.brick[20].x = 12 * gp.tileSize;
        gp.brick[20].y = 3 * gp.tileSize;

        gp.brick[21] = new DestroyableTile(gp);
        gp.brick[21].x = 12 * gp.tileSize;
        gp.brick[21].y = 5 * gp.tileSize;

        gp.brick[22] = new DestroyableTile(gp);
        gp.brick[22].x = 13 * gp.tileSize;
        gp.brick[22].y = 7 * gp.tileSize;

        gp.brick[23] = new DestroyableTile(gp);
        gp.brick[23].x = 11 * gp.tileSize;
        gp.brick[23].y = 7 * gp.tileSize;

        gp.brick[24] = new DestroyableTile(gp);
        gp.brick[24].x = 11 * gp.tileSize;
        gp.brick[24].y = 8 * gp.tileSize;

        gp.brick[25] = new DestroyableTile(gp);
        gp.brick[25].x = gp.tileSize;
        gp.brick[25].y = 6 * gp.tileSize;

        gp.brick[26] = new DestroyableTile(gp);
        gp.brick[26].x = 3 * gp.tileSize;
        gp.brick[26].y = 7 * gp.tileSize;

        gp.brick[27] = new DestroyableTile(gp);
        gp.brick[27].x = 4 * gp.tileSize;
        gp.brick[27].y = 9 * gp.tileSize;

        gp.brick[28] = new DestroyableTile(gp);
        gp.brick[28].x = 13 * gp.tileSize;
        gp.brick[28].y = 9 * gp.tileSize;

        gp.brick[29] = new DestroyableTile(gp);
        gp.brick[29].x = 5 * gp.tileSize;
        gp.brick[29].y = 7 * gp.tileSize;

        gp.brick[30] = new DestroyableTile(gp);
        gp.brick[30].x = 7 * gp.tileSize;
        gp.brick[30].y = 5 * gp.tileSize;

        gp.brick[31] = new DestroyableTile(gp);
        gp.brick[31].x = 9 * gp.tileSize;
        gp.brick[31].y = 7 * gp.tileSize;

        gp.brick[32] = new DestroyableTile(gp);
        gp.brick[32].x = 7 * gp.tileSize;
        gp.brick[32].y = 9 * gp.tileSize;

        gp.brick[33] = new DestroyableTile(gp);
        gp.brick[33].x = 7 * gp.tileSize;
        gp.brick[33].y = 12 * gp.tileSize;

        gp.brick[34] = new DestroyableTile(gp);
        gp.brick[34].x = 9 * gp.tileSize;
        gp.brick[34].y = 11 * gp.tileSize;

        gp.brick[35] = new DestroyableTile(gp);
        gp.brick[35].x = 10 * gp.tileSize;
        gp.brick[35].y = 3 * gp.tileSize;

        gp.brick[36] = new DestroyableTile(gp);
        gp.brick[36].x = 9 * gp.tileSize;
        gp.brick[36].y = 4 * gp.tileSize;
    }

    public void setMonster() {
        gp.monster[0] = new Monster(gp);
        gp.monster[0].x = gp.tileSize;
        gp.monster[0].y = 13 * gp.tileSize;

        gp.monster[1] = new Monster(gp);
        gp.monster[1].x = 13 * gp.tileSize;
        gp.monster[1].y = gp.tileSize;

        gp.monster[2] = new Monster(gp);
        gp.monster[2].x = 13 * gp.tileSize;
        gp.monster[2].y = 13 * gp.tileSize;
    }

    public void setItem_2() {
        gp.items[0] = new Shoes(gp);
        gp.items[0].x = gp.tileSize;
        gp.items[0].y = 6 * gp.tileSize;

        gp.items[1] = new Shoes(gp);
        gp.items[1].x = 13 * gp.tileSize;
        gp.items[1].y = 7 * gp.tileSize;

        gp.items[2] = new Heart(gp);
        gp.items[2].x = 9 * gp.tileSize;
        gp.items[2].y = 7 * gp.tileSize;

        gp.items[3] = new Heart(gp);
        gp.items[3].x = 3 *gp.tileSize;
        gp.items[3].y = 10 * gp.tileSize;
    }

    public void setBrick_2() {
        gp.brick[0] = new DestroyableTile(gp);
        gp.brick[0].x = gp.tileSize;
        gp.brick[0].y = 11 * gp.tileSize;

        gp.brick[1] = new DestroyableTile(gp);
        gp.brick[1].x = 8 * gp.tileSize;
        gp.brick[1].y = 11 * gp.tileSize;

        gp.brick[2] = new DestroyableTile(gp);
        gp.brick[2].x = 11 * gp.tileSize;
        gp.brick[2].y = 8 * gp.tileSize;

        gp.brick[3] = new DestroyableTile(gp);
        gp.brick[3].x = 6 * gp.tileSize;
        gp.brick[3].y = 13 * gp.tileSize;

        gp.brick[4] = new DestroyableTile(gp);
        gp.brick[4].x = 13 * gp.tileSize;
        gp.brick[4].y = 2 * gp.tileSize;

        gp.brick[5] = new DestroyableTile(gp);
        gp.brick[5].x = 7 * gp.tileSize;
        gp.brick[5].y = 12 * gp.tileSize;

        gp.brick[6] = new DestroyableTile(gp);
        gp.brick[6].x = 3 * gp.tileSize;
        gp.brick[6].y = 9 * gp.tileSize;

        gp.brick[7] = new DestroyableTile(gp);
        gp.brick[7].x = 12 * gp.tileSize;
        gp.brick[7].y = 3 * gp.tileSize;

        gp.brick[8] = new DestroyableTile(gp);
        gp.brick[8].x = 5 * gp.tileSize;
        gp.brick[8].y = 11 * gp.tileSize;

        gp.brick[9] = new DestroyableTile(gp);
        gp.brick[9].x = 4 * gp.tileSize;
        gp.brick[9].y = gp.tileSize;

        gp.brick[10] = new DestroyableTile(gp);
        gp.brick[10].x = 6 * gp.tileSize;
        gp.brick[10].y = 5 * gp.tileSize;

        gp.brick[11] = new DestroyableTile(gp);
        gp.brick[11].x = 12 * gp.tileSize;
        gp.brick[11].y = 7 * gp.tileSize;

        gp.brick[12] = new DestroyableTile(gp);
        gp.brick[12].x = 6 * gp.tileSize;
        gp.brick[12].y = 13 * gp.tileSize;

        gp.brick[13] = new DestroyableTile(gp);
        gp.brick[13].x = 3 * gp.tileSize;
        gp.brick[13].y = 2 * gp.tileSize;

        gp.brick[14] = new DestroyableTile(gp);
        gp.brick[14].x = 9 * gp.tileSize;
        gp.brick[14].y = 12 * gp.tileSize;

        gp.brick[15] = new DestroyableTile(gp);
        gp.brick[15].x = 5 * gp.tileSize;
        gp.brick[15].y = 10 * gp.tileSize;

        gp.brick[16] = new DestroyableTile(gp);
        gp.brick[16].x = 13 * gp.tileSize;
        gp.brick[16].y = 7 * gp.tileSize;

        gp.brick[17] = new DestroyableTile(gp);
        gp.brick[17].x = gp.tileSize;
        gp.brick[17].y = 10 * gp.tileSize;

        gp.brick[18] = new DestroyableTile(gp);
        gp.brick[18].x = gp.tileSize;
        gp.brick[18].y = 6 * gp.tileSize;

        gp.brick[19] = new DestroyableTile(gp);
        gp.brick[19].x = 3 * gp.tileSize;
        gp.brick[19].y = 10 * gp.tileSize;

        gp.brick[20] = new DestroyableTile(gp);
        gp.brick[20].x = 11 * gp.tileSize;
        gp.brick[20].y = 9 * gp.tileSize;

        gp.brick[21] = new DestroyableTile(gp);
        gp.brick[21].x = 10 * gp.tileSize;
        gp.brick[21].y = 3 * gp.tileSize;

        gp.brick[22] = new DestroyableTile(gp);
        gp.brick[22].x = 13 * gp.tileSize;
        gp.brick[22].y = 8 * gp.tileSize;

        gp.brick[23] = new DestroyableTile(gp);
        gp.brick[23].x = 10 * gp.tileSize;
        gp.brick[23].y = 9 * gp.tileSize;

        gp.brick[24] = new DestroyableTile(gp);
        gp.brick[24].x = 9 * gp.tileSize;
        gp.brick[24].y = 7 * gp.tileSize;

        gp.brick[25] = new DestroyableTile(gp);
        gp.brick[25].x = 5 * gp.tileSize;
        gp.brick[25].y = 4 * gp.tileSize;

        gp.brick[26] = new DestroyableTile(gp);
        gp.brick[26].x = 3 * gp.tileSize;
        gp.brick[26].y = 12 * gp.tileSize;

        gp.brick[27] = new DestroyableTile(gp);
        gp.brick[27].x = 4 * gp.tileSize;
        gp.brick[27].y = 7 * gp.tileSize;

        gp.brick[28] = new DestroyableTile(gp);
        gp.brick[28].x = 2 * gp.tileSize;
        gp.brick[28].y = 5 * gp.tileSize;

        gp.brick[29] = new DestroyableTile(gp);
        gp.brick[29].x = 9 * gp.tileSize;
        gp.brick[29].y = gp.tileSize;

        gp.brick[30] = new DestroyableTile(gp);
        gp.brick[30].x = 5 * gp.tileSize;
        gp.brick[30].y = 3 * gp.tileSize;

        gp.brick[31] = new DestroyableTile(gp);
        gp.brick[31].x = 9 * gp.tileSize;
        gp.brick[31].y = 11 * gp.tileSize;

        gp.brick[32] = new DestroyableTile(gp);
        gp.brick[32].x = 7 * gp.tileSize;
        gp.brick[32].y = 4 * gp.tileSize;

        gp.brick[33] = new DestroyableTile(gp);
        gp.brick[33].x = 9 * gp.tileSize;
        gp.brick[33].y = 9 * gp.tileSize;

        gp.brick[34] = new DestroyableTile(gp);
        gp.brick[34].x = 6 * gp.tileSize;
        gp.brick[34].y = 5 * gp.tileSize;

        gp.brick[35] = new DestroyableTile(gp);
        gp.brick[35].x = gp.tileSize;
        gp.brick[35].y = 3 * gp.tileSize;

        gp.brick[36] = new DestroyableTile(gp);
        gp.brick[36].x = 11 * gp.tileSize;
        gp.brick[36].y = 5 * gp.tileSize;
    }
}
