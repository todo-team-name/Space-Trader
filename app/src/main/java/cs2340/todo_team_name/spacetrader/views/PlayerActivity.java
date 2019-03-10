package cs2340.todo_team_name.spacetrader.views;
import android.graphics.Point;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.w3c.dom.Text;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

public class PlayerActivity extends AppCompatActivity {
    private PlayerViewModel playerViewModel;
    private HashMap<PointTypes, Integer> pointValues;
    private TextView pilot;
    private TextView trader;
    private TextView fighter;
    private TextView engineer;
    private TextView name;
    private TextView credits;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commander_status_fragment);
        pilot = findViewById(R.id.pilot_card_info);
        trader = findViewById(R.id.trader_card_info);
        fighter = findViewById(R.id.fighter_card_info);
        engineer = findViewById(R.id.engineer_card_info);
        credits = findViewById(R.id.funds_status);

        credits.setText(player.getCredits());
        pilot.setText(player.getPoints(PointTypes.PILOT));
        trader.setText(player.getPoints(PointTypes.TRADER));
        fighter.setText(player.getPoints(PointTypes.FIGHTER));
        engineer.setText(player.getPoints(PointTypes.ENGINEER));
    }


}
