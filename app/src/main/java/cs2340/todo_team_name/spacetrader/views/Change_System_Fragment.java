package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

/**
 * activity for the change system fragment
 */
public class Change_System_Fragment extends Fragment {
    //private ActivityDataProvider activity;
    private TextView water;
    private TextView credits;
    private TextView furs;
    private TextView food;
    private TextView firearms;
    private TextView ore;
    private Player player;
    //private Planet currentPlanet;
    private TextView waterDisplay;
    private TextView fursDisplay;
    private TextView foodDisplay;
    private TextView firearmsDisplay;
    private TextView oreDisplay;
    /*private Button system1button;
    private Button system2button;
    private Button system3button;
    private Button system4button;
    private Button system5button;
    private Button system6button;
    private Button system7button;
    private Button system8button;
    private Button system9button;
    private Button system10button;*/



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ActivityDataProvider activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        Planet currentPlanet = player.getCurrentPlanet();
        List<SolarSystem> system = activity.getSolarSystems();
        PlayerViewModel playerViewModel = new PlayerViewModel();
        List<String> solarSystemStrings = playerViewModel.allSolarSystemStrings(system);
        View view = inflater.inflate(R.layout.change_solar_system, null);
        Button system1button;
        Button system2button;
        Button system3button;
        Button system4button;
        Button system5button;
        Button system6button;
        Button system7button;
        Button system8button;
        Button system9button;
        Button system10button;
        system1button = view.findViewById(R.id.system1button);
        system2button = view.findViewById(R.id.system2button);
        system3button = view.findViewById(R.id.system3button);
        system4button = view.findViewById(R.id.system4button);
        system5button = view.findViewById(R.id.system5button);
        system6button = view.findViewById(R.id.system6button);
        system7button = view.findViewById(R.id.system7button);
        system8button = view.findViewById(R.id.system8button);
        system9button = view.findViewById(R.id.system9button);
        system10button = view.findViewById(R.id.system10button);
        system1button.setText(solarSystemStrings.get(0));
        system2button.setText(solarSystemStrings.get(1));
        system3button.setText(solarSystemStrings.get(2));
        system4button.setText(solarSystemStrings.get(3));
        system5button.setText(solarSystemStrings.get(4));
        system6button.setText(solarSystemStrings.get(5));
        system7button.setText(solarSystemStrings.get(6));
        system8button.setText(solarSystemStrings.get(7));
        system9button.setText(solarSystemStrings.get(8));
        system10button.setText(solarSystemStrings.get(9));



        Inventory currentInventory = player.getInventory();
        Market currentMarket = player.currentMarket();
        return view;
    }

    /*public void updateView(View view, int id) {

    }*/

    /**
     * updates player's location
     */
    public void updatePlayerLocation() {
        player.setCurrentSolarSystem(player.getCurrentSolarSystem());
    }
}
