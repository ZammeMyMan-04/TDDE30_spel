package main;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class GameObject
{
    protected float x, y;
    protected int width, height;
    protected Rectangle2D.Float hitbox = null;
    protected int hitboxOffsetX, hitboxOffsetY;
    protected ObjectID id;

    public abstract void update();
    public abstract void render(Graphics2D g2d);

    public void drawHitbox(Graphics2D g2d) {
        if (hitbox == null) return;

        g2d.setColor(Color.RED);
        g2d.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
    }

    protected void updateHitbox() {
        hitbox.x = x + hitboxOffsetX;
        hitbox.y = y + hitboxOffsetY;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ObjectID getID() {
        return id;
    }
}
