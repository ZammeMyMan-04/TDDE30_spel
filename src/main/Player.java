package main;

import input.KeyHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utilz.Constants.Game.TS;

public class Player extends GameObject
{
    private final KeyHandler keyHandler;
    private int speed = 1;

    public Player(GameManager gm) {
        super(gm);

        x = 20;
        y = 20;
        width = TS;
        height = TS;

        initHitbox();

        id = ObjectID.PLAYER;
        keyHandler = gm.getKeyHandler();
    }

    private void initHitbox() {
        aabb = new AABBComponent(this);
        aabb.setOffsetX((int) (width / 4f));
        aabb.setOffsetY((int) (height / 4f));
        aabb.getHitbox().width = width / 2f;
        aabb.getHitbox().height = height / 2f;
        aabb.update();

        addAABB();
    }

    @Override
    public void update() {

        if (keyHandler.isKeyDown(KeyEvent.VK_S)) {
            y += speed;
        }
        if (keyHandler.isKeyDown(KeyEvent.VK_W)) {
            y -= speed;
        }
        if (keyHandler.isKeyDown(KeyEvent.VK_D)) {
            x += speed;
        }
        if (keyHandler.isKeyDown(KeyEvent.VK_A)) {
            x -= speed;
        }

        aabb.update();
    }

    @Override
    public void updateRaycasts() {
        double angle = Math.toRadians(45);
        int distance = 200;

        GameObject obj= gm.getObjManager().getRaycaster().castRay(aabb.getHitbox().getCenterX(), aabb.getHitbox().getCenterY(), angle, distance, this);

        if (obj != null) System.out.println("hit");
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect((int)x, (int)y, width, height);
    }

    @Override
    public void collision(GameObject other) {
        System.out.println(id + " collided with " + other.getID());
    }
}
