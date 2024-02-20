package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import animation.LoadSave;
import animation.PlayerAnimationType;
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
    private int aniType;
    private int aniTick, aniIndex, aniSpeed;
    private boolean moving;

    private int[][] map;
    private Rectangle hitBox;

    public Player(KeyHandler keyHandler, int[][] map) {
        position = new Position(0, 0);
        size = new Size(PLAYER_WIDTH, PLAYER_HEIGHT);

        // Initialize controller
        controller = new PlayerController(keyHandler);
        velocity = new Vector2D(0, 0);
        speed = 5;

        this.map = map;
        hitBox = new Rectangle(position.getX(), position.getY(), size.getWidth(), size.getHeight());

        // Set animation sprite sheet
        animations = new BufferedImage[6][26];
        loadAnimations();
        aniSpeed = 3; // 15 animation frames per second
        aniType = PlayerAnimationType.IDLE;
    }

    private void loadAnimations() {
        image = LoadSave.getSpriteImage("img/1-Player-Bomb Guy.png");
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

            if (aniIndex >= PlayerAnimationType.getSpriteAmount(aniType))
                aniIndex = 0;
        }
    }

    private void setAnimationType() {
        int startAni = aniType;
        aniType = moving ? PlayerAnimationType.RUN : PlayerAnimationType.IDLE;

        // If start anitype is not equal to startAni reset aniTick and aniIndex
        if (aniType != startAni) {
            aniTick = 0;
            aniIndex = 0;
        }
    }

    private void updatePosition() {
        moving = false;

        if (controller.isPressedUp()) {
            velocity.setY(-speed);
        }

        if (controller.isPressedDown()) {
            velocity.setY(speed);
        }

        if (controller.isPressedRight() && !controller.isPressedLeft() && !controller.isPressedDown()) {
            velocity.setX(speed);
            moving = true;
        }

        if (controller.isPressedLeft() && !controller.isPressedRight() && !controller.isPressedDown()) {
            velocity.setX(-speed);
            moving = true;
        }

        Position newPos = new Position(position.getX() + velocity.getX(), position.getY() + velocity.getY());
        Rectangle newHitbox = new Rectangle(newPos.getX(), newPos.getY(), size.getWidth(), size.getHeight());

        // Move the character
        if (canMove(newHitbox)) {
            position = new Position(position.getX() + velocity.getX(), position.getY() + velocity.getY());
            hitBox = new Rectangle(position.getX(), position.getY(), size.getWidth(), size.getHeight());
        }
        // Reset velocity
        velocity = new Vector2D(0, 0);
    }

    private boolean canMove(Rectangle newHitbox) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && isCollision(i, j, newHitbox)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCollision(int i, int j, Rectangle newHitbox) {
        // Hit box of tile
        Rectangle tileBox = new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        int topA, topB;
        int leftA, leftB;
        int rightA, rightB;
        int bottomA, bottomB;

        // All side of player after move
        topA = newHitbox.y;
        leftA = newHitbox.x;
        rightA = newHitbox.x + newHitbox.width;
        bottomA = newHitbox.y + newHitbox.height;

        // All side of tile
        topB = tileBox.y;
        leftB = tileBox.x;
        rightB = tileBox.x + tileBox.width;
        bottomB = tileBox.y + tileBox.height;

        if (leftA > rightB || rightA < leftB) {
            return false;
        } else if (topA > bottomB || bottomA < topB) {
            return false;
        }
        return true;
    }

    @Override
    public void update() {
        updatePosition();
        setAnimationType();
        updateAnimationTick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(
                animations[aniType][aniIndex],
                position.getX(),
                position.getY(),
                size.getWidth(),
                size.getHeight(),
                null);
    }

    public BufferedImage[][] getAnimations() {
        return animations;
    }

}
