package cs2340.todo_team_name.spacetrader.enums;

public enum Gadgets {
    EXTRACARGO("5 Extra Cargo Slots"),
    NAVIGATION("Navigation System"),
    AUTOREPAIR("Auto-Repair System"),
    TARGETING("Targetting System"),
    CLOAKING("Cloaking System");

    private String name;

    Gadgets(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
