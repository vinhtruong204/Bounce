package animation;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class LoadSave {
    public static BufferedImage getSpriteImage(String filePath) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();;
        }

        return img;
    }
}
