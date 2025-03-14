package main;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Raycaster {
    private ArrayList<AABBComponent> aabb;
    private Graphics2D g2d = null;

    public Raycaster(ArrayList<AABBComponent> aabb) {
        this.aabb = aabb;
    }

    public GameObject castRay(double startX, double startY, double angle, float distance, GameObject parent) {
        // TODO: IMPROVE! Function is slow O(n)

        double endX = startX + Math.cos(angle) * distance;
        double endY = startY + Math.sin(angle) * distance;

        if (g2d != null) { // DEBUG

            g2d.setColor(Color.RED);
            g2d.drawLine((int)startX, (int)startY, (int)endX, (int)endY);
        }

        GameObject closestObj = null;
        double minDistance = Double.MAX_VALUE;

        for (AABBComponent aabbComponent : aabb) {
            if (aabbComponent.getParent() == parent) continue;

            Rectangle2D.Float hitbox = aabbComponent.getHitbox();
            if (hitbox.intersectsLine(startX, startY, endX, endY)) {

                double closestX = Math.clamp(startX, hitbox.x, hitbox.x + hitbox.width);
                double closestY = Math.clamp(startY, hitbox.y, hitbox.y + hitbox.height);

                if (g2d != null) { // DEBUG

                    g2d.fillRoundRect((int)closestX - 2, (int)closestY - 2, 4, 4, 2, 2);
                }

                double dist = Math.hypot(closestX - startX, closestY - startY);

                if (dist < minDistance) {
                    minDistance = distance;
                    closestObj = aabbComponent.getParent();
                }
            }
        }

        //g2d = null; // For debugging

        return closestObj;
    }

    public void drawRaycast(Graphics2D g2d) {
        this.g2d = g2d;
    }
}
