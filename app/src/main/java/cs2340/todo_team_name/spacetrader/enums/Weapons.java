package cs2340.todo_team_name.spacetrader.enums;

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

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

}
