package android.util;

/**
 * Log for running J-units
 */
public class Log {
    /**
     *
     * @param tag tag to log
     * @param msg msg to log
     * @return exit status
     */
    public static int d(String tag, String msg) {
        System.out.println("DEBUG: " + tag + ": " + msg);
        return 0;
    }

    /**
     *
     * @param tag tag to log
     * @param msg msg to log
     * @return exit status
     */
    public static int i(String tag, String msg) {
        System.out.println("INFO: " + tag + ": " + msg);
        return 0;
    }

    /**
     *
     * @param tag tag to log
     * @param msg msg to log
     * @return exit status
     */
    public static int w(String tag, String msg) {
        System.out.println("WARN: " + tag + ": " + msg);
        return 0;
    }

    /**
     *
     * @param tag tag to log
     * @param msg msg to log
     * @return exit status
     */
    public static int e(String tag, String msg) {
        System.out.println("ERROR: " + tag + ": " + msg);
        return 0;
    }

    // add other methods if required...
}