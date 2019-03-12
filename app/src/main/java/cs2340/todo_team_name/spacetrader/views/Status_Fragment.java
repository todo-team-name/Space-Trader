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
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;

public class Status_Fragment extends Fragment {
    private TextView pilot;
    private TextView trader;
    private TextView fighter;
    private TextView engineer;
    private TextView name;
    private TextView credits;
    private Player player;
    private ActivityDataProvider activity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View view = inflater.inflate(R.layout.commander_status_fragment, null);
        pilot = view.findViewById(R.id.pilot_card_info);
        trader = view.findViewById(R.id.trader_card_info);
        fighter = view.findViewById(R.id.fighter_card_info);
        engineer = view.findViewById(R.id.engineer_card_info);
        credits = view.findViewById(R.id.funds_status);
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        String creds = "$";
        creds = creds + Double.toString(player.getCredits());
        Log.i("Player", player.toString());
        credits.setText(creds);
        pilot.setText(Integer.toString(player.getPoints(PointTypes.PILOT)));
        trader.setText(Integer.toString(player.getPoints(PointTypes.TRADER)));
        fighter.setText(Integer.toString(player.getPoints(PointTypes.FIGHTER)));
        engineer.setText(Integer.toString(player.getPoints(PointTypes.ENGINEER)));
        return view;
    }
}
