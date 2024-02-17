package game;

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

    public Player getPlayer() {
        return player;
    }

}
