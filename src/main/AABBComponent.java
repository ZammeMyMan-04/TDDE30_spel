package main;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class AABBComponent {

    private final Rectangle2D.Float hitbox;
    private int offsetX = 0, offsetY = 0;
    private final GameObject parent;

    public AABBComponent(GameObject parent) {
        this.parent = parent;
        hitbox = new Rectangle2D.Float(parent.getX(), parent.getY(), parent.getWidth(), parent.getHeight());
    }

    public void update() {
        hitbox.x = parent.getX() + offsetX;
        hitbox.y = parent.getY() + offsetY;
    }

    public void render(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public GameObject getParent() {
        return parent;
    }
}
