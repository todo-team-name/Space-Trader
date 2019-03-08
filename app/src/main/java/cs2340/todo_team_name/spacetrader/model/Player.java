package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.Resources;

public class Player {
    /** player name **/
    private String name;

    private HashMap<PointTypes, Integer> points;
    private double credits;
    private Ship ship;
    private Inventory inventory;
    private Market currentMarket;


    /**
     * Create a Player with allocated skill points
     *
     */
    public Player (String name, HashMap<PointTypes, Integer> points) {
        this.name = name;
        this.points = points;
        this.credits = 100;
        inventory = new Inventory(10);
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


    public Inventory getInventory() {
        return inventory;
    }

    public String sell(Resource resource) {
        if(inventory.checkSelling(resource)) {
            //int currentVal = this.inventory.getInventory().get(resource);
            // inventory.remove(resource);
            //credits += resource.getScaledValue();
            boolean marketCanBuy = currentMarket.purchase(resource);
            if (marketCanBuy) {
                credits += currentMarket.getPriceOfGood(resource);
                inventory.decrementResource(resource);
                return "You sold " + resource.getType();
            } else {
                return "The trader does not have enough credits to purchase this item at this time";
            }
        } else {
            return "You don't appear to have enough of " + resource.getType() + "!";
        }
    }

    public String purchase(Resource resource) {
        /**if(resource.getScaledValue() > credits) {
            return "It doesn't seem you can afford " + resource.getName() + "!";
        }
        else {
            if(this.inventory.getSize() <= this.inventory.getMaxCapacity()){
                inventory.add(resource);
                credits -= resource.getScaledValue();
                return "You sold one " + resource.getName() +"!";
            }
            else return "It doesn't seem you have enough room in your inventory!";

        } **/
        if (inventory.checkPurchase()) {
            double price = currentMarket.getPriceOfGood(resource);
            if (credits > price) {
                credits -= price;
                inventory.incrementResoure(resource);
                currentMarket.sell(resource);
            } else {
                return "You don't have enough credits to afford this good";
            }
        } else {
            return "Inventory is currently full";
        }
        return "Error";
    }

    public void updateMarket(Market m) {
        currentMarket = m;
    }
}
