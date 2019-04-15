package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import java.io.Serializable;

/**
 * The resource class
 */
class Resource implements Serializable{
    private final Resources type;

    /**
     * Creates a resource
     * @param res type of resource to create
     */
    public Resource(Resources res) {
        type = res;
    }

    /**
     * Returns resource's value
     * @param t tech level of resource
     * @return value of resource based on tech level
     */
    public double getValue(TechLevel t) {
        return type.getScaledValue(t);
    }

    /**
     * Returns type of resource
     * @return name of resource's type
     */
    public String getType() {
        return type.getName();
    }
}
