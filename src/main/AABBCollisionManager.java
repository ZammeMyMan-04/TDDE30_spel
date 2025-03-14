package main;

import java.awt.*;
import java.util.ArrayList;

public class AABBCollisionManager {
    private ArrayList<AABBComponent> aabb;

    public AABBCollisionManager() {
        aabb = new ArrayList<>();
    }

    public void checkCollision() {

        for (int i = 0; i < aabb.size(); i++) {
            AABBComponent aabb1 = aabb.get(i);

            for (int j = i+1; j < aabb.size(); j++) {
                AABBComponent aabb2 = aabb.get(j);

                // Check for collision
                if (aabb1.getHitbox().intersects(aabb2.getHitbox())) {
                    GameObject parent1 = aabb1.getParent();
                    GameObject parent2 = aabb2.getParent();

                    parent1.collision(parent2);
                    parent2.collision(parent1);
                }

            }
        }
    }

    public void removeAABB(AABBComponent aabbComponent) {
        aabb.remove(aabbComponent);
    }
    public void addAABB(AABBComponent aabbComponent) {
        aabb.add(aabbComponent);
    }

    public void drawHitboxes(Graphics2D g2d) {
        for (AABBComponent aabbComponent : aabb) {
            aabbComponent.render(g2d);
        }
    }
}
