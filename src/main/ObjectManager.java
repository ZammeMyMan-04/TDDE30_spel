package main;

import java.awt.*;
import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<GameObject> objects;
    private GameManager gm;

    public ObjectManager(GameManager gm) {
        this.gm = gm;
        objects = new ArrayList<>();

        objects.add(new Player(gm));
    }

    public void update() {
        for (GameObject obj : objects) {
            obj.update();
        }
    }

    public void draw(Graphics2D g2d) {
        // Sortera objekten så de överlappar varandra rätt

        // Rita objekten
        for (GameObject obj : objects) {
            obj.render(g2d);
        }
    }

    public GameObject getObject(ObjectID id) {
        for (GameObject object : objects)
            if (object.getID() == ObjectID.PlAYER)
                return object;
        return null;
    }
}
