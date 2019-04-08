package cs2340.todo_team_name.spacetrader;

import org.junit.Test;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;
import cs2340.todo_team_name.spacetrader.model.GenerateMarket;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.Resource;

import static org.junit.Assert.assertEquals;


public class PurchaseResourceTest {
    @Test()
    public void checkPurchaseResource() {
        TechLevel tech = TechLevel.AGRICULTURE;
        ResourceType res = ResourceType.ARTISTIC;
        GenerateMarket gen = new GenerateMarket(tech, res);
        HashMap<Resources, Double> resources = gen.generate();
        double credits = 100;
        Resources resource = Resources.WATER;
        int price = 30;
        Market market;
        Inventory inventory = new Inventory(0);
        HashMap<PointTypes, Integer> pointValues = new HashMap<>();
        pointValues.put(PointTypes.PILOT, 4);
        pointValues.put(PointTypes.FIGHTER, 4);
        pointValues.put(PointTypes.ENGINEER, 4);
        pointValues.put(PointTypes.TRADER, 4);
        Player testPlayer = new Player("Test", pointValues);

        // Inventory size < capacity
        assertEquals(true, inventory.checkPurchase());

        assertEquals(price, resource.getValue());
        assertEquals(credits, testPlayer.getCredits(), 0.0f);

        // Enough credits to purchase
        testPlayer.purchase(resource);
        double updatedCredits = 70;
        assertEquals(updatedCredits, testPlayer.getCredits(), 0.0f);

        resource = Resources.FURS;

        // Not enough credits
        testPlayer.purchase(resource);
        assertEquals(credits, testPlayer.getCredits(), 0.0f);
    }
}
