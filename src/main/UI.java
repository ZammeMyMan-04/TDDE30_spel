package main;

import java.awt.*;

import static utilz.Constants.Fonts.*;
import static utilz.Constants.GameContainer.TARGET_UPS;

public class UI
{

    private final GameManager gm;
    private Graphics2D g2d;

    // MANAGERS
    private final MessageManager messageManager = new MessageManager();

    public UI(GameManager gm) {
        this.gm = gm;
    }

    public void draw()
    {
        drawSubwindow(50, 50, 200, 200);

        drawText("TEST");

        messageManager.displayMessages(g2d);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(ARIAL_10);
        int time = (int) (gm.getGameTime() / TARGET_UPS);
        drawCenteredText(String.valueOf(time), gm.getWidth() / 2, 30);
    }

    public void drawText(String txt)
    {
        g2d.setFont(ARIAL_15);
        g2d.setColor(Color.WHITE);
        g2d.drawString(txt, 100, 100);
    }
    public void drawSubwindow(int x, int y, int width, int height)
    {
        g2d.setColor(new Color(0, 0, 0, 180));
        g2d.fillRoundRect(x, y, width, height, 50, 50);
    }
    public MessageManager getMessageManager() {
        return messageManager;
    }
    public void drawCenteredText(String text, int x, int y) {
        int centerTextX = g2d.getFontMetrics().stringWidth(text) / 2;

        int newX = x - centerTextX;
        g2d.drawString(text, newX, y);
    }
    public void setG2D(Graphics2D g2d) {
        this.g2d = g2d;
    }
}
