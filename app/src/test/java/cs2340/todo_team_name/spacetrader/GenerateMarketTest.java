package cs2340.todo_team_name.spacetrader;
import org.junit.Test;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.model.GenerateMarket;
import cs2340.todo_team_name.spacetrader.enums.ResourceType;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.enums.TechLevel;

public class GenerateMarketTest {
    GenerateMarket marketGenerator;
    @Test
    public void checkGenerateDesertAgricultureMarket() {
        marketGenerator = new GenerateMarket(TechLevel.AGRICULTURE, ResourceType.DESERT);
        HashMap<Resources, Double> market = marketGenerator.generate();
        assert(market.keySet().contains(Resources.FURS));
        assert(market.keySet().contains(Resources.FOOD));
        assert(market.keySet().contains(Resources.WATER));
        assert(market.keySet().size() == 3);
    }
    @Test
    public void checkGenerateHitechArtisticMarket() {
        marketGenerator = new GenerateMarket(TechLevel.HITECH, ResourceType.ARTISTIC);
        HashMap<Resources, Double> market = marketGenerator.generate();
        assert(market.keySet().contains(Resources.FIREARMS));
        assert(market.keySet().contains(Resources.ORE));
        assert(market.keySet().contains(Resources.FOOD));
        assert(market.keySet().contains(Resources.MEDICINE));
        assert(market.keySet().contains(Resources.NARCOTICS));
        assert(market.keySet().contains(Resources.MACHINES));
        assert(market.keySet().contains(Resources.ROBOTS));
        assert(market.keySet().contains(Resources.WATER));
        assert(market.keySet().contains(Resources.FURS));
        assert(market.keySet().contains(Resources.GAMES));
        assert(market.keySet().size() == 10);
    }
}