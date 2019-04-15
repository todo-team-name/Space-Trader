package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

import java.util.Random;

/**
 * Class for a basic market
 */
public class BasicMarket extends Market {
    private double credits;
    private final TechLevel techLevel;
    private final GovernmentType governmentType;
    private final ResourceType resourceType;
    private boolean scaled;

    /**
     *
     * @return returns current resource and value mapping
     */
    public HashMap<Resources, Double> getResources() {
        return resources;
    }

    private HashMap<Resources, Double> resources;

    /**
     * constructor for basic market
     * @param tech tech level for market
     * @param gov government type for market
     * @param res resource type for market
     */
    public BasicMarket(TechLevel tech, GovernmentType gov, ResourceType res) {
        techLevel = tech;
        governmentType = gov;
        resourceType = res;
        GenerateMarket gen = new GenerateMarket(tech, res);
        resources = gen.generate();
        credits = 500;
    }

    @Override
    public boolean purchase(Resources resource) {
        Random random = new Random();
        //boolean isDrought = random.nextBoolean();
        double price;
        price = resources.get(resource);
        if (credits >= price) {
            credits-= price;
            //resources.put(resource, Integer.valueOf(price));
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
        Random random = new Random();
        boolean isDrought = random.nextBoolean();
        if (resources.containsKey(resource)) {
            if(isDrought) {
//                Log.i("There's a drought!", "Price of Water Increased");
                if (!scaled) {
                    resources.put(resource, resources.get(resource) * 1.4);
                    scaled = true;
                }
                return resources.get(resource);
            } else {
                return resources.get(resource);
            }
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

    @Override
    public void updateMarketCredits(int credits) {
        this.credits = credits;
    }
}
