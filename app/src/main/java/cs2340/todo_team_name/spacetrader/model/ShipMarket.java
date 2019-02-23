package cs2340.todo_team_name.spacetrader.model;

import java.util.ArrayList;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class ShipMarket extends Market {
    private int credits;
    private TechLevel techLevel;
    private GovernmentType governmentType;
    private ArrayList<Resource> resources;

    public ShipMarket(TechLevel tech, GovernmentType gov) {
        techLevel = tech;
        governmentType = gov;
    }

    public boolean purchase(Resource resource) {
        int price = getGoodValue(resource);
        if (credits >= price) {
            credits-= price;
            resources.add(resource);
            return true;
        }
        return false;
    }

    public boolean sell(Resource resource) {
        int price = getGoodValue(resource);
        resources.remove(resource);
        credits += price;
        return true;
    }

    public int getGoodValue(Resource resource) {
        return resource.getValue();
    }

}
