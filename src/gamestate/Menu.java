package gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import input.KeyHandler;

public class Menu implements StateMethods {

    private KeyHandler keyHandler;

    public Menu(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }

    @Override
    public void update() {
        if (keyHandler.isPressed(KeyEvent.VK_ENTER)) {
            GameState.state = GameState.PLAYING;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.drawString("Press Enter to play!", 720 / 2 - 50, 480 / 2);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            GameState.state = GameState.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
