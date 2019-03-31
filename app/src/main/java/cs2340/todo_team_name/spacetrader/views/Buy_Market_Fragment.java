package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.w3c.dom.Text;

import java.util.HashMap;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.Resource;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;
import cs2340.todo_team_name.spacetrader.views.ActivityDataProvider;

public class Buy_Market_Fragment extends Fragment {
    private ActivityDataProvider activity;
    private TextView credits;
    private TextView water;
    private TextView furs;
    private TextView food;
    private TextView firearms;
    private TextView ore;
    private TextView games;
    private TextView medicine;
    private TextView machines;
    private TextView narcotics;
    private TextView robots;

    private Player player;
    private Planet currentPlanet;
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



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        currentPlanet = activity.getCurrentPlanet();
        View view = inflater.inflate(R.layout.market_buy_fragment, null);
        credits = (TextView) view.findViewById(R.id.available_credit_display);
        credits.setText(Double.toString(player.getCredits()));
        PlayerViewModel playerViewModel = activity.getPlayerViewModel();
        water = view.findViewById(R.id.buy_water_label);
        furs = view.findViewById(R.id.buy_furs_label);
        food = view.findViewById(R.id.buy_food_label);
        firearms = view.findViewById(R.id.buy_firearms_label);
        ore = view.findViewById(R.id.buy_ore_label);
        games = view.findViewById(R.id.buy_games_label);
        medicine = view.findViewById(R.id.buy_medicine_label);
        machines = view.findViewById(R.id.buy_machines_label);
        narcotics = view.findViewById(R.id.buy_narcotics_label);
        robots = view.findViewById(R.id.buy_robots_label);
        Market currentMarket = currentPlanet.getMarket();
        HashMap<Resources, String> strings = playerViewModel.getAvailableItems(currentMarket);
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
        waterDisplay = view.findViewById(R.id.buy_water_display);
        fursDisplay = view.findViewById(R.id.buy_furs_display);
        foodDisplay = view.findViewById(R.id.buy_food_display);
        firearmsDisplay = view.findViewById(R.id.buy_firearms_display);
        gameDisplay = view.findViewById(R.id.buy_games_display);
        oreDisplay = view.findViewById(R.id.buy_ore_display);
        medicineDisplay = view.findViewById(R.id.buy_medicine_display);
        machineDisplay = view.findViewById(R.id.buy_machines_display);
        narcoticsDisplay = view.findViewById(R.id.buy_narcotics_display);
        robotsDisplay = view.findViewById(R.id.buy_robots_display);
        Inventory currentInvetory = player.getInventory();
        waterDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.WATER)));
        fursDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FURS)));
        foodDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FOOD)));
        firearmsDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FIREARMS)));
        oreDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.ORE)));
        medicineDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.MEDICINE)));
        machineDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.MACHINES)));
        gameDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.GAMES)));
        narcoticsDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.NARCOTICS)));
        robotsDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.ROBOTS)));
        return view;
    }

    public void updateView(View view, int id) {
        Inventory currentInvetory = player.getInventory();
        switch (id) {
            case R.id.buy_water_display:
                waterDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.WATER)));
                break;
            case R.id.buy_furs_display:
                fursDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FURS)));
                break;
            case R.id.buy_food_display:
                foodDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FOOD)));
                break;
            case R.id.buy_firearms_display:
                foodDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FOOD)));
                break;
            case R.id.buy_games_display:
                gameDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.GAMES)));
                break;
            case R.id.buy_medicine_display:
                medicineDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.MEDICINE)));
                break;
            case R.id.buy_machines_display:
                machineDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.MACHINES)));
                break;
            case R.id.buy_ore_display:
                oreDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.ORE)));
                break;
            case R.id.buy_narcotics_display:
                narcoticsDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.NARCOTICS)));
                break;
            case R.id.buy_robots_display:
                robotsDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.ROBOTS)));
                break;
        }
    }

    public void updateCredits() {
        credits.setText(Double.toString(player.getCredits()));
    }
}