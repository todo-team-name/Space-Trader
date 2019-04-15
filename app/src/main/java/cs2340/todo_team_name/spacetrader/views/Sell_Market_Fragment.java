package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.HashMap;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

/**
 * Activity for sell market fragment
 */
public class Sell_Market_Fragment extends Fragment {
    //private ActivityDataProvider activity;
    //private TextView water;
    private TextView credits;
    /*private TextView furs;
    private TextView food;
    private TextView firearms;
    private TextView ore;
    private TextView games;
    private TextView medicine;
    private TextView machines;
    private TextView narcotics;
    private TextView robots;*/
    private Player player;
    //private Planet currentPlanet;
    private TextView waterDisplay;
    private TextView fursDisplay;
    private TextView foodDisplay;
    private TextView firearmsDisplay;
    private TextView oreDisplay;
    private TextView gameDisplay;
    private TextView medicineDisplay;
    private TextView machineDisplay;
    private TextView narcoticsDisplay;
    private TextView robotsDisplay;


    /**
     * Handles creating the view for our Sell_Market_Fragment
     * @param inflater a layout inflater
     * @param container a layout container
     * @param savedInstanceState a saved instance state
     * @return a created view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ActivityDataProvider activity;
        TextView water;
        TextView furs;
        TextView food;
        TextView firearms;
        TextView ore;
        TextView games;
        TextView medicine;
        TextView machines;
        TextView narcotics;
        TextView robots;
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        Planet currentPlanet = activity.getCurrentPlanet();
        //PlayerViewModel playerViewModel = activity.getPlayerViewModel();
        PlayerViewModel playerViewModel = new PlayerViewModel();
        Market currentMarket = player.currentMarket();
        HashMap<Resources, String> strings = playerViewModel.configureItemMap(currentMarket);
        View view = inflater.inflate(R.layout.sell_cargo_fragment, null);
        credits = view.findViewById(R.id.available_credit_display);
        credits.setText(Double.toString(player.getCredits()));

        water = view.findViewById(R.id.sell_water_label);
        furs = view.findViewById(R.id.sell_furs_label);
        food = view.findViewById(R.id.sell_food_label);
        firearms = view.findViewById(R.id.sell_firearms_label);
        ore = view.findViewById(R.id.sell_ore_label);
        games = view.findViewById(R.id.sell_games_label);
        medicine = view.findViewById(R.id.sell_medicine_label);
        machines = view.findViewById(R.id.sell_machines_label);
        narcotics = view.findViewById(R.id.sell_narcotics_label);
        robots = view.findViewById(R.id.sell_robots_label);

        waterDisplay = view.findViewById(R.id.sell_water_display);
        fursDisplay = view.findViewById(R.id.sell_furs_display);
        foodDisplay = view.findViewById(R.id.sell_food_display);
        firearmsDisplay = view.findViewById(R.id.sell_firearms_display);
        oreDisplay = view.findViewById(R.id.sell_ore_display);
        gameDisplay = view.findViewById(R.id.sell_games_display);
        medicineDisplay = view.findViewById(R.id.sell_medicine_display);
        machineDisplay = view.findViewById(R.id.sell_machines_display);
        narcoticsDisplay = view.findViewById(R.id.sell_narcotics_display);
        robotsDisplay = view.findViewById(R.id.sell_robots_display);

        Inventory currentInventory = player.getInventory();
        waterDisplay.setText(player.inventoryString(Resources.WATER));
        fursDisplay.setText(player.inventoryString(Resources.FURS));
        foodDisplay.setText(player.inventoryString(Resources.FOOD));
        firearmsDisplay.setText(player.inventoryString(Resources.FIREARMS));
        oreDisplay.setText(player.inventoryString(Resources.ORE));
        medicineDisplay.setText(player.inventoryString(Resources.MEDICINE));
        machineDisplay.setText(player.inventoryString(Resources.MACHINES));
        gameDisplay.setText(player.inventoryString(Resources.GAMES));
        narcoticsDisplay.setText(player.inventoryString(Resources.NARCOTICS));
        robotsDisplay.setText(player.inventoryString(Resources.ROBOTS));

        water.setText(strings.get(Resources.WATER));
        furs.setText(strings.get(Resources.FURS));
        food.setText(strings.get(Resources.FOOD));
        firearms.setText(strings.get(Resources.FIREARMS));
        ore.setText(strings.get(Resources.ORE));
        games.setText(strings.get(Resources.GAMES));
        medicine.setText(strings.get(Resources.MEDICINE));
        machines.setText(strings.get(Resources.MACHINES));
        narcotics.setText(strings.get(Resources.NARCOTICS));
        robots.setText(strings.get(Resources.ROBOTS));
        return view;
    }

    /**
     * Handles updating the sell market view
     * @param view the current market view
     * @param id the id associated with the resource we are selling
     */
    public void updateView(View view, int id) {
        Inventory currentInventory = player.getInventory();
        switch (id) {
            case R.id.sell_water_display:
                waterDisplay.setText(player.inventoryString(Resources.WATER));
                break;
            case R.id.sell_furs_display:
                fursDisplay.setText(player.inventoryString(Resources.FURS));
                break;
            case R.id.sell_food_display:
                foodDisplay.setText(player.inventoryString(Resources.FOOD));
                break;
            case R.id.sell_firearms_display:
                firearmsDisplay.setText(player.inventoryString(Resources.FOOD));
                break;
            case R.id.sell_ore_display:
                oreDisplay.setText(player.inventoryString(Resources.ORE));
                break;
            case R.id.sell_games_display:
                gameDisplay.setText(player.inventoryString(Resources.GAMES));
                break;
            case R.id.sell_medicine_display:
                medicineDisplay.setText(player.inventoryString(Resources.MEDICINE));
                break;
            case R.id.sell_machines_display:
                machineDisplay.setText(player.inventoryString(Resources.MACHINES));
                break;
            case R.id.sell_narcotics_display:
                narcoticsDisplay.setText(player.inventoryString(Resources.NARCOTICS));
                break;
            case R.id.sell_robots_display:
                robotsDisplay.setText(player.inventoryString(Resources.ROBOTS));
                break;
        }
    }

    /**
     * Updates player credit text in view
     */
    public void updateCredits() {
        credits.setText(Double.toString(player.getCredits()));
    }
}
