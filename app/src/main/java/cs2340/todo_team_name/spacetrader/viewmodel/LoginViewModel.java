package cs2340.todo_team_name.spacetrader.viewmodel;


import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;

import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.views.LoginActivity;

public class LoginViewModel extends AndroidViewModel {

    private String token = " ";
    private Intent toSend;
    private LoginActivity currentActivity;
    public LoginViewModel (@NonNull Application application) {
        super(application);
    }

    public void login_request(String username, String password, LoginActivity act, Intent intent) {
        RequestQueue queue = Volley.newRequestQueue(act);
        toSend = intent;
        String url = "https://space-trader-backend.herokuapp.com/api/users/login";
        JSONObject data = new JSONObject();
        currentActivity = act;
        try {
            data.put("username", username);
            data.put("password", password);
        } catch (Exception e) {
            //HANDLE
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, data, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject toReturn = new JSONObject(response.toString());
                            token = toReturn.getString("token");
                            toSend.putExtra("token", token);
                            Log.i("TOKEN IN LOGIN VIEWMODEL", token);
                            getData();
                        } catch (Exception e) {
                            //HANDLE
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // HANDLE

                    }
                });
        queue.add(jsonObjectRequest);
    }

    /*public String tokenResult() {
        if (token.equals(" ")) {
            return null;
        } else {
            return token;
        }
    }*/

    private void getData() {
        final String finalToken = token;
        RequestQueue queue = Volley.newRequestQueue(currentActivity);
        String url = "https://space-trader-backend.herokuapp.com/api/users/update";
        Log.i("PREPPING", "REQUEST");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(),
                        new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Market.class, new MarketSerializer());
                        gsonBuilder.registerTypeAdapter(Market.class, new MarketDeserializer());
                        Gson gson = gsonBuilder.create();
                        try {
                            JSONObject androidInfo = response.getJSONObject("game_info_android");
                            String playerString = androidInfo.getString("player");
                            Player returnedPlayer = gson.fromJson(playerString, Player.class);
                            String solar = androidInfo.getString("solarsystems");
                            String[] solarStrings = gson.fromJson(solar, String[].class);
                            ArrayList<SolarSystem> solarList = new ArrayList<>();
                            for (String s: solarStrings) {
                                SolarSystem curr = gson.fromJson(s, SolarSystem.class);
                                solarList.add(curr);
                            }
                            toSend.putExtra("player", returnedPlayer);
                            toSend.putExtra("universe", solarList);
                            currentActivity.startActivity(toSend);
                        } catch (Exception e) {
                            Log.i("ERROR IN GETTING DATA", e.getMessage());
                        }



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // HANDLE
                        Log.i("FAILED", "THIS FAILED");
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                String auth = "Bearer " + finalToken;
                Log.i("AUTH STRING", auth);
                params.put("Content-Type", "application/json");
                params.put("Authorization", auth);

                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }

    public void createAccountRequest(Intent intent, LoginActivity act) {
        toSend = intent;
        currentActivity = act;
        RequestQueue queue = Volley.newRequestQueue(act);
        String url = "https://space-trader-backend.herokuapp.com/api/users/signup";
        JSONObject data = new JSONObject();
        currentActivity = act;
        try {
            data.put("username", toSend.getStringExtra("username"));
            data.put("password", toSend.getStringExtra("password"));
        } catch (Exception e) {
            //HANDLE
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, data, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject toReturn = new JSONObject(response.toString());
                            token = toReturn.getString("token");
                            toSend.putExtra("token", token);
                            Log.i("TOKEN IN LOGIN VIEWMODEL", token);
                            currentActivity.startActivity(toSend);
                        } catch (Exception e) {
                            //HANDLE
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // HANDLE

                    }
                });
        queue.add(jsonObjectRequest);
    }
}