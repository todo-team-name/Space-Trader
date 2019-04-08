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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;

public class MapActivity extends Fragment {
    private TextView currentSystem;
    private TextView currentPlanet;
    private Player player;
    private ActivityDataProvider activity;
    private TextView fuel;
    private TextView hi;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        activity = (ActivityDataProvider) getActivity();
        ArrayList<SolarSystem> solarSystems = activity.getSolarSystems();
        SolarSystem testSol = solarSystems.get(0);
        Planet testPlanet = testSol.getPlanet(0);

        View view = inflater.inflate(R.layout.map_fragment, null);
        currentSystem = view.findViewById(R.id.current_system_info);
        currentPlanet = view.findViewById(R.id.current_planet_info);
        fuel = view.findViewById(R.id.fuel_canisters);
        activity = (ActivityDataProvider) getActivity();
        hi = view.findViewById(R.id.hi_username);
        player = activity.getPlayer();
        Log.i("Player", player.toString());
        String s = "Hi " + player.getName() + ",";
        hi.setText(s);
        currentSystem.setText(player.getCurrentSolarSystem().toString());
        currentPlanet.setText(player.getCurrentPlanet().toString());
        fuel.setText(Integer.toString(player.getFuelCanisters()));
        return view;
    }
}
