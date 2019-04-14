package cs2340.todo_team_name.spacetrader.enums;

/**
 * Ship types available
 */
public enum ShipTypes {
    FLEA("Flea", 20, 5, 0, 25, 0, 0, 200),
    GNAT("Gnat", 14, 15, 1, 100, 1, 0, 500),
    FIREFLY("Firefly", 17, 20, 1, 100, 1, 1, 800),
    MOSQUITO("Mosquito", 13, 15, 2, 100, 1, 1, 1000),
    BUMBLEBEE("Bumblebee", 15, 20, 1, 100, 2, 2, 1300),
    BEETLE("Beetle", 14, 50, 0, 50, 1, 1, 1700),
    HORNET("Hornet", 16, 20, 3, 150, 1, 2, 2400),
    GRASSHOPPER("Grasshopper", 15, 30, 2, 150, 3, 2, 2600),
    TERMITE("Termite", 13, 60, 1, 200, 2, 3, 3000),
    WASP("Wasp", 14, 35, 3, 200, 2, 2, 3300);

    private final String name;
    private final int speed;
    private final int inventorySize;
    private final int weaponsAvailable;
    private final int baseHealth;
    private final int gadgetsAvailable;
    private final int shieldsAvailable;
    private final int value;

    ShipTypes(String n, int s, int i, int w, int bh, int ga, int sa, int val) {
        name = n;
        speed = s;
        inventorySize = i;
        weaponsAvailable = w;
        baseHealth = bh;
        gadgetsAvailable = ga;
        shieldsAvailable = sa;
        value = val;
    }

    /**
     * Gets ship name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets ship speed
     * @return int speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets ship inventory size
     * @return int size
     */
    public int getInventorySize() {
        return inventorySize;
    }

    /**
     * Gets number of ship weapons
     * @return int weapons
     */
    public int getWeaponsAvailable() {
        return weaponsAvailable;
    }

    /**
     * Gets ship's base health
     * @return int health
     */
    public int getBaseHealth() {
        return baseHealth;
    }

    /**
     * Gets number of ship gadgets
     * @return int gadgets
     */
    public int getGadgetsAvailable() {
        return gadgetsAvailable;
    }

    /**
     * Gets number of ship shields
     * @return int shields
     */
    public int getShieldsAvailable() {
        return shieldsAvailable;
    }

    /**
     * Gets ship price
     * @return int price
     */
    public int getValue() {
        return value;
    }


}
