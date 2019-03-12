package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.MarketType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import java.io.Serializable;
public abstract class Market implements Serializable {
    public abstract boolean purchase(Resources resource);
    public abstract boolean sell(Resources resource);
    public abstract double getPriceOfGood(Resources resource);
}
