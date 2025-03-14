package main;

import java.awt.*;

public abstract class GameObject
{
    protected float x, y;
    protected int width, height;
    protected AABBComponent aabb;
    protected ObjectID id;
    protected boolean remove = false; // Default is false
    protected GameManager gm;

    public GameObject(GameManager gm) {
        this.gm = gm;
    }

    public abstract void update();
    public abstract void render(Graphics2D g2d);
    public abstract void collision(GameObject other);
    public void updateRaycasts() {

    }

    protected void addAABB() {
        gm.getObjManager().getCollisionManager().addAABB(aabb);
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

    public boolean shouldRemove() {
        return remove;
    }

    public AABBComponent getAABB() {
        return aabb;
    }
}
