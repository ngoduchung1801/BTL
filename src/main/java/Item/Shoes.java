package Item;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Shoes extends  Item{
    public Shoes(){
        name = "shoes";
        try {
            image = ImageIO.read(new FileInputStream("src/main/resources/items/myshoes.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
