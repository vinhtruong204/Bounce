
import display.GamePanel;

public class Launcher {
    public static final int SCREEN_WIDTH = 720;
    public static final int SCREEN_HEIGHT = 480;

    public static void main(String[] args) {
        new Thread(new GamePanel(SCREEN_WIDTH, SCREEN_HEIGHT)).start();
    }
}
