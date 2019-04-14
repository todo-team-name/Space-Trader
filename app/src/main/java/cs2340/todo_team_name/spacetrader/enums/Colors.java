package cs2340.todo_team_name.spacetrader.enums;

/**
 * Available colors
 */
public enum Colors {
    C1("#65E28B"),
    C2("#7F2CCB"),
    C3("#FF84E8"),
    C4("#F7717D");

    private final String hexValue;
    Colors(String s) {
        hexValue = s;
    }

    /**
     * Gets hex value for color
     * @return String hex value
     */
    public String getHex() {
        return hexValue;
    }
}
