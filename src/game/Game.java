package game;

import java.awt.Graphics;

import entity.Player;
import input.KeyHandler;
import levels.LevelManager;

public class Game {
    private Player player;
    private LevelManager map;

    public Game(KeyHandler keyHandler) {
        map = new LevelManager();
        player = new Player(keyHandler, map.getMap());
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
