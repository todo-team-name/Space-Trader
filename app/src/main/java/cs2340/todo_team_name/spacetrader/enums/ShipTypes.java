package cs2340.todo_team_name.spacetrader.enums;

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

    private String name;
    private int speed;
    private int inventorySize;
    private int weaponsAvailable;
    private int baseHealth;
    private int gadgetsAvailable;
    private int shieldsAvailable;
    private int value;

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

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public int getWeaponsAvailable() {
        return weaponsAvailable;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getGadgetsAvailable() {
        return gadgetsAvailable;
    }

    public int getShieldsAvailable() {
        return shieldsAvailable;
    }

    public int getValue() {
        return value;
    }


}
