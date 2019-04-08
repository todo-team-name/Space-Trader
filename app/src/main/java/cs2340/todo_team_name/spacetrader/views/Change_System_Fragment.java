package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Inventory;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.Resource;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;

public class Change_System_Fragment extends Fragment {
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
    private Button system1button;
    private Button system2button;
    private Button system3button;
    private Button system4button;
    private Button system5button;
    private Button system6button;
    private Button system7button;
    private Button system8button;
    private Button system9button;
    private Button system10button;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        currentPlanet = player.getCurrentPlanet();
        ArrayList<SolarSystem> system = activity.getSolarSystems();
        View view = inflater.inflate(R.layout.change_solar_system, null);
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
        system1button.setText(system.get(0).getName());
        system2button.setText(system.get(1).getName());
        system3button.setText(system.get(2).getName());
        system4button.setText(system.get(3).getName());
        system5button.setText(system.get(4).getName());
        system6button.setText(system.get(5).getName());
        system7button.setText(system.get(6).getName());
        system8button.setText(system.get(7).getName());
        system9button.setText(system.get(8).getName());
        system10button.setText(system.get(9).getName());



        Inventory currentInvetory = player.getInventory();
        Market currentMarket = currentPlanet.getMarket();
        return view;
    }

    public void updateView(View view, int id) {

    }

    public void updatePlayerLocation() {
        player.setCurrentSolarSystem(player.getCurrentSolarSystem());
    }
}
