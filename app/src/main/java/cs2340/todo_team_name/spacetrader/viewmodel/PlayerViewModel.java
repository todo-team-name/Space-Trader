package cs2340.todo_team_name.spacetrader.viewmodel;

import android.app.Application;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.views.ConfigurationActivity;
import cs2340.todo_team_name.spacetrader.views.PlayerActivity;

public class PlayerViewModel extends ViewModel {
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    //from point of view of buyer
    public void handleBuyItem(String res, Planet current) {
        Resources resource = Resources.valueOf(res);
        current.updatePlayerMarket(player);
        player.purchase(resource);
    }

    //From point of view of buyer
    public void handleSellItem(String res, Planet current) {
        Resources resource = Resources.valueOf(res);
        current.updatePlayerMarket(player);
        player.sell(resource);
    }
  
    public HashMap<Resources, String> getAvailableItems(Market market) {
        Resources possible[] = Resources.values();
        HashMap<Resources, String> output = new HashMap<>();
        for (Resources res: possible) {
            String s = "";
            if (market.contains(res)) {
                s = res.getName() + ": " + market.getPriceOfGood(res);
            } else {
                s = "N/A";
            }
            output.put(res, s);
        }
        return output;
    }
  
    public void updateLocation(SolarSystem system) {
        player.setCurrentSolarSystem(system);
    }

    public void checkSolar(SolarSystem solarSystem) {
        if (player.getCurrentSolarSystem() == null) {
            player.setCurrentSolarSystem(solarSystem);
        }

    }

    public boolean updateInfo(Player player, ArrayList<SolarSystem> solarSystem, final String token, PlayerActivity act) {
        SolarSystem[] solarSystems = new SolarSystem[solarSystem.size()];
        solarSystems = solarSystem.toArray(solarSystems);
        JSONObject data = new JSONObject();
        JSONObject androidData = new JSONObject();
        Gson gson = new Gson();
        String playerJson = gson.toJson(player);
        String[] solarStrings = new String[solarSystem.size()];
        int i = 0;
        for (SolarSystem s : solarSystem) {
            solarStrings[i] = gson.toJson(s);
            i++;
        }
        String solarArr = gson.toJson(solarStrings);
        try {
            androidData.put("player", playerJson);
            androidData.put("solarsystems", solarArr);
            data.put("game_info_android", androidData);
        } catch (Exception e) {
            //TODO HANDLE EXCEPTION
        }
        String jsonBody = data.toString();
        final String finalToken = token;
        RequestQueue queue = Volley.newRequestQueue(act);
        String url = "https://space-trader-backend.herokuapp.com/api/users/update";
        Log.i("DATA SENT", data.toString());
        Log.i("PREPPING", "REQUEST");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, data, new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("MY RESPONSE", "SAVED");

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.i("FAILED", "THIS FAILED");
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                String auth = "Bearer " + finalToken;
                Log.i("AUTH STRING", auth);
                params.put("Content-Type", "application/json");
                params.put("Authorization", auth);

                return params;
            }
        };
        queue.add(jsonObjectRequest);
        /* OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonBody);

        Request request = new Request.Builder()
                .url("http://localhost:4040/api/users/update")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + token)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            //TODO
        } */
        return false;
    }
}
