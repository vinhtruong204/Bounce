
import display.GamePanel;

public class Launcher {
    static final int SCREEN_WIDTH = 720;
    static final int SCREEN_HEIGHT = 480;
    public static void main(String[] args) {
        new Thread(new GamePanel(SCREEN_WIDTH, SCREEN_HEIGHT)).start();
    }
}
