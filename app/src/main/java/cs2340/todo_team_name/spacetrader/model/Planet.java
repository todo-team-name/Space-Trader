package cs2340.todo_team_name.spacetrader.model;

import java.io.Serializable;

import androidx.annotation.NonNull;
import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.MarketType;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class Planet implements Serializable {
    private ResourceType resources;
    private final TechLevel techLevel;
    private final GovernmentType governmentType;
    private final MarketType marketType;
    private final String name;
    private final String hexColor;
    private Market market;

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

    public String purchase(Resources resource) {
        boolean purchased = market.purchase(resource);
        if (purchased) {
            return "You just purchased " + resource.getName();
        } else {
            return "Sorry, that item could not be purchased";
        }
    }

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

    public void updatePlayerMarket(Player p) {
        p.updateMarket(market);
    }

    public Market getMarket() {
        return market;
    }

}
