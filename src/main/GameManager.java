package main;

import input.KeyHandler;
import input.MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static utilz.Constants.Fonts.*;
import static utilz.Constants.Game.TS;

public class GameManager extends JPanel {

    // INPUT HANDLERS
    private final KeyHandler keyHandler = new KeyHandler(this);
    private final MouseHandler mouseHandler = new MouseHandler(this);

    // MANAGERS
    private final ObjectManager objManager = new ObjectManager(this);
    private final UI ui = new UI(this);
    private final SoundManager soundManager = new SoundManager();

    // OBJECTS
    private final Camera camera;

    // GAME STATE
    private GameState state = GameState.WELCOME;

    // TEMPORARY
    int i = 0;

    public GameManager() {
        initPanel(TS * 30, TS * 20);

        camera = new Camera(this, ObjectID.PlAYER, 0.08f);
        camera.setTarget(objManager.getObject(ObjectID.PlAYER));
    }

    private void initPanel(int width, int height) {
        // SET SIZE
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 0));
        this.setDoubleBuffered(true);

        // ADD INPUT
        addKeyListener(keyHandler);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        setFocusable(true);
    }

    public void updateGame() {

        switch (state) {
            case PLAY -> {
                objManager.update();
                camera.update();


                // ADD A MESSAGE
                if (keyHandler.isKeyClick(KeyEvent.VK_SPACE)) {
                    ui.getMessageManager().addMessage("message " + i);
                    i++;
                }
            }
            case WELCOME -> {
                camera.update();
            }
        }

        updateState();
        keyHandler.updateKeys();
        mouseHandler.update();
    }

    private void updateState() {
        switch (state) {
            case PLAY -> {
                if (keyHandler.isKeyClick(KeyEvent.VK_ESCAPE))
                    state = GameState.PAUS;
            }
            case PAUS -> {
                if (keyHandler.isKeyClick(KeyEvent.VK_ESCAPE))
                    state = GameState.PLAY;
            }
            case WELCOME -> {
                if (keyHandler.isKeyClick(KeyEvent.VK_SPACE))
                    state = GameState.PLAY;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        ui.setG2D(g2d);

        g2d.setColor(new Color(0, 90, 0));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        camera.applyTranslation(g2d);

        // ZOOM
        if (mouseHandler.button1Down()) { // fungerar lite lustigt
            g2d.scale(3d, 3d);
        }

        objManager.draw(g2d);

        g2d.setColor(Color.white);
        g2d.drawRect(0, 0, 10, 10);

        camera.restoreTranslation(g2d);

        // UI
        ui.draw();

        // STATE
        if (state == GameState.PAUS) {
            g2d.setFont(ARIAL_80B);
            ui.drawCenteredText("PAUS", getWidth() / 2, getHeight() / 2);
        }
        if (state == GameState.WELCOME) {
            g2d.setFont(ARIAL_80B);
            ui.drawCenteredText("WELCOME!", getWidth() / 2, getHeight() / 2);
        }

        g2d.dispose();
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }
    public ObjectManager getObjManager() {
        return objManager;
    }
    public GameState getState() {
        return state;
    }
    public void setState(GameState state) {
        this.state = state;
    }
    public UI getUi() {
        return ui;
    }
    public SoundManager getSoundManager() {
        return soundManager;
    }
    public Camera getCamera() {
        return camera;
    }
    public MouseHandler getMouseHandler() {
        return mouseHandler;
    }
}
