package Item;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Potion extends Item{
    public Potion(){
        name = "potion";
        try{
            image = ImageIO.read(new FileInputStream("src/main/resources/items/potion.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
