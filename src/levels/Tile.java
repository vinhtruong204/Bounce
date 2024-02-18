package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import animation.LoadSave;

public class Tile {
    public static final int TILE_WIDTH = 40;
    public static final int TILE_HEIGHT = 40;

    private BufferedImage tile;

    public Tile() {
        tile = LoadSave.getSpriteImage("img/tile.png");
    }

    public void render(Graphics g, int i, int j) {
        g.drawImage(tile, j * TILE_WIDTH, i * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT, null);
    }
}
