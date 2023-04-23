package Item;

import Entity.BombSpawn;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class BombToUse extends BombSpawn {
    GamePanel gp;
    public BombToUse(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "explodeBomb";
        bombMaxLife = 180; //3s
        bombLife = bombMaxLife;
        cost = 1;
        alive = false;

        hitBox.x = 0;
        hitBox.y = 0;
        hitBox.width = 48;
        hitBox.height = 48;
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

//        bombCollisionToEntity = false;

        getImage();
    }
    public void getImage(){
        try {
            bomb1 = ImageIO.read(new FileInputStream("src/main/resources/items/bomb1.png"));
            bomb2 = ImageIO.read(new FileInputStream("src/main/resources/items/bomb2.png"));

            center = ImageIO.read(new FileInputStream("src/main/resources/explode/center.png"));
            vertical = ImageIO.read(new FileInputStream("src/main/resources/explode/vertical.png"));
            horizontal = ImageIO.read(new FileInputStream("src/main/resources/explode/horizontal.png"));
            up = ImageIO.read(new FileInputStream("src/main/resources/explode/up.png"));
            down = ImageIO.read(new FileInputStream("src/main/resources/explode/down.png"));
            right = ImageIO.read(new FileInputStream("src/main/resources/explode/right.png"));
            left = ImageIO.read(new FileInputStream("src/main/resources/explode/left.png"));

            up1 = bomb1;
            up2 = bomb2;
            up3 = bomb1;
            up4 = bomb1;

            down1 = bomb1;
            down2 = bomb2;
            down3 = bomb1;
            down4 = bomb2;

            right1 = bomb1;
            right2 = bomb2;
            right3 = bomb1;
            right4 = bomb2;

            left1 = bomb1;
            left2 = bomb2;
            left3 = bomb1;
            left4 = bomb2;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
