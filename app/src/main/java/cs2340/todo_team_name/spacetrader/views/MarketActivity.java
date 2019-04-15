package cs2340.todo_team_name.spacetrader.views;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

public class MarketActivity extends Fragment {
    /*private ActivityDataProvider activity;
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
    private Player player;*/


    /**
     * Handles creating the view for our MarketActivity
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
        PlayerViewModel playerViewModel = new PlayerViewModel();
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
        Player player;
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        View view = inflater.inflate(R.layout.market_fragment, null);
        water = view.findViewById(R.id.water_cargo_info);
        furs = view.findViewById(R.id.furs_cargo_info);
        food = view.findViewById(R.id.food_cargo_info);
        firearms = view.findViewById(R.id.firearms_cargo_info);
        ore = view.findViewById(R.id.ore_cargo_info);
        games = view.findViewById(R.id.games_cargo_info);
        medicine = view.findViewById(R.id.medicine_cargo_info);
        machines = view.findViewById(R.id.machines_cargo_info);
        narcotics = view.findViewById(R.id.narcotics_cargo_info);
        robots = view.findViewById(R.id.robots_cargo_info);
        //Inventory inv = player.getInventory();
        water.setText(playerViewModel.playerInventoryString(player, Resources.WATER));
        furs.setText(playerViewModel.playerInventoryString(player,Resources.FURS));
        food.setText(playerViewModel.playerInventoryString(player,Resources.FOOD));
        firearms.setText(playerViewModel.playerInventoryString(player,Resources.FIREARMS));
        ore.setText(playerViewModel.playerInventoryString(player,Resources.ORE));
        games.setText(playerViewModel.playerInventoryString(player,Resources.GAMES));
        medicine.setText(playerViewModel.playerInventoryString(player,Resources.MEDICINE));
        machines.setText(playerViewModel.playerInventoryString(player,Resources.MACHINES));
        narcotics.setText(playerViewModel.playerInventoryString(player,Resources.NARCOTICS));
        robots.setText(playerViewModel.playerInventoryString(player,Resources.ROBOTS));
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
