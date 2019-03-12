package cs2340.todo_team_name.spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class GenerateMarket {

    private TechLevel techLevel;
    private ResourceType resourceType;

    public GenerateMarket(TechLevel t, ResourceType r) {
        techLevel = t;
        resourceType = r;
    }

    public HashMap<Resources, Double> generate() {
        HashMap<Resources, Double> res = new HashMap<>();
        Resources[] allResources = Resources.values();
        for (Resources r: allResources) {
            boolean canAdd = r.checkLevel(techLevel.getLevel());
            if (canAdd) {
                Resource toAdd = new Resource(r);
                res.put(r, r.getScaledValue(techLevel));
            }
        }
        return res;
    }

}
