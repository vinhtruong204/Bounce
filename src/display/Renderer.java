package display;

import java.awt.Graphics;

import game.Game;

public class Renderer {
    public void render(Graphics g, Game game) {
        game.getPlayer().render(g);
        
        
    }
}
