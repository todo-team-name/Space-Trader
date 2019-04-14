package cs2340.todo_team_name.spacetrader.model;

import java.io.Serializable;
import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class GenerateMarket implements Serializable {

    private final TechLevel techLevel;
    private final ResourceType resourceType;

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
                //Resource toAdd = new Resource(r);
                res.put(r, r.getScaledValue(techLevel));
            }
        }
        return res;
    }

}
