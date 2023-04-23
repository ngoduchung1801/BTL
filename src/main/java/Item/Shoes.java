package Item;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Shoes extends Entity {
    public Shoes(GamePanel gp){
        super(gp);

        name = "shoes";
        hitBox.x = 2;
        hitBox.y = 2;
        hitBox.width = 44;
        hitBox.height = 44;
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        try {
            down1 = ImageIO.read(new FileInputStream("src/main/resources/items/myshoes.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
