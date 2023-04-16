package Item;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Potion extends Entity {
    public Potion(GamePanel gp){
        super(gp);
        name = "potion";
        try{
            down1 = ImageIO.read(new FileInputStream("src/main/resources/items/potion.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
