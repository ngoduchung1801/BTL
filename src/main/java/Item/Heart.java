package Item;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Heart extends Item{
    public Heart(){
        name = "heart";
        try {
            image = ImageIO.read(new FileInputStream("src/main/resources/items/heart.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
