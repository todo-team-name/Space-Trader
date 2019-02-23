package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.MarketType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class Planet {
    private ResourceType resources;
    private TechLevel techLevel;
    private GovernmentType governmentType;
    private MarketType marketType;
    private String name;
    private String hexColor;
    private Market market;

    public Planet(String n, TechLevel tech, GovernmentType gov, MarketType market, String hex) {
        this.name = n;
        this.techLevel = tech;
        this.governmentType = gov;
        this.marketType = market;
        this.hexColor = hex;
        if (this.marketType.equals(MarketType.BASIC)) {
            this.market = new BasicMarket(tech, gov);
        } else {
            this.market = new ShipMarket(tech, gov);
        }
    }

    @Override
    public String toString() {
        return name + " " + techLevel + " " + governmentType + " " + marketType + " " + hexColor;
    }

}
