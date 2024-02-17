package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.Position;
import core.Size;

public abstract class GameObject {
    protected Position position;
    protected Size size;
    protected BufferedImage image;

    protected void loadImage(String filePath) {
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.err.println("Could not load file from path: " + filePath);
        }
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }

    public BufferedImage getImage() {
        return image;
    }

    public abstract void update();
    public abstract void render(Graphics g);
}
