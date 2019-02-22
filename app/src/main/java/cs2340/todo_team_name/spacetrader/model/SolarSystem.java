package cs2340.todo_team_name.spacetrader.model;

public class SolarSystem {
    private String name;
    private int[] location;
    private Planet[] planets;

    public SolarSystem(String name, int x, int y) {
        location = new int[2];
        this.name = name;
        this.location[0] = x;
        this.location[1] = y;
    }


    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        if(!(other instanceof SolarSystem)) {
            return false;
        }
        SolarSystem that = (SolarSystem) other;
        return this.name.equals(that.name)
                && this.location[0] == that.location[0]
                && this.location[1] == that.location[1];
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash += this.name.hashCode() * 17;
        hash += this.location[0] * 17;
        hash += this.location[1] * 17;
        return hash;
    }
    @Override
    public String toString() {
       return "Name: " + name + " (" + location[0] + "," +location[1] + ")";
    }
}
