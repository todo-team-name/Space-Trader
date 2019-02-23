package cs2340.todo_team_name.spacetrader.enums;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;

import cs2340.todo_team_name.spacetrader.model.Resource;

public enum Resources {
    WATER("Water", 42, 12),
    FURS("Furs", 285, 35),
    FOOD("Food", 120, 15),
    ORE("Ore", 440, 50),
    GAMES("Games", 210, 30),
    FIREARMS("Fire arms", 950, 225),
    MEDICINE("Medicine", 435, 75),
    MACHINES("Machines", 750, 60),
    NARCOTICS("Narcotics", 3062, 438),
    ROBOTS("Robots", 4175, 225);

    private String name;
    private int value;
    private int range;
    private HashMap<Resources, ResourceType[]> increasedRes;
    private HashMap<Resources, ResourceType[]> decreasedRes;


    Resources(String name, int val, int ran) {
        this.name = name;
        value = val;
        range = ran;
        buildIncreasedAndDecreased();
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getRange() {
        return range;
    }

    public int getScaledValue() {
        int scalar = 1;
        return value;
    }

    private void buildIncreasedAndDecreased() {

        ResourceType[] toAdd = {ResourceType.DESERT};
        increasedRes.put(WATER, toAdd);
        toAdd = {ResourceType.LOTSOFWATER}
        decreasedRes.put(WATER, toAdd);
        toAdd = {ResourceType.LIFELESS}
        increasedRes.put(FURS, toAdd);
        toAdd
        decreasedRes.put(FURS, ResourceType.RICHFUANA);
        increasedRes.put(FOOD, ResourceType.POORSOIL);
        decreasedRes.put(FOOD, ResourceType.RICHSOIL);
        increasedRes.put(ORE, ResourceType.NOSPECIALRESOURCES);
        increasedRes.put(ORE, ResourceType.WARLIKE);
        decreasedRes.put(ORE, ResourceType.MINERALRICH);
        decreasedRes.put(GAMES, ResourceType.ARTISTIC);
        //Maybe add BORED to Resource Type
        increasedRes.put(FIREARMS, ResourceType.WARLIKE);
        decreasedRes.put(MEDICINE, ResourceType.LOTSOFHERBS);
        //maybe add PLAGUED by probably best for event
        decreasedRes.put(NARCOTICS, ResourceType.WEIRDMUSHROOMS);
        //again maybe add BORED for Narcotics
        increasedRes.put(ROBOTS, ResourceType.WARLIKE);

    }
}
