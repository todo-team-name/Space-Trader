package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import java.io.Serializable;
class Resource implements Serializable{
    private final Resources type;

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
