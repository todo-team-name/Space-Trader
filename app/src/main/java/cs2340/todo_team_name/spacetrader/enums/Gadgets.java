package cs2340.todo_team_name.spacetrader.enums;

/**
 * Gadgets available in game
 */
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

    /**
     * Gets gadget name
     * @return String name
     */
    public String getName() {
        return name;
    }
}
