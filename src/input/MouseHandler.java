package input;

import main.GameManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private GameManager gm;

    public MouseHandler(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {/* Mouse enter frame */}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {/* Mouse exit frame */}

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {/* (Fast) Mouse click */}

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {}

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
//        gm.getPlayer().setX(mouseEvent.getX());
//        gm.getPlayer().setY(mouseEvent.getY());

    }
}
