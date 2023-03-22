package Item;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Bomb extends Item{
    public Bomb(){
        name = "bomb";
        try {
            image = ImageIO.read(new FileInputStream("src/main/resources/items/bomb.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
