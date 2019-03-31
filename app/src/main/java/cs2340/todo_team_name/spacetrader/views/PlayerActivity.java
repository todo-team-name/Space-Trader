package cs2340.todo_team_name.spacetrader.views;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

public class PlayerActivity extends AppCompatActivity implements ActivityDataProvider {
    private PlayerViewModel playerViewModel;
    private ArrayList<SolarSystem> solarSystems;
    private HashMap<PointTypes, Integer> pointValues;
    private TextView pilot;
    private TextView trader;
    private TextView fighter;
    private TextView engineer;
    private TextView name;
    private TextView credits;
    private Player player;
    private BottomNavigationView nav;
    private TextView water;
    private TextView furs;
    private TextView food;
    private TextView firearms;
    private TextView ore;
    private Stack<View> viewStack;
    private Planet currentPlanet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.commander_status_fragment);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        player = (Player) intent.getSerializableExtra("player");
        solarSystems = (ArrayList<SolarSystem>) intent.getSerializableExtra("universe");
        currentPlanet = solarSystems.get(0).getPlanet(0);
        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        playerViewModel.setPlayer(player);
        playerViewModel.checkSolar(solarSystems.get(0));
        loadFragment(new Status_Fragment());
        pilot = findViewById(R.id.pilot_card_info);
        trader = findViewById(R.id.trader_card_info);
        fighter = findViewById(R.id.fighter_card_info);
        engineer = findViewById(R.id.engineer_card_info);
        credits = findViewById(R.id.funds_status);
        nav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        viewStack = new Stack<>();
        nav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_status:
                                Log.i("Stats", "These Stats");
                                loadFragment(new Status_Fragment());
                                break;
                            case R.id.menu_map:
                                Log.i("Map", "This Map");
                                loadFragment(new MapActivity());
                                break;
                            case R.id.menu_market:
                                Log.i("Market", "This market");
                                loadFragment(new MarketActivity());
                                break;
                        }
                        return false;
                    }
                });
        /*String creds = "$";
        creds = creds + Double.toString(player.getCredits());
        Log.i("Player", player.toString());
        credits.setText(creds);
        pilot.setText(Integer.toString(player.getPoints(PointTypes.PILOT)));
        trader.setText(Integer.toString(player.getPoints(PointTypes.TRADER)));
        fighter.setText(Integer.toString(player.getPoints(PointTypes.FIGHTER)));
        engineer.setText(Integer.toString(player.getPoints(PointTypes.ENGINEER)));*/
    }

    private void switchToMarketView() {
        View currentView = this.findViewById(android.R.id.content);
        viewStack.add(currentView);
        setContentView(R.layout.market_fragment);
        water = findViewById(R.id.water_cargo_info);
        furs = findViewById(R.id.furs_cargo_info);
        food = findViewById(R.id.food_cargo_info);
        firearms = findViewById(R.id.firearms_cargo_info);
        ore = findViewById(R.id.ore_cargo_info);
    }

    /*@Override
    public void onBackPressed() {
        View newview = viewStack.pop();
        setContentView(newview);
    }*/

    public void openBuyMarket(View view) {
        loadFragment(new Buy_Market_Fragment());
    }

    public void openSellMarket(View view) {
        loadFragment(new Sell_Market_Fragment());
    }

    public void openChangeSystem(View view) { loadFragment(new Change_System_Fragment());}


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }


    public void buyItem(View view) {
        Buy_Market_Fragment frag = (Buy_Market_Fragment) getSupportFragmentManager().findFragmentById(R.id.fragments);
        switch (view.getId()) {
            case R.id.buy_water_plus:
                playerViewModel.handleBuyItem("WATER", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_water_display);
                break;
            case R.id.buy_furs_plus:
                playerViewModel.handleBuyItem("FURS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_furs_display);
                break;
            case R.id.buy_food_plus:
                playerViewModel.handleBuyItem("FOOD", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_food_display);
                break;
            case R.id.buy_ore_plus:
                playerViewModel.handleBuyItem("ORE", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_ore_display);
                break;
            case R.id.buy_firearms_plus:
                playerViewModel.handleBuyItem("FIREARMS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_firearms_display);
                break;
        }

    }

    public void trySellItem(View view) {
        Buy_Market_Fragment frag = (Buy_Market_Fragment) getSupportFragmentManager().findFragmentById(R.id.fragments);
        switch (view.getId()) {
            case R.id.buy_water_minus:
                playerViewModel.handleSellItem("WATER", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_water_display);
                break;
            case R.id.buy_furs_minus:
                playerViewModel.handleSellItem("FURS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_furs_display);
                break;
            case R.id.buy_food_minus:
                playerViewModel.handleSellItem("FOOD", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_food_display);
                break;
            case R.id.buy_ore_minus:
                playerViewModel.handleSellItem("ORE", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_ore_display);
                break;
            case R.id.buy_firearms_minus:
                playerViewModel.handleSellItem("FIREARMS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                frag.updateCredits();
                frag.updateView(view, R.id.buy_firearms_display);
                break;
        }
    }

    public void buyItemSell(View view) {
        Sell_Market_Fragment sellFrag = (Sell_Market_Fragment) getSupportFragmentManager().findFragmentById(R.id.fragments);
        switch (view.getId()) {
            case R.id.sell_water_plus:
                playerViewModel.handleBuyItem("WATER", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_water_display);                break;
            case R.id.sell_furs_plus:
                playerViewModel.handleBuyItem("FURS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_furs_display);
                break;
            case R.id.sell_food_plus:
                playerViewModel.handleBuyItem("FOOD", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_food_display);
                break;
            case R.id.sell_ore_plus:
                playerViewModel.handleBuyItem("ORE", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_ore_display);
                break;
            case R.id.sell_firearms_plus:
                playerViewModel.handleBuyItem("FIREARMS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_firearms_display);
                break;
        }
    }

    public void sellItemSell(View view) {
        Sell_Market_Fragment sellFrag = (Sell_Market_Fragment) getSupportFragmentManager().findFragmentById(R.id.fragments);
        switch (view.getId()) {
            case R.id.sell_water_minus:
                playerViewModel.handleSellItem("WATER", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_water_display);
                break;
            case R.id.sell_furs_minus:
                playerViewModel.handleSellItem("FURS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_furs_display);
                break;
            case R.id.sell_food_minus:
                playerViewModel.handleSellItem("FOOD", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_food_display);
                break;
            case R.id.sell_ore_minus:
                playerViewModel.handleSellItem("ORE", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_ore_display);
                break;
            case R.id.sell_firearms_minus:
                playerViewModel.handleSellItem("FIREARMS", currentPlanet);
                Log.i("Creds", Double.toString(player.getCredits()));
                sellFrag.updateCredits();
                sellFrag.updateView(view, R.id.sell_firearms_display);
                break;
        }
    }




    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void changeSystem(View view) {
        switch (view.getId()) {
            case R.id.system1button:
                player.setCurrentSolarSystem(solarSystems.get(0));
                break;
            case R.id.system2button:
                player.setCurrentSolarSystem(solarSystems.get(1));
                break;
            case R.id.system3button:
                player.setCurrentSolarSystem(solarSystems.get(2));
                break;
            case R.id.system4button:
                player.setCurrentSolarSystem(solarSystems.get(3));
                break;
            case R.id.system5button:
                player.setCurrentSolarSystem(solarSystems.get(4));
                break;
            case R.id.system6button:
                player.setCurrentSolarSystem(solarSystems.get(5));
                break;
            case R.id.system7button:
                player.setCurrentSolarSystem(solarSystems.get(6));
                break;
            case R.id.system8button:
                player.setCurrentSolarSystem(solarSystems.get(7));
                break;
            case R.id.system9button:
                player.setCurrentSolarSystem(solarSystems.get(8));
                break;
            case R.id.system10button:
                player.setCurrentSolarSystem(solarSystems.get(9));
                break;
        }
        currentPlanet = player.getCurrentPlanet();
        loadFragment(new MapActivity());
    }


}
