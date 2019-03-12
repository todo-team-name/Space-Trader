package cs2340.todo_team_name.spacetrader.enums;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import cs2340.todo_team_name.spacetrader.model.Resource;

public enum Resources implements Serializable {
    WATER("Water", 30, 3, 4, 0),
    FURS("Furs", 250, 10, 10, 0),
    FOOD("Food", 100, 5, 5, 1),
    ORE("Ore", 350, 20, 10, 2),
    GAMES("Games", 250, -10, 5, 3),
    FIREARMS("Fire arms", 1250, -75, 100, 3),
    MEDICINE("Medicine", 650, -20, 10, 4),
    MACHINES("Machines", 900, -30, 5, 4),
    NARCOTICS("Narcotics", 3500, -125, 150, 5),
    ROBOTS("Robots", 5000, -150, 100, 6);

    private String name;
    private int value;
    private int increasePerLevel;
    private int range;
    private int minLevel;
    private HashMap<Resources, ResourceType[]> increasedRes;
    private HashMap<Resources, ResourceType[]> decreasedRes;
    private JSONObject json;


    Resources(String name, int val, int inc, int ran, int lvl) {
        this.name = name;
        value = val;
        increasePerLevel = inc;
        range = ran;
        minLevel = lvl;
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

    public int getIncreasePerLevel() {
        return increasePerLevel;
    }

    public boolean checkLevel(int i) {
        return i >= minLevel;
    }

    public double getScaledValue(TechLevel t) {
        Random rand = new Random();
        int randomScalar = rand.nextInt(range + 1);
        double scalar = ((double) randomScalar) / 100;
        boolean addOrSubtract = rand.nextBoolean();
        double toReturn = 0;
        if (addOrSubtract) {
            toReturn = (value + increasePerLevel * (t.getLevel() - minLevel) + (value * scalar));
        } else {
            toReturn = (value + increasePerLevel * (t.getLevel() - minLevel) - (value * scalar));
        }
        toReturn = toReturn * 100;
        toReturn = Math.round(toReturn);
        toReturn = toReturn / 100;
        return toReturn;
    }

    private void buildIncreasedAndDecreased() {
        /*
        ResourceType[] toAdd = {ResourceType.DESERT};
        increasedRes.put(WATER, toAdd);
        toAdd = {ResourceType.LOTSOFWATER};
        decreasedRes.put(WATER, toAdd);
        toAdd = {ResourceType.LIFELESS};
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
        */
        String json =
                "" + "{" +
                        "        decrease : {" +
                        "" +
                        "                'WATER'         : [LOTSOFWATER]," +
                        "                'FUR'           : [RICHFUANA]," +
                        "                'FOOD'          : [RICHSOIL]," +
                        "                'ORE'           : [MINERALRICH]," +
                        "                'GAMES'         : [ARTISTIC]," +
                        "                'MEDICINE'      : [LOTSOFHERBS]," +
                        "                'NARCOTICS'     : [WEIRDMUSHROOMS]" +
                        "        }" +
                        "" +
                        "        increase : {" +
                        "                'WATER'         : [DESERT]," +
                        "                'FURS'          : [LIFELESS]," +
                        "                'FOOD'          : [POORSOIL]," +
                        "                'ORE'           : [NOSPECIALRESOURCE, WARLIKE]" +
                        "                'FIREARMS'      : [WARLIKE]," +
                        "                'ROBOTS'        : [WARLIKE]" +
                        "        }" +
                        "}";

        try {
            JSONObject jsonObject = new JSONObject(json);
            this.json = jsonObject;
        } catch (JSONException exc) {
            exc.getCause();
        }

    }
}
