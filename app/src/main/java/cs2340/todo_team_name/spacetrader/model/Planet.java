package cs2340.todo_team_name.spacetrader.model;

import java.io.Serializable;

import androidx.annotation.NonNull;
import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.MarketType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
/**
 * Planet class, used for travel and updating markets
 */
public class Planet implements Serializable {
    private ResourceType resources;
    private final TechLevel techLevel;
    private final GovernmentType governmentType;
    private final MarketType marketType;
    private final String name;
    private final String hexColor;
    private Market market;


    /**
     * Creates a Planet
     * @param n planet name
     * @param tech planet's tech level
     * @param gov planet's government type
     * @param market planet's market type
     * @param hex planet's color
     * @param res planet's resources
     */
    public Planet(String n, TechLevel tech, GovernmentType gov, MarketType market,
                  String hex, ResourceType res) {
        this.name = n;
        this.techLevel = tech;
        this.governmentType = gov;
        this.marketType = market;
        this.hexColor = hex;
        this.resources = res;
        if (this.marketType.equals(MarketType.BASIC)) {
            this.market = new BasicMarket(tech, gov, res);
        } else {
            this.market = new ShipMarket(tech, gov, res);
        }
    }

    /**
     * Performs purchase operation
     * @param resource resource to purchase
     * @return confirmation of purchase or error message if uncompleted
     */
    public String purchase(Resources resource) {
        boolean purchased = market.purchase(resource);
        if (purchased) {
            return "You just purchased " + resource.getName();
        } else {
            return "Sorry, that item could not be purchased";
        }
    }

    /**
     * Performs sale
     * @param resource resource to sell
     * @return confirmation of sale
     */
    public String sell(Resources resource) {
        market.sell(resource);
        return "You just sold " + resource.getName();
        /*if (purchased) {
            return "You just sold " + resource.getName();

        } else {
            return "Sorry, that item could not be sold";
        }*/
    }


    @NonNull
    @Override
    public String toString() {
        return name;
    }

    /**
     * Updates player's market
     * @param p
     */
    public void updatePlayerMarket(Player p) {
        p.updateMarket(market);
    }

    /**
     * Returns current market
     * @return current market
     */
    public Market getMarket() {
        return market;
    }

}
