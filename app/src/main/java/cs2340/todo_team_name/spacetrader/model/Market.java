package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.MarketType;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public abstract class Market {
    public abstract boolean purchase(Resource resource);
    public abstract boolean sell(Resource resource);
    public abstract int getGoodValue(Resource resource);
}
