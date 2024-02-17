package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controller.PlayerController;
import core.Position;
import core.Size;
import core.Vector2D;
import input.KeyHandler;

public class Player extends GameObject {
    private final int PLAYER_WIDTH = 58;
    private final int PLAYER_HEIGHT = 58;

    private PlayerController controller;
    private Vector2D velocity;
    private int speed;

    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed;

    public Player(KeyHandler keyHandler) {
        // Load image and set size
        super.loadImage("img/1-Player-Bomb Guy.png");
        position = new Position(0, 0);
        size = new Size(PLAYER_WIDTH, PLAYER_HEIGHT);

        // Initialize controller
        controller = new PlayerController(keyHandler);
        velocity = new Vector2D(0, 0);
        speed = 5;

        // Set animation sprite sheet
        animations = new BufferedImage[6][26];
        loadAnimations();
        aniTick = 0;
        aniIndex = 0;
        aniSpeed = 10; // 15 animation frames per second
    }

    private void loadAnimations() {
        for (int i = 0; i < animations.length; i++)
            for (int j = 0; j < animations[i].length; j++)
                animations[i][j] = image.getSubimage(j * PLAYER_WIDTH, i * PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    private void updateAnimationTick() {
        // 60fps => 15 animation frames rendered
        aniTick++;

        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;

            if (aniIndex >= 26)
                aniIndex = 0;
        }
    }

    private void updateVelocity() {
        if (controller.isPressedUp()) {
            velocity.setY(-speed);
        }

        if (controller.isPressedDown()) {
            velocity.setY(speed);
        }

        if (controller.isPressedRight()) {
            velocity.setX(speed);
        }

        if (controller.isPressedLeft()) {
            velocity.setX(-speed);
        }
    }

    @Override
    public void update() {
        updateVelocity();
        if (position.getX() + velocity.getX() >= 0 && position.getY() + velocity.getY() >= 0
                && position.getX() + velocity.getX() + size.getWidth() <= 720
                && position.getY() + velocity.getY() + size.getHeight() <= 480)
            position = new Position(position.getX() + velocity.getX(), position.getY() + velocity.getY());
        // Reset velocity
        velocity = new Vector2D(0, 0);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(
                animations[0][aniIndex],
                position.getX(),
                position.getY(),
                size.getWidth(),
                size.getHeight(),
                null);
        updateAnimationTick();
    }

    public BufferedImage[][] getAnimations() {
        return animations;
    }

}
