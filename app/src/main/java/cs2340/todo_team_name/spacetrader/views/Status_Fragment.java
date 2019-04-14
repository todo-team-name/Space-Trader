package cs2340.todo_team_name.spacetrader.views;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

public class Status_Fragment extends Fragment {
    /*private TextView pilot;
    private TextView trader;
    private TextView fighter;
    private TextView engineer;
    //private TextView name;
    private TextView credits;
    private Player player;
    private ActivityDataProvider activity;
    private TextView hi;*/


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View view = inflater.inflate(R.layout.commander_status_fragment, null);
        TextView pilot;
        TextView trader;
        TextView fighter;
        TextView engineer;
        //private TextView name;
        TextView credits;
        Player player;
        ActivityDataProvider activity;
        TextView hi;
        PlayerViewModel playerViewModel = new PlayerViewModel();
        pilot = view.findViewById(R.id.pilot_card_info);
        trader = view.findViewById(R.id.trader_card_info);
        fighter = view.findViewById(R.id.fighter_card_info);
        engineer = view.findViewById(R.id.engineer_card_info);
        credits = view.findViewById(R.id.funds_status);
        activity = (ActivityDataProvider) getActivity();
        player = activity.getPlayer();
        hi = view.findViewById(R.id.hi_username);
        String username = playerViewModel.hiString(player);
        hi.setText(username);
        String creds = playerViewModel.creditsString(player);
        Log.i("Player", player.toString());
        credits.setText(creds);
        pilot.setText(playerViewModel.pointsString(player, PointTypes.PILOT));
        trader.setText(playerViewModel.pointsString(player, PointTypes.TRADER));
        fighter.setText(playerViewModel.pointsString(player, PointTypes.FIGHTER));
        engineer.setText(playerViewModel.pointsString(player, PointTypes.ENGINEER));
        return view;
    }
}
