package input;

import main.GameManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private GameManager gm;
    private boolean[] keys = new boolean[256];
    private boolean[] keysOld = new boolean[256];

    public KeyHandler(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {/* ? */}

    public boolean isKeyDown(int keyCode)
    {
        return keys[keyCode];
    }
    public boolean isKeyClick(int keyCode)
    {
        return keys[keyCode] && !keysOld[keyCode];
    }
    public void updateKeys()
    {
        keysOld = keys.clone();
    }
}
