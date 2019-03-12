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

import java.util.HashMap;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.Resource;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;

public class MarketActivity extends Fragment {
    private ActivityDataProvider activity;
    private TextView water;
    private TextView furs;
    private TextView food;
    private TextView firearms;
    private TextView ore;
    private Player player;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        View view = inflater.inflate(R.layout.market_fragment, null);
        water = view.findViewById(R.id.water_cargo_info);
        furs = view.findViewById(R.id.furs_cargo_info);
        food = view.findViewById(R.id.food_cargo_info);
        firearms = view.findViewById(R.id.firearms_cargo_info);
        ore = view.findViewById(R.id.ore_cargo_info);
        Inventory inv = player.getInventory();
        water.setText(Integer.toString(inv.getResource(Resources.WATER)));
        furs.setText(Integer.toString(inv.getResource(Resources.FURS)));
        food.setText(Integer.toString(inv.getResource(Resources.FOOD)));
        firearms.setText(Integer.toString(inv.getResource(Resources.FIREARMS)));
        ore.setText(Integer.toString(inv.getResource(Resources.ORE)));
        /*Resource res = new Resource(Resources.WATER);
        water.setText(Integer.toString(inv.getResource(res)));
        res = new Resource(Resources.FURS);
        furs.setText(Integer.toString(inv.getResource(res)));
        res = new Resource(Resources.FOOD);
        food.setText(Integer.toString(inv.getResource(res)));
        res = new Resource(Resources.FIREARMS);
        firearms.setText(Integer.toString(inv.getResource(res)));
        res = new Resource(Resources.ORE);
        ore.setText(Integer.toString(inv.getResource(res)));*/
        return view;
    }
}
