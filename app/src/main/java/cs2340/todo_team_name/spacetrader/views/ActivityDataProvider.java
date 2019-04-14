package cs2340.todo_team_name.spacetrader.views;

import java.util.ArrayList;

import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;

interface ActivityDataProvider {
    Player getPlayer();
    Planet getCurrentPlanet();
    ArrayList<SolarSystem> getSolarSystems();
}
