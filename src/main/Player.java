package main;

import input.KeyHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Player extends GameObject
{

    private GameManager gm;
    private KeyHandler keyHandler;
    private int speed = 1;

    public Player(GameManager gm) {
        this.gm = gm;

        x = 20;
        y = 20;
        width = 50;
        height = 50;
//        hitbox = new Rectangle2D.Float();
//        hitboxOffsetX = 30;
//        hitboxOffsetY = 50;
//        hitbox.width = width / 2f;
//        hitbox.height = height / 2f;

        id = ObjectID.PlAYER;
        keyHandler = gm.getKeyHandler();
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

        //updateHitbox();
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect((int)x, (int)y, width, height);
        //drawHitbox(g2d);
    }


}
