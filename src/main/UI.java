package main;

import java.awt.*;

import static utilz.Constants.Fonts.ARIAL_15;

public class UI
{

    private GameManager gm;
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
