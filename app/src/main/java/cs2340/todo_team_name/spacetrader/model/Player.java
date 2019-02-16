package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;

public class Player {
    /** player name **/
    private String name;

    private HashMap<PointTypes, Integer> points;


    /**
     * Create a Player with allocated skill points
     *
     */
    public Player (String name, HashMap<PointTypes, Integer> points) {
        this.name = name;
        this.points = points;
    }

//    /**
//     * Checks if a potential Player's skill points equal the allowed number of points.
//     *
//     * @param pilotPts - amount of allocated pilotPoints
//     * @param fighterPts - amount of allocated fighterPoints
//     * @param traderPts - amount of allocated traderPoints
//     * @param engineerPts - amount of allocated engineerPoints
//     * @return true if the number of allocated points equal the number allowed. false if
//     * not enough or too many points have been allocated.
//     */
//    public boolean equalsAllowedPoints(int pilotPts, int fighterPts, int traderPts, int engineerPts) {
//        return (pilotPts + fighterPts + traderPts + engineerPts) == MAX_POINTS;
//    }

    /** Getters and Setters **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
