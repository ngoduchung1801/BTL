package Item;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Heart extends Entity {
    public Heart(GamePanel gp){
        super(gp);
        name = "heart";
        try {
            down1 = ImageIO.read(new FileInputStream("src/main/resources/items/heart.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
