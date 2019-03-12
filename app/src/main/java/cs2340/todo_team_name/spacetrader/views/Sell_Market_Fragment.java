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

public class Sell_Market_Fragment extends Fragment {
    private ActivityDataProvider activity;
    private TextView water;
    private TextView credits;
    private TextView furs;
    private TextView food;
    private TextView firearms;
    private TextView ore;
    private Player player;
    private Planet currentPlanet;
    private TextView waterDisplay;
    private TextView fursDisplay;
    private TextView foodDisplay;
    private TextView firearmsDisplay;
    private TextView oreDisplay;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        currentPlanet = activity.getCurrentPlanet();
        View view = inflater.inflate(R.layout.sell_cargo_fragment, null);
        credits = (TextView) view.findViewById(R.id.available_credit_display);
        credits.setText(Double.toString(player.getCredits()));
        water = view.findViewById(R.id.sell_water_label);
        furs = view.findViewById(R.id.sell_furs_label);
        food = view.findViewById(R.id.sell_food_label);
        firearms = view.findViewById(R.id.sell_firearms_label);
        ore = view.findViewById(R.id.sell_ore_label);
        waterDisplay = view.findViewById(R.id.sell_water_display);
        fursDisplay = view.findViewById(R.id.sell_furs_display);
        foodDisplay = view.findViewById(R.id.sell_food_display);
        firearmsDisplay = view.findViewById(R.id.sell_firearms_display);
        oreDisplay = view.findViewById(R.id.sell_ore_display);
        Inventory currentInvetory = player.getInventory();
        waterDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.WATER)));
        fursDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FURS)));
        foodDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FOOD)));
        firearmsDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FIREARMS)));
        oreDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.ORE)));

        Market currentMarket = currentPlanet.getMarket();
        water.setText(Double.toString(currentMarket.getPriceOfGood(Resources.WATER)));
        furs.setText(Double.toString(currentMarket.getPriceOfGood(Resources.FURS)));
        food.setText(Double.toString(currentMarket.getPriceOfGood(Resources.FOOD)));
        firearms.setText(Double.toString(currentMarket.getPriceOfGood(Resources.FIREARMS)));
        ore.setText(Double.toString(currentMarket.getPriceOfGood(Resources.ORE)));
        return view;
    }

    public void updateView(View view, int id) {
        Inventory currentInvetory = player.getInventory();
        switch (id) {
            case R.id.sell_water_display:
                waterDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.WATER)));
                break;
            case R.id.sell_furs_display:
                fursDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FURS)));
                break;
            case R.id.sell_food_display:
                foodDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FOOD)));
                break;
            case R.id.sell_firearms_display:
                foodDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.FOOD)));
                break;
            case R.id.sell_ore_display:
                oreDisplay.setText(Integer.toString(currentInvetory.getResource(Resources.ORE)));
                break;
        }
    }

    public void updateCredits() {
        credits.setText(Double.toString(player.getCredits()));
    }
}
