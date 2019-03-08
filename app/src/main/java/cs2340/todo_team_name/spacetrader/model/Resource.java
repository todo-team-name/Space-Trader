package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class Resource {
    private Resources type;

    public Resource(Resources res) {
        type = res;
    }

    public double getValue(TechLevel t) {
        return type.getScaledValue(t);
    }

    public String getType() {
        return type.getName();
    }
}
