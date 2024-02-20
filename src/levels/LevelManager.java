package levels;

import java.awt.Graphics;

import core.Position;
import load_map.ReadMap;
import entity.Tile;

public class LevelManager {
    private int[][] map;
    private Tile tiles;

    public LevelManager() {
        map = ReadMap.getMapMatrix();
        tiles = new Tile();
    }


    public void render(Graphics g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    tiles.setPosition(new Position(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT));
                    tiles.render(g);
                }
            }
        }
    }

    public int[][] getMap() {
        return map;
    }

}
