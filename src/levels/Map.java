package levels;

import java.awt.Graphics;

import load_map.ReadMatrix;

public class Map {
    private int[][] map;
    private Tile tiles;

    public Map() {
        map = ReadMatrix.getMapMatrix();
        tiles = new Tile();
    }

    public void render(Graphics g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    tiles.render(g, i, j);
                }
            }
        }
    }

}
