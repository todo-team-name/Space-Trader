package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable {
    /** player name **/
    private String name;

    private HashMap<PointTypes, Integer> points;
    private double credits;
    private Ship ship;
    private Inventory inventory;
    private Market currentMarket;
    private Planet currentPlanet;
    private SolarSystem currentSolarSystem;
    private int fuelCanisters;


    /**
     * Create a Player with allocated skill points
     *
     */
    public Player (String name, HashMap<PointTypes, Integer> points) {
        this.name = name;
        this.points = points;
        this.credits = 100;
        inventory = new Inventory(10);
        fuelCanisters = 10;
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

    public String sell(Resources resource) {
        if(inventory.checkSelling(resource)) {
            //int currentVal = this.inventory.getInventory().get(resource);
            // inventory.remove(resource);
            //credits += resource.getScaledValue();
            boolean marketCanBuy = currentMarket.purchase(resource);
            if (marketCanBuy) {
                credits += currentMarket.getPriceOfGood(resource);
                inventory.decrementResource(resource);
                return "You sold " + resource.getName();
            } else {
                return "The trader does not have enough credits to purchase this item at this time";
            }
        } else {
            return "You don't appear to have enough of " + resource.getName() + "!";
        }
    }

    public String purchase(Resources resource) {
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
                inventory.incrementResource(resource);
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

    public int getPoints(PointTypes type) {
        return points.get(type);
    }

    public double getCredits() {
        return credits;
    }

    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    public void setCurrentSolarSystem(SolarSystem currentSolarSystem) {
        if (fuelCanisters > 0) {
            this.currentSolarSystem = currentSolarSystem;
            setCurrentPlanet(currentSolarSystem.getPlanet(0));
        }
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }
    public void useFuel() {
        fuelCanisters--;
    }

    public int getFuelCanisters() {return fuelCanisters;}
}
