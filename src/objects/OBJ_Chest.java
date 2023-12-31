package objects;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{

    public OBJ_Chest() {
        name = "Chest";
        try {
            image = ImageIO.read(new FileInputStream("resources/objects/chest.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
