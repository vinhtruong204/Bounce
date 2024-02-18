package game;

import java.awt.Graphics;

import entity.Player;
import input.KeyHandler;
import levels.Map;

public class Game {
    private Player player;
    private Map map;

    public Game(KeyHandler keyHandler) {
        player = new Player(keyHandler);
        map = new Map();
    }

    public void update() {
        player.update();
    }

    public void render(Graphics g) {
        map.render(g);
        player.render(g);
    }

    public Player getPlayer() {
        return player;
    }

}
