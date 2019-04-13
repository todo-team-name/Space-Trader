package cs2340.todo_team_name.spacetrader.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import java.io.Serializable;
import java.util.Random;

public class BasicMarket extends Market implements Serializable {
    private double credits;
    private TechLevel techLevel;
    private GovernmentType governmentType;
    private ResourceType resourceType;

    public HashMap<Resources, Double> getResources() {
        return resources;
    }

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
        Random random = new Random();
        boolean isDrought = random.nextBoolean();
        double price;
        price = resources.get(resource);
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
        Random random = new Random();
        boolean isDrought = random.nextBoolean();
        if (resources.containsKey(resource)) {
            if(isDrought) {
                Log.i("Theres a drought!", "Price of Water Increased");
                resources.put(Resources.WATER, resources.get(Resources.WATER).doubleValue()*1.4);
                return resources.get(resource);
            } else {
                return resources.get(resource);
            }
        } else {
            return 999999;
        }
    }

    public boolean contains(Resources resource) {
        return resources.containsKey(resource);
    }


}
