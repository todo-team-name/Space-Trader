package cs2340.todo_team_name.spacetrader.enums;

public enum Colors {
    C1("#65E28B"),
    C2("#7F2CCB"),
    C3("#FF84E8"),
    C4("#F7717D");

    private String hexValue;
    Colors(String s) {
        hexValue = s;
    }

    public String getHex() {
        return hexValue;
    }
}
