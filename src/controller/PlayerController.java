package controller;

import java.awt.event.KeyEvent;

import input.KeyHandler;

public class PlayerController implements Controller {
    private KeyHandler input;

    public PlayerController(KeyHandler input) {
        this.input = input;
    }

    @Override
    public boolean isPressedUp() {
        return input.isPressed(KeyEvent.VK_W);
    }

    @Override
    public boolean isPressedDown() {
        return input.isPressed(KeyEvent.VK_S);
    }

    @Override
    public boolean isPressedRight() {
        return input.isPressed(KeyEvent.VK_D);
    }

    @Override
    public boolean isPressedLeft() {
        return input.isPressed(KeyEvent.VK_A);
    }

    public KeyHandler getInput() {
        return input;
    }
}
