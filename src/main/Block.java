package main;

import java.awt.*;
import java.sql.SQLOutput;

public class Block extends GameObject{

    public Block(GameManager gm) {
        super(gm);

        x = -150;
        y = -150;
        width = 100;
        height = 100;

        initHitbox();

        id = ObjectID.BLOCK;
    }

    private void initHitbox() {
        aabb = new AABBComponent(this);
        aabb.setOffsetX(0);
        aabb.setOffsetY(height / 2);
        aabb.getHitbox().width = width;
        aabb.getHitbox().height = height / 2f;
        aabb.update();

        addAABB();
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics2D g2d) {

        g2d.setColor(Color.BLUE);
        g2d.fillRect((int)x, (int)y, width, height);
    }

    @Override
    public void collision(GameObject other) {

        switch (other.getID()) {
            case PlAYER -> {
                System.out.println("Collision to player");

                remove = true;
            }
        }
    }
}
