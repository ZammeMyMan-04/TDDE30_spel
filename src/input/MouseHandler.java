package input;

import main.GameManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private GameManager gm;
    private boolean button1 = false;
    private boolean button1Old = false;

    public MouseHandler(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        button1 = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        button1 = false;
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
    public void mouseMoved(MouseEvent mouseEvent) {}

    public void update() {
        button1Old = button1;
    }

    public boolean button1Down() {
        return button1;
    }
    public boolean button1Clicked() {
        return button1 && !button1Old;
    }
}
