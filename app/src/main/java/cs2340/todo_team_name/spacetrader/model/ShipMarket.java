package cs2340.todo_team_name.spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class ShipMarket extends Market {
    private int credits;
    private TechLevel techLevel;
    private GovernmentType governmentType;
    private HashMap<Resource, Double> resources;
    private ResourceType resourceType;

    public ShipMarket(TechLevel tech, GovernmentType gov, ResourceType res) {
        techLevel = tech;
        governmentType = gov;
        resourceType = res;
        GenerateMarket gen = new GenerateMarket(tech, res);
        resources = gen.generate();
    }

    public boolean purchase(Resource resource) {
        double price = resources.get(resource);
        if (credits >= price) {
            credits-= price;
            //resources.add(resource);
            return true;
        }
        return false;
    }

    public boolean sell(Resource resource) {
        double price = resources.get(resource);
        //resources.remove(resource);
        credits += price;
        return true;
    }

    public double getPriceOfGood(Resource resource) {
        return resources.get(resource);
    }
}
