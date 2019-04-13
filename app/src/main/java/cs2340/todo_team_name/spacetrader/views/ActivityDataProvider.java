package cs2340.todo_team_name.spacetrader.views;

import java.util.ArrayList;

import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

public interface ActivityDataProvider {
    public Player getPlayer();
    public Planet getCurrentPlanet();
    public PlayerViewModel getPlayerViewModel();
    public ArrayList<SolarSystem> getSolarSystems();
}
