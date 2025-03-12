package main;

import input.KeyHandler;
import input.MouseHandler;

import javax.swing.*;
import java.awt.*;

public class GameManager extends JPanel {

    // TILES
    private final int ORIGINAL_TILE_SIZE = 36;
    private int scale = 3;
    private int tileSize = ORIGINAL_TILE_SIZE * scale;

    // INPUT HANDLERS
    private KeyHandler keyHandler = new KeyHandler(this);
    private MouseHandler mouseHandler = new MouseHandler(this);

    // MANAGERS
    private ObjectManager objManager = new ObjectManager(this);

    // OBJECTS
    private Camera camera = new Camera(this, ObjectID.PlAYER);

    public GameManager() {
        initPanel(500, 500);

        camera.setTarget(objManager.getObject(ObjectID.PlAYER));
    }

    private void initPanel(int width, int height) {
        // SIZE
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 0));
        this.setDoubleBuffered(true);

        // INPUT
        addKeyListener(keyHandler);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        setFocusable(true);
    }

    public void updateGame() {
        objManager.update();
        camera.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Apply translation (move entire world)

        //g2d.translate(-cameraX, -cameraY);
        camera.applyTranslation(g2d);

        objManager.draw(g2d);

        g2d.drawRect(0, 0, 10, 10);

        //g2d.translate(cameraX, cameraY);
        camera.restoreTranslation(g2d);

        g2d.drawRect(0, 0, 10, 10);


        g2d.dispose();
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public ObjectManager getObjManager() {
        return objManager;
    }
}
