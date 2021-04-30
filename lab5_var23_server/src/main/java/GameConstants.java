public class GameConstants {
    private static boolean finished = false;
    private static final int port = 1200;
    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean finished) {
        GameConstants.finished = finished;
    }

    public static int getPort(){
        return GameConstants.port;
    }
}
