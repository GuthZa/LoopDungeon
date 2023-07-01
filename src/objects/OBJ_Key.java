package objects;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class OBJ_Key extends SuperObject {
    public OBJ_Key() {
        name = "Key";
        try {
            image = ImageIO.read(new FileInputStream("resources/objects/key.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
