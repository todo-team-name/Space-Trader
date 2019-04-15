package cs2340.todo_team_name.spacetrader;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import cs2340.todo_team_name.spacetrader.model.GenerateGame;
import cs2340.todo_team_name.spacetrader.model.GenerateMarket;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.Resource;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;

import static org.junit.Assert.assertEquals;


public class TravelTest {

    private Player testPlayer;
    HashSet<SolarSystem> solarSystems;
    @Before
    public void setup() {
        TechLevel tech = TechLevel.AGRICULTURE;
        ResourceType res = ResourceType.ARTISTIC;
        GenerateMarket gen = new GenerateMarket(tech, res);

        HashMap<Resources, Double> resources = gen.generate();
        Inventory inventory = new Inventory(0);
        HashMap<PointTypes, Integer> pointValues = new HashMap<>();
        pointValues.put(PointTypes.PILOT, 4);
        pointValues.put(PointTypes.FIGHTER, 4);
        pointValues.put(PointTypes.ENGINEER, 4);
        pointValues.put(PointTypes.TRADER, 4);
        testPlayer = new Player("Test", pointValues);
        GenerateGame generateGame = new GenerateGame(testPlayer, new HashSet<SolarSystem>());
        solarSystems = generateGame.generate();

    }

    @Test()
    public void checkTravel() {
        assertEquals(10, testPlayer.getFuelCanisters());
        //Uses All Fuel Canisters
        SolarSystem currentSystem = testPlayer.getCurrentSolarSystem();
        for(SolarSystem sol : solarSystems) {
            System.out.println(sol.toString());
            testPlayer.setCurrentSolarSystem(sol);
            testPlayer.useFuel();
        }
        //Player is at Last Solar System, and has 0 fuel left
        currentSystem = testPlayer.getCurrentSolarSystem();
        assertEquals(0, testPlayer.getFuelCanisters());
        for(SolarSystem sol : solarSystems) {
            testPlayer.setCurrentSolarSystem(sol);
            testPlayer.useFuel();
        }
        //Player never move Solar Systems
        assertEquals(0, testPlayer.getFuelCanisters());
        assertEquals(currentSystem, testPlayer.getCurrentSolarSystem());
    }
}