package vapor.tools;

public class Sdout {

    public static boolean isDebugEnabled = false;

    private static void out(String pLevel, String pText) {
        System.out.printf("[%s] %s%n", pLevel, pText);
    }

    public static void info(String pText) {
        out("INFO", pText);
    }

    public static void error(String pText) {
        out("ERROR", pText);
    }

    public static void debug(String pText) {
        if (isDebugEnabled) {
            out("DEBUG", pText);
        }
    }
}
