package cs2340.todo_team_name.spacetrader;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.GovernmentType;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import cs2340.todo_team_name.spacetrader.model.BasicMarket;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Player;

import static org.junit.Assert.assertEquals;
//By Chasse Rush
public class SellResourceTest {
    private Player player;
    private HashMap<PointTypes, Integer> points;
    private Market market;
    @Before
    public void setUp() {
        points = new HashMap<>();
        points.put(PointTypes.PILOT, 4);
        points.put(PointTypes.FIGHTER, 4);
        points.put(PointTypes.ENGINEER, 4);
        points.put(PointTypes.TRADER, 4);

        TechLevel tech = TechLevel.HITECH;
        ResourceType res = ResourceType.ARTISTIC;
        GovernmentType gov = GovernmentType.CAPITALIST;
        market = new BasicMarket(tech, gov, res);
        player = new Player("Chasse", points);
        player.updateMarket(market);
    }

    @Test
    public void testSellResourceEmpty() {
        Inventory inventory = player.getInventory();
        assertEquals(0, inventory.getResource(Resources.WATER));
        player.sell(Resources.WATER);
        inventory = player.getInventory();
        assertEquals(100, (long) player.getCredits());
        assertEquals(0, inventory.getResource(Resources.WATER));
    }
    @Test
    public void testSellResource() {
        Inventory inventory = player.getInventory();
        assertEquals(0, inventory.getResource(Resources.WATER));
        inventory.add(Resources.WATER);
        assertEquals(100, (long) player.getCredits());
        player.sell(Resources.WATER);
        assertEquals((long) (100 + market.getPriceOfGood(Resources.WATER)), (long) player.getCredits());
    }

    @Test
    public void testSellResourceMarketCannotBuy() {
        Inventory inventory = player.getInventory();
        assertEquals(0, inventory.getResource(Resources.WATER));
        market.updateMarketCredits(0);
        inventory.add(Resources.WATER);
        assertEquals(100, (long) player.getCredits());
        player.sell(Resources.WATER);
        assertEquals(1, inventory.getResource(Resources.WATER));
        assertEquals(100, (long) player.getCredits());
    }
}
