package cs2340.todo_team_name.spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import java.io.Serializable;

public class ShipMarket extends Market implements Serializable {
    private int credits;
    private TechLevel techLevel;
    private GovernmentType governmentType;
    private HashMap<Resources, Double> resources;
    private ResourceType resourceType;

    public ShipMarket(TechLevel tech, GovernmentType gov, ResourceType res) {
        techLevel = tech;
        governmentType = gov;
        resourceType = res;
        GenerateMarket gen = new GenerateMarket(tech, res);
        resources = gen.generate();
    }

    public boolean purchase(Resources resource) {
        double price = resources.get(resource);
        if (credits >= price) {
            credits-= price;
            //resources.add(resource);
            return true;
        }
        return false;
    }

    public boolean sell(Resources resource) {
        double price = resources.get(resource);
        //resources.remove(resource);
        credits += price;
        return true;
    }

    public double getPriceOfGood(Resources resource) {
        return resources.get(resource);
    }
}
