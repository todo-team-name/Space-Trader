package cs2340.todo_team_name.spacetrader.views;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Stack;

import androidx.fragment.app.Fragment;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.viewmodel.PlayerViewModel;

public class PlayerActivity extends AppCompatActivity implements ActivityDataProvider {
    private PlayerViewModel playerViewModel;
    private HashMap<PointTypes, Integer> pointValues;
    private TextView pilot;
    private TextView trader;
    private TextView fighter;
    private TextView engineer;
    private TextView name;
    private TextView credits;
    private Player player;
    private BottomNavigationView nav;
    private TextView water;
    private TextView furs;
    private TextView food;
    private TextView firearms;
    private TextView ore;
    private Stack<View> viewStack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.commander_status_fragment);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        player = (Player) intent.getSerializableExtra("player");
        loadFragment(new Status_Fragment());
        pilot = findViewById(R.id.pilot_card_info);
        trader = findViewById(R.id.trader_card_info);
        fighter = findViewById(R.id.fighter_card_info);
        engineer = findViewById(R.id.engineer_card_info);
        credits = findViewById(R.id.funds_status);
        nav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        viewStack = new Stack<>();
        nav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_status:
                                Log.i("Stats", "These Stats");
                                loadFragment(new Status_Fragment());
                                break;
                            case R.id.menu_map:
                                Log.i("Map", "This Map");
                                break;
                            case R.id.menu_market:
                                Log.i("Market", "This market");
                                loadFragment(new MarketActivity());
                                break;
                        }
                        return false;
                    }
                });
        /*String creds = "$";
        creds = creds + Double.toString(player.getCredits());
        Log.i("Player", player.toString());
        credits.setText(creds);
        pilot.setText(Integer.toString(player.getPoints(PointTypes.PILOT)));
        trader.setText(Integer.toString(player.getPoints(PointTypes.TRADER)));
        fighter.setText(Integer.toString(player.getPoints(PointTypes.FIGHTER)));
        engineer.setText(Integer.toString(player.getPoints(PointTypes.ENGINEER)));*/
    }

    private void switchToMarketView() {
        View currentView = this.findViewById(android.R.id.content);
        viewStack.add(currentView);
        setContentView(R.layout.market_fragment);
        water = findViewById(R.id.water_cargo_info);
        furs = findViewById(R.id.furs_cargo_info);
        food = findViewById(R.id.food_cargo_info);
        firearms = findViewById(R.id.firearms_cargo_info);
        ore = findViewById(R.id.ore_cargo_info);
    }

    /*@Override
    public void onBackPressed() {
        View newview = viewStack.pop();
        setContentView(newview);
    }*/

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

}
