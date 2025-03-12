package main;

import javax.swing.*;

public class GameContainer implements Runnable {

    private GameManager gameManager;
    private JFrame frame;
    private final int TARGET_FPS = 60;
    private final int TARGET_UPS = 60;

    public GameContainer(GameManager gameManager) {
        this.gameManager = gameManager;
        initFrame();
    }

    private void initFrame() {
        frame = new JFrame();
        frame.setTitle("Projekt");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameManager);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        //frame.setCursor(Cursor.CROSSHAIR_CURSOR);
        frame.setVisible(true);
    }

    public void startGame() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1_000_000_000.0d / TARGET_FPS;
        double timePerUpdate = 1_000_000_000.0d / TARGET_UPS;

        long previousTime = System.nanoTime();
        long lastCheck = System.currentTimeMillis();

        int frameCounter = 0;
        int updateCounter = 0;

        double deltaF = 0;
        double deltaU = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaF += (currentTime - previousTime) / timePerFrame;
            deltaU += (currentTime - previousTime) / timePerUpdate;
            previousTime = currentTime;

            // RENDER
            if (deltaF >= 1) {
                gameManager.repaint();
                deltaF--;
                frameCounter++;
            }

            // UPDATE
            if (deltaU >= 1) {
                gameManager.updateGame();
                deltaU--;
                updateCounter++;
            }

            // PRINT FPS AND UPS
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frameCounter + " | UPS: " + updateCounter);
                frameCounter = 0;
                updateCounter = 0;
            }
        }
    }
}
