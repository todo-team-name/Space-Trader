package cs2340.todo_team_name.spacetrader.views;

import android.content.Context;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;

public class MapActivity extends Fragment {
    private Player player;
    private TextView pilot;
    private List<SolarSystem> solarSystem;
    private Planet currentPlanet;
    private ActivityDataProvider activity;
    private Spinner map_solar_spinner;
    private Planet planetsArray;

    public View onCreate(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard


        //Getting the Solar System
        solarSystem = ConfigurationActivity.getSolist();

        Log.d("Creation of Map", "Map Created");

        //TODO Create ArrayAdapter for the ArrayList of Solar Systems

        //TODO Populate Spinner with Solar Systems

        SolarSystem selectedSolarSystem = (SolarSystem) map_solar_spinner.getSelectedItem();

        //TODO Get selected Solar System's Planets
        Planet[] planetsArray = (SolarSystem) map_solar_spinner.getSelectedItem().getPlanets();

        ArrayList<Planet> destinationPlanets = new ArrayList<>();
        for(int i = 0; i < planetsArray.length; i++) {
            destinationPlanets.add(planetsArray[i]);
        }




        View view = inflater.inflate(R.layout.map_fragment, null);
        pilot = view.findViewById(R.id.pilot_card_info);
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        Log.i("Player", player.toString());
        return view;
    }

    public void travel(SolarSystem solarSystem, Planet planet) {
        this.player.setCurrentSolarSystem(solarSystem);
        this.player.setCurrentPlanet(planet);
    }
}
