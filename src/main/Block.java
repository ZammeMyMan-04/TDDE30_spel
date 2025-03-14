package main;

import java.awt.*;

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

        g2d.setColor(new Color(0, 0, 150, 100));
        g2d.fillRect((int)x, (int)y, width, height);
    }

    @Override
    public void collision(GameObject other) {

        System.out.println("Collided with: " + other.getID());
//        switch (other.getID()) {
//            case PLAYER -> {
//                System.out.println("Collision to player");
//
//                remove = true;
//            }
//        }
    }
}
