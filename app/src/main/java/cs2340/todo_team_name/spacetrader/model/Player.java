package cs2340.todo_team_name.spacetrader.model;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import java.io.Serializable;

/**
 * Class for player of game
 */
public class Player implements Serializable {
    // player name //
    private String name;

    private final HashMap<PointTypes, Integer> points;
    private double credits;
    private Ship ship;
    private Inventory inventory;
    private Market currentMarket;
    private Planet currentPlanet;
    private SolarSystem currentSolarSystem;
    private int fuelCanisters;


    /**
     * Create a Player with allocated skill points
     * @param name name of player
     * @param points  player's skill points
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
//    public boolean equalsAllowedPoints(int pilotPts, int fighterPts,
// int traderPts, int engineerPts) {
//        return (pilotPts + fighterPts + traderPts + engineerPts) == MAX_POINTS;
//    }

    // Getters and Setters //
    /**
     * Returns player name
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets player name
     * @param name name to change to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns player inventory
     * @return player inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Performs player's ability to sell goods
     * @param resource resource for player to sell
     */
    public void sell(Resources resource) {
        if (inventory.checkSelling(resource)) {
            //int currentVal = this.inventory.getInventory().get(resource);
            // inventory.remove(resource);
            //credits += resource.getScaledValue();
            boolean marketCanBuy = currentMarket.purchase(resource);
            if (marketCanBuy) {
                credits += currentMarket.getPriceOfGood(resource);
                inventory.decrementResource(resource);
                //return "You sold " + resource.getName();
            } /*else {
                return "The trader does not have enough credits to purchase this item at this time";
            }
        } else {
            return "You don't appear to have enough of " + resource.getName() + "!";
        }*/
        }
    }

    /**
     * Performs player's ability to buy goods
     * @param resource resource for player to purchase
     */
    public void purchase(Resources resource) {
        /*if(resource.getScaledValue() > credits) {
            return "It doesn't seem you can afford " + resource.getName() + "!";
        }
        else {
            if(this.inventory.getSize() <= this.inventory.getMaxCapacity()){
                inventory.add(resource);
                credits -= resource.getScaledValue();
                return "You sold one " + resource.getName() +"!";
            }
            else return "It doesn't seem you have enough room in your inventory!";

        } */
        if (inventory.checkPurchase()) {
            double price = currentMarket.getPriceOfGood(resource);
            if (credits > price) {
                credits -= price;
                inventory.incrementResource(resource);

                currentMarket.sell(resource);
            }
        }
    }

    /**
     * Updates market for player to use
     * @param m market to update
     */
    public void updateMarket(Market m) {
        currentMarket = m;
    }

    /**
     * Gets player skill point allocation information
     * @param type type of points allocated
     * @return type of points
     */
    public int getPoints(PointTypes type) {
        return points.get(type);
    }

    /**
     * Returns player's credits
     * @return player's credits
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Returns player's current solar system location
     * @return player's current SS location
     */
    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    /**
     * Sets player's current solar system location
     * @param currentSolarSystem player's current SS location
     */
    public void setCurrentSolarSystem(SolarSystem currentSolarSystem) {
        if (fuelCanisters > 0) {
            this.currentSolarSystem = currentSolarSystem;
            setCurrentPlanet(currentSolarSystem.getPlanet(0));
        }
    }

    /**
     * Returns player's current planet location
     * @return player's current planet location
     */
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /**
     * Sets player's current planet location
     * @param currentPlanet player's current planet location
     */
    private void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    /**
     * Decrements player's fuel inventory after travelling
     */
    public void useFuel() {
        fuelCanisters--;
    }

    /**
     * Returns player's current fuel inventory
     * @return player's current fuel inventory
     */
    public int getFuelCanisters() {return fuelCanisters;}

    /**
     * Returns player's current inventory
     * @param res player's resources
     * @return player's current inventory
     */
    public String inventoryString(Resources res) {
        return inventory.resourceToString(res);
    }

    /**
     * Converts player's current SS location to a string
     * @return player's current SS location as a string
     */
    public String currentSolarSystemToString() {
        return currentSolarSystem.toString();
    }

    /**
     * Converts player's current planet location to a string
     * @return player's current planet location as a string
     */
    public String currentPlanetToString() {
        return currentPlanet.toString();
    }

    /**
     * Shows current market based on player's current location
     * @return appropriate market
     */
    public Market currentMarket() {
        return currentPlanet.getMarket();
    }
}
