package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;
    public BufferedImage up1, up2, down1, down2,
            right1, right2, right3, right4, right5, right6,
            left1, left2, left3, left4, left5, left6;
    public String dir;
    public int Count = 0;
    public int verticalNum = 1;
    public int horizontalNum = 1;
    public Rectangle hitBox;

    public boolean collisionOn = false;
}
