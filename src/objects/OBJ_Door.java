package objects;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class OBJ_Door extends SuperObject{

    public OBJ_Door() {
        name = "Door";
        try {
            image = ImageIO.read(new FileInputStream("resources/objects/door.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
