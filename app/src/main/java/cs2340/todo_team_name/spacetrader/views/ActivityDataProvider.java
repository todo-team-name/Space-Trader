package cs2340.todo_team_name.spacetrader.views;

import java.util.ArrayList;

import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;

/**
 * interface for activities to pass data to fragments
 */
interface ActivityDataProvider {
    /**
     *
     * @return current player
     */
    Player getPlayer();

    /**
     *
     * @return current planet
     */
    Planet getCurrentPlanet();

    /**
     *
     * @return solar systems in game
     */
    ArrayList<SolarSystem> getSolarSystems();
}
