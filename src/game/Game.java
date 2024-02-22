package game;

import java.awt.Graphics;

import gamestate.GameState;
import gamestate.Menu;
import gamestate.Playing;
import input.KeyHandler;

public class Game {
    private Playing playing;
    private Menu menu;

    public Game(KeyHandler keyHandler) {
        playing = new Playing(keyHandler);
        menu = new Menu(keyHandler);
    }

    public void update() {
        switch (GameState.state) {
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            default:
                break;
        }

    }

    public void render(Graphics g) {
        switch (GameState.state) {
            case MENU:
                menu.render(g);
                break;
            case PLAYING:
                playing.render(g);
                break;
            default:
                break;
        }
    }

}
