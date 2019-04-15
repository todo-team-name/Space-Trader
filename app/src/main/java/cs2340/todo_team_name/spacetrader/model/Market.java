package cs2340.todo_team_name.spacetrader.model;

import cs2340.todo_team_name.spacetrader.enums.Resources;

import java.io.Serializable;
/**
 * Creates Market class
 */

public abstract class Market implements Serializable {
    /**
     *
     * @param resource resource to buy
     * @return true of false if purchased
     */
    public abstract boolean purchase(Resources resource);

    /**
     *
     * @param resource resource to buy
     */
    public abstract void sell(Resources resource);

    /**
     *
     * @param resource resource to get price of
     * @return price of good
     */
    public abstract double getPriceOfGood(Resources resource);

    /**
     *
     * @param resource resource to check
     * @return true or false if market sells it
     */
    public abstract boolean contains(Resources resource);

    /**
     *
     * @param res resource to get string value of to display
     * @return string value of resource
     */
    public abstract String displayResource(Resources res);

    public abstract void updateMarketCredits(int credits);
}
