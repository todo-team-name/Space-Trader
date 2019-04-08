package cs2340.todo_team_name.spacetrader.viewmodel;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import cs2340.todo_team_name.spacetrader.model.BasicMarket;
import cs2340.todo_team_name.spacetrader.model.Market;

public class MarketDeserializer implements JsonDeserializer<Market> {
    public Market deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String jsonString = json.getAsJsonObject().toString();
        Log.i("JSON STRING", jsonString);
        Gson gson = new Gson();
        return gson.fromJson(jsonString, BasicMarket.class);
    }
}
