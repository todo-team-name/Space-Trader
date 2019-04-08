package cs2340.todo_team_name.spacetrader.viewmodel;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import cs2340.todo_team_name.spacetrader.model.BasicMarket;
import cs2340.todo_team_name.spacetrader.model.Market;

public class MarketSerializer implements JsonSerializer<Market> {
    public JsonElement serialize(Market src, Type typeOfSrc, JsonSerializationContext context) {
        Gson gson = new Gson();
        return new JsonPrimitive(gson.toJson(src, BasicMarket.class));
    }

}
