package cs2340.todo_team_name.spacetrader.enums;

/**
 * Weapons available
 */
public enum Weapons {
    MILITARY("Military Laser", 50),
    PULSE("Pulse Laster", 27),
    BEAM("Beam Laser", 15);

    private String name;
    private int damage;

    Weapons(String n, int dmg) {
        name = n;
        damage = dmg;
    }

    /**
     * Gets weapon name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets weapon damage
     * @return int damage
     */
    public int getDamage() {
        return damage;
    }

}
