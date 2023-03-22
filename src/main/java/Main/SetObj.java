package Main;

import Item.Bomb;
import Item.Heart;
import Item.Potion;
import Item.Shoes;

public class SetObj {
    GamePanel gp;
    public SetObj(GamePanel gp){
        this.gp = gp;
    }
    public void setItem(){
        gp.items[0] = new Shoes();
        gp.items[0].x = 5 * gp.tileSize;
        gp.items[0].y = 4 * gp.tileSize;

        gp.items[1] = new Shoes();
        gp.items[1].x = 3 * gp.tileSize;
        gp.items[1].y = 10 * gp.tileSize;

        gp.items[2] = new Heart();
        gp.items[2].x = 7 * gp.tileSize;
        gp.items[2].y = 8 * gp.tileSize;

        gp.items[3] = new Bomb();
        gp.items[3].x = 9 * gp.tileSize;
        gp.items[3].y = 8 * gp.tileSize;

        gp.items[4] = new Potion();
        gp.items[4].x = 11 * gp.tileSize;
        gp.items[4].y = 4 * gp.tileSize;
    }
}
