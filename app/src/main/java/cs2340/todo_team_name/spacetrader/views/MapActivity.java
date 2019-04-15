package cs2340.todo_team_name.spacetrader.views;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

public class MapActivity extends Fragment {
    /*private TextView currentSystem;
    private TextView currentPlanet;
    private Player player;
    private ActivityDataProvider activity;
    private TextView fuel;
    private TextView hi;*/


    /**
     * Handles creating the view for our MapActivity
     * @param inflater a layout inflater
     * @param container a layout container
     * @param savedInstanceState a saved instance state
     * @return a created view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        TextView currentSystem;
        TextView currentPlanet;
        Player player;
        ActivityDataProvider activity;
        TextView fuel;
        TextView hi;
        activity = (ActivityDataProvider) getActivity();
        ArrayList<SolarSystem> solarSystems = activity.getSolarSystems();
        SolarSystem testSol = solarSystems.get(0);
        PlayerViewModel playerViewModel = new PlayerViewModel();
        //Planet testPlanet = testSol.getPlanet(0);

        View view = inflater.inflate(R.layout.map_fragment, null);
        currentSystem = view.findViewById(R.id.current_system_info);
        currentPlanet = view.findViewById(R.id.current_planet_info);
        fuel = view.findViewById(R.id.fuel_canisters);
        activity = (ActivityDataProvider) getActivity();
        hi = view.findViewById(R.id.hi_username);
        player = activity.getPlayer();
        Log.i("Player", player.toString());
        String s = playerViewModel.hiString(player);
        hi.setText(s);
        currentSystem.setText(playerViewModel.playerSolarSystemString(player));
        currentPlanet.setText(playerViewModel.playerPlanetString(player));
        fuel.setText(playerViewModel.fuelCanistersString(player));
        return view;
    }
}
