package Item;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Bomb extends Entity {
    public Bomb(GamePanel gp){
        super(gp);
        name = "bomb";
        try {
            down1 = ImageIO.read(new FileInputStream("src/main/resources/items/bomb.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
