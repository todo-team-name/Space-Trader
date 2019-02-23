package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.Resources;

public class Resource {
    private Resources type;

    public Resource(Resources res) {
        type = res;
    }

    public int getValue() {
        return type.getValue();
    }

    public String getType() {
        return type.getName();
    }
}
