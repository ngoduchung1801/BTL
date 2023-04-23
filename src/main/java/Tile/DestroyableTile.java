package Tile;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class DestroyableTile extends Entity {
    public DestroyableTile(GamePanel gp) {
        super(gp);
        name = "brick_1";

        try {
            down1 = ImageIO.read(new FileInputStream("src/main/resources/brick/1.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
