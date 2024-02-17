package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private boolean[] pressedKey;

    public KeyHandler() {
        pressedKey = new boolean[255];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKey[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKey[e.getKeyCode()] = false;
    }

    public boolean isPressed(int keyCode) {
        return pressedKey[keyCode];
    }

    public boolean[] getPressedKey() {
        return pressedKey;
    }

}
