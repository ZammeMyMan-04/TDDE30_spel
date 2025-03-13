package main;

import java.awt.*;

public class Camera
{
    private float cameraX, cameraY;
    private ObjectID targetID;
    private GameObject target;
    private GameManager gm;

    private float speed;

    public Camera(GameManager gm, ObjectID targetID, float speed) {
        this.gm = gm;
        cameraX = 0;
        cameraY = 0;
        this.targetID = targetID;
        this.speed = speed;
    }

    public void update() {
        if (target == null) target = gm.getObjManager().getObject(targetID); // Search for target
        if (target == null) return; // Target did not exist

        float centerX = target.getX() + target.getWidth() / 2f;
        float centerY = target.getY() + target.getHeight() / 2f;

        cameraX += ((centerX - gm.getWidth() / 2f) - cameraX) * speed;
        cameraY += ((centerY - gm.getHeight() / 2f) - cameraY) * speed;
    }

    public void applyTranslation(Graphics2D g2d) {
        g2d.translate((int)-cameraX, (int)-cameraY);
    }

    public void restoreTranslation(Graphics2D g2d) {
        g2d.translate((int)cameraX, (int)cameraY);
    }

    public GameObject getTarget() {
        return target;
    }

    public void setTarget(GameObject target) {
        this.target = target;
    }
}
