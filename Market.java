package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.Resources;

import java.io.Serializable;

/**
 * Creates Market class
 */
public abstract class Market implements Serializable {
    public abstract boolean purchase(Resources resource);
    public abstract void sell(Resources resource);
    public abstract double getPriceOfGood(Resources resource);
    public abstract boolean contains(Resources resource);
    public abstract String displayResource(Resources res);
}
