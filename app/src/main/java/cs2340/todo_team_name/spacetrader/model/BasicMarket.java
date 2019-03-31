package cs2340.todo_team_name.spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import java.io.Serializable;

public class BasicMarket extends Market implements Serializable {
    private double credits;
    private TechLevel techLevel;
    private GovernmentType governmentType;
    private ResourceType resourceType;
    private HashMap<Resources, Double> resources;

    public BasicMarket(TechLevel tech, GovernmentType gov, ResourceType res) {
        techLevel = tech;
        governmentType = gov;
        resourceType = res;
        GenerateMarket gen = new GenerateMarket(tech, res);
        resources = gen.generate();
        credits = 500;
    }

    public boolean purchase(Resources resource) {
        double price = resources.get(resource);
        if (credits >= price) {
            credits-= price;
            //resources.put(resource, Integer.valueOf(price));
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
        if (resources.containsKey(resource)) {
            return resources.get(resource);
        } else {
            return 999999;
        }
    }

    public boolean contains(Resources resource) {
        return resources.containsKey(resource);
    }

}
