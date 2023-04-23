package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Monster extends Entity{

    public Monster(GamePanel gp) {
        super(gp);

        speed = 2;
        dir = "down";
        name = "monster";
        monsterLife = 2;
        invincible = false;

        hitBox.x = 4; //8
        hitBox.y = 4; //4
        hitBox.width = 40; //32
        hitBox.height = 40; //40
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        getImage1();
    }

    public void getImage1(){
        try {
            up1 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/up1.png"));
            up2 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/up2.png"));
            up3 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/up3.png"));
            up4 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/up4.png"));
            down1 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/down1.png"));
            down2 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/down2.png"));
            down3 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/down3.png"));
            down4 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/down4.png"));
            right1 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/right1.png"));
            right2 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/right2.png"));
            right3 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/right3.png"));
            right4 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/right4.png"));
            left1 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/left1.png"));
            left2 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/left2.png"));
            left3 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/left3.png"));
            left4 = ImageIO.read(new FileInputStream("src/main/resources/monster/1/left4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getImage2(){
        try {
            up1 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/up1.png"));
            up2 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/up2.png"));
            up3 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/up3.png"));
            up4 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/up4.png"));
            down1 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/down1.png"));
            down2 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/down2.png"));
            down3 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/down3.png"));
            down4 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/down4.png"));
            right1 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/right1.png"));
            right2 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/right2.png"));
            right3 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/right3.png"));
            right4 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/right4.png"));
            left1 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/left1.png"));
            left2 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/left2.png"));
            left3 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/left3.png"));
            left4 = ImageIO.read(new FileInputStream("src/main/resources/monster/2/left4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMove() {
        moveCounter++;
        if (moveCounter == 48) {
            Random random = new Random();
            int randomMove = random.nextInt(4) + 1; //4

            if (randomMove == 1) {
                dir = "up";
            }
            if (randomMove == 2) {
                dir = "down";
            }
            if (randomMove == 3) {
                dir = "right";
            }
            if (randomMove == 4) {
                dir = "left";
            }
            moveCounter = 0;
        }
    }
}
