package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class ObjectManager {

    private ArrayList<GameObject> objects;
    private GameManager gm;
    private AABBCollisionManager collisionManager = new AABBCollisionManager();
    private Raycaster raycaster = new Raycaster(collisionManager.getAABB());

    private boolean debug = true;

    public ObjectManager(GameManager gm) {
        this.gm = gm;
        objects = new ArrayList<>();
    }

    public void setGameObjects() {
        objects.add(new Player(gm));
        objects.add(new Block(gm));
    }

    public void update() {

        // CHECK DEBUG
        if (gm.getKeyHandler().isKeyClick(KeyEvent.VK_SPACE))
            debug = !debug;

        // COLLECT OBJECTS TO REMOVE
        ArrayList<GameObject> objToRemove = new ArrayList<>();

        for (GameObject obj : objects) {
            obj.update();
            if (obj.shouldRemove())
                objToRemove.add(obj);
        }

        // CHECK COLLISION
        collisionManager.checkCollision();

        // REMOVE OBJECTS
        for (GameObject obj : objToRemove) {
            collisionManager.removeAABB(obj.getAABB());
            objects.remove(obj);
        }

        // UPDATE RAYCASTS
        for (GameObject obj : objects) {
            obj.updateRaycasts();
        }
    }

    public void draw(Graphics2D g2d) {
        //raycaster.drawRaycast(g2d);

        // SORT
        objects.sort(new PositionComparator());

        // DRAW
        for (GameObject obj : objects)
            obj.render(g2d);

        if (debug)
            collisionManager.drawHitboxes(g2d);
    }

    public GameObject getObject(ObjectID id) {
        for (GameObject object : objects)
            if (object.getID() == id)
                return object;
        return null;
    }

    public AABBCollisionManager getCollisionManager() {
        return collisionManager;
    }
    public Raycaster getRaycaster() {
        return raycaster;
    }
}
