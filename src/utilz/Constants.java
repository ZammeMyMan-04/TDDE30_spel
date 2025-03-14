package utilz;

import java.awt.*;

import static utilz.Constants.Game.*;

public class Constants
{
    public static class Game
    {
        private static final int ORIGINAL_TS = 16;
        public static final int SCALE = 3;
        public static final int TS = ORIGINAL_TS * SCALE;
    }

    public static class Fonts
    {
        public static final Font ARIAL_15 = new Font("Arial", Font.PLAIN, 15 * SCALE);
        public static final Font ARIAL_10 = new Font("Arial", Font.PLAIN, 10 * SCALE);
        public static final Font ARIAL_80B = new Font("Arial", Font.BOLD, 80 * SCALE);
    }

    public static class GameContainer
    {
        public static final int TARGET_UPS = 60;
        public static final int TARGET_FPS = 60;
    }

}
