package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class ShipMarket extends Market {
    private double credits;
    private final TechLevel techLevel;
    private final GovernmentType governmentType;
    private HashMap<Resources, Double> resources;
    private final ResourceType resourceType;

    public ShipMarket(TechLevel tech, GovernmentType gov, ResourceType res) {
        techLevel = tech;
        governmentType = gov;
        resourceType = res;
        GenerateMarket gen = new GenerateMarket(tech, res);
        resources = gen.generate();
        credits = 5000;
    }

    @Override
    public boolean purchase(Resources resource) {
        double price = resources.get(resource);
        if (credits >= price) {
            credits-= price;
            //resources.add(resource);
            return true;
        }
        return false;
    }

    @Override
    public void sell(Resources resource) {
        double price = resources.get(resource);
        //resources.remove(resource);
        credits += price;

    }

    @Override
    public double getPriceOfGood(Resources resource) {
        if (resources.containsKey(resource)) {
            return resources.get(resource);
        } else {
            return 999999;
        }
    }

    @Override
    public boolean contains(Resources resource) {
        return resources.containsKey(resource);
    }

    @Override
    public String displayResource(Resources res) {
        if (resources.containsKey(res)) {
            return res.getName() + ": " + resources.get(res);
        } else {
            return "N/A";
        }
    }
}
