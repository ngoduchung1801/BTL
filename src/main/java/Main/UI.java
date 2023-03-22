package Main;

import Item.Bomb;
import Item.Heart;
import Item.Potion;
import Item.Shoes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UI {
    GamePanel gp;
    Font font;
    BufferedImage Heart, Potion, Bomb, Shoes;
    int minute = 2;
    double second = 59;

    NumberFormat numberFormat = new DecimalFormat("#0");

    public UI(GamePanel gp) {
        this.gp = gp;
        font = new Font("Ariel", 1, 30);

        Heart heart = new Heart();
        Heart = heart.image;

        Potion potion = new Potion();
        Potion = potion.image;

        Bomb bomb = new Bomb();
        Bomb = bomb.image;

        Shoes shoes = new Shoes();
        Shoes = shoes.image;
    }

    public void draw(Graphics2D g2) {
        g2.setFont(font);
        g2.setColor(Color.red);
        g2.drawImage(Heart, 725, 50, gp.tileSize, gp.tileSize, null);
        g2.drawString("x" + gp.player.heartCount, 730 + gp.tileSize, 85);

        g2.drawImage(Potion, 725, 90, gp.tileSize, gp.tileSize, null);
        g2.drawString("+" + gp.player.potionCount, 730 + gp.tileSize, 130);

        g2.setColor(Color.black);
        g2.drawImage(Bomb, 725, 140, gp.tileSize, gp.tileSize, null);
        g2.drawString("x" + gp.player.bombCount, 730 + gp.tileSize, 175);
        g2.drawImage(Shoes, 730, 185, gp.tileSize, gp.tileSize, null);
        g2.drawString("+" + gp.player.shoesCount, 730 + gp.tileSize, 220);

        if (minute == 0 && second <= 0.0000001) {
            g2.drawString("0:0", 48, 40);
        } else if (minute > 0 && second <= 0) {
            minute--;
            second = 59;
        } else {
            second -= (double) 1 / 60;
            g2.drawString(minute + ":" + numberFormat.format(second), 48, 40);
        }
    }

}


