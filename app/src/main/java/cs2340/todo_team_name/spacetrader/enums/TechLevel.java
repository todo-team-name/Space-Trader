package cs2340.todo_team_name.spacetrader.enums;

import org.json.JSONException;
import org.json.JSONObject;

public enum TechLevel {
    PREAGRICULTURE, AGRICULTURE, MEDIEVAL, RENAISSANCE, EARLYINDUSTRIAL, INDUSTRIAL,
    POSTINDUSTRIAL, HITECH;

    private String json = "" +
            "{" +
            "        techlevel : {" +
            "" +
            "                'PREAGRICULTURE' : [WATER, FUR]," +
            "                'AGRICULTURE'    : [WATER, FOOD, FUR]," +
            "                'MEDIEVAL'       : [WATER, FOOD, FUR, ORE]," +
            "                'RENAISSANCE'    : [WATER, FOOD, FUR, ORE, GAMES]," +
            "                'EARLYINDUSTRIAL': [WATER, FOOD, FUR, ORE, GAMES, FIREARMS, NARCOTICS]," +
            "                'INDUSTRIAL'     : [WATER, FOOD, FUR, ORE, GAMES, FIREARMS, NARCOTICS, MEDICINE, MACHINES]," +
            "                'POSTINDUSTRIAL' : [WATER, FOOD, FUR, ORE, GAMES, FIREARMS, NARCOTICS, MEDICINE, MACHINES, ROBOTS]," +
            "                'HITECH'         : [WATER, FOOD, FUR, ORE, GAMES, FIREARMS, NARCOTICS, MEDICINE, MACHINES, ROBOTS]" +
            "" +
            "        }" +
            "" +
            "}";

    private JSONObject jsonObject;

    public JSONObject resourceTechLevels() {
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException exception) {
            exception.getCause();
        }
        return jsonObject;
    }


}
