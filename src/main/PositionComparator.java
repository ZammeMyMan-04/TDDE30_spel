package main;

import java.util.Comparator;

public class PositionComparator implements Comparator<GameObject> {
    @Override
    public int compare(GameObject obj1, GameObject obj2) {
        return Float.compare(obj1.getY() + obj1.getHeight(), obj2.getY() + obj2.getHeight());
    }
}
