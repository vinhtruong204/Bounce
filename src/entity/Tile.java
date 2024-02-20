package entity;

import java.awt.Graphics;

import animation.LoadSave;
import core.Size;

public class Tile extends GameObject {
    public static final int TILE_WIDTH = 40;
    public static final int TILE_HEIGHT = 40;

    public Tile() {
        image = LoadSave.getSpriteImage("img/tile.png");
        size = new Size(TILE_WIDTH, TILE_HEIGHT);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(
                image,
                position.getX(),
                position.getY(),
                TILE_WIDTH,
                TILE_HEIGHT,
                null);
    }
}
