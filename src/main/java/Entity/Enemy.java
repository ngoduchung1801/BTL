package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Enemy extends Entity{
    public Enemy(GamePanel gp) {
        super(gp);

        speed = 1;
        dir = "down";
        name = "enemy";

        hitBox.x = 1; // 8
        hitBox.y = 1; // 4
        hitBox.width = 46; // 32
        hitBox.height = 46; // 40
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        getImage();
    }

    public void getImage(){
        try {
            up1 = ImageIO.read(new FileInputStream("src/main/resources/enemy/up1.png"));
            up2 = ImageIO.read(new FileInputStream("src/main/resources/enemy/up2.png"));
            up3 = ImageIO.read(new FileInputStream("src/main/resources/enemy/up3.png"));
            up4 = ImageIO.read(new FileInputStream("src/main/resources/enemy/up4.png"));
            down1 = ImageIO.read(new FileInputStream("src/main/resources/enemy/down1.png"));
            down2 = ImageIO.read(new FileInputStream("src/main/resources/enemy/down2.png"));
            down3 = ImageIO.read(new FileInputStream("src/main/resources/enemy/down3.png"));
            down4 = ImageIO.read(new FileInputStream("src/main/resources/enemy/down4.png"));
            right1 = ImageIO.read(new FileInputStream("src/main/resources/enemy/right1.png"));
            right2 = ImageIO.read(new FileInputStream("src/main/resources/enemy/right2.png"));
            right3 = ImageIO.read(new FileInputStream("src/main/resources/enemy/right3.png"));
            right4 = ImageIO.read(new FileInputStream("src/main/resources/enemy/right4.png"));
            left1 = ImageIO.read(new FileInputStream("src/main/resources/enemy/left1.png"));
            left2 = ImageIO.read(new FileInputStream("src/main/resources/enemy/left2.png"));
            left3 = ImageIO.read(new FileInputStream("src/main/resources/enemy/left3.png"));
            left4 = ImageIO.read(new FileInputStream("src/main/resources/enemy/left4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMove(){
        moveCounter++;
        if (moveCounter == 48){
            Random random = new Random();
            int randomMove = random.nextInt(4) + 1;

            if (randomMove == 1){
                dir = "up";
            }
            if (randomMove == 2){
                dir = "down";
            }
            if (randomMove == 3){
                dir = "right";
            }
            if (randomMove == 4){
                dir = "left";
            }
            moveCounter = 0;
        }
    }
}
