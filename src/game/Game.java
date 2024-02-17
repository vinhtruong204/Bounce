package game;

import java.awt.Graphics;

import entity.Player;
import input.KeyHandler;

public class Game {
    private Player player;

    public Game(KeyHandler keyHandler) {
        player = new Player(keyHandler);
    }

    public void update() {
        player.update();
    }

    public void render(Graphics g) {
        player.render(g);
    }

    public Player getPlayer() {
        return player;
    }

}
