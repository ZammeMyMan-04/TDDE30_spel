package utilz;

import java.awt.*;

public class HelpFunctions {

    public static int getCenteredTextX(String txt, Graphics2D g2d) {
        return g2d.getFontMetrics().stringWidth(txt) / 2;
    }
}
