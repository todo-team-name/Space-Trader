package cs2340.todo_team_name.spacetrader.views;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import androidx.lifecycle.ViewModelProviders;
import cs2340.todo_team_name.spacetrader.enums.Difficulty;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.GameState;
import cs2340.todo_team_name.spacetrader.model.GenerateGame;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.todo_team_name.spacetrader.R;

/**
 * Activity for the configuration view
 */
public class ConfigurationActivity extends AppCompatActivity {
    private ConfigurationViewModel configurationViewModel;
    private static final int MAX_POINTS = 16;
    private int remPoints = MAX_POINTS;
    private String token;

    private HashMap<PointTypes, Integer> pointValues;

    private MaterialBetterSpinner difficultySpinner;
    //private TextView pilotName;
    private TextView pilotDisplay;
    private TextView remPointsDisplay;
    private TextView fighterDisplay;
    private TextView traderDisplay;
    private TextView engineerDisplay;



    //ArrayList here because of argument type of method below in onCreate()
    private  ArrayList<SolarSystem> solist;

    /**
     *
     * @return arraylist of solar systems
     */
    public  ArrayList<SolarSystem> getSolist() {
        return solist;
    }

    //private Set<SolarSystem> solarSystems;
    //private TextView hi;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configure_commander_fragment);
        Intent intent = getIntent();
        configurationViewModel =
                ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.difficulty_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner =
                findViewById(R.id.difficultySpinner);
        materialDesignSpinner.setAdapter(adapter);
        //pilotName = (TextView) findViewById(R.id.nameInput);
        TextView hi;
        difficultySpinner = materialDesignSpinner;
        hi = findViewById(R.id.hi_username);
        name = intent.getStringExtra("username");
        token = intent.getStringExtra("token");
        Log.i("TOKEN IN ACT", token);
        String username = "Hi " + name + ",";
        hi.setText(username);
        pointValues = new HashMap<>();
        pilotDisplay = findViewById(R.id.pilotPointsDisplay);
        traderDisplay = findViewById(R.id.traderPointsDisplay);
        engineerDisplay = findViewById(R.id.engineerPointsDisplay);
        fighterDisplay = findViewById(R.id.fighterPointsDisplay);
        remPointsDisplay = findViewById(R.id.remainingPointsDisplay);

        for (PointTypes pointType : PointTypes.values()) {
            pointValues.put(pointType, 0);
        }

    }

    /**
     * generates game state when game is configured
     * @param view current view
     */
    public void createGameState(View view) {
        Player currentPlayer = new Player(name, pointValues);
        Log.i("name", name);
        GenerateGame gameGen = new GenerateGame(currentPlayer, new HashSet<SolarSystem>());
        Set<SolarSystem> solarSystems = gameGen.generate();
        String diff = difficultySpinner.getText().toString();
        diff = diff.toUpperCase();
        GameState currentGameState = new GameState(currentPlayer, Difficulty.valueOf(diff));
        //Log.i("Player Name", currentPlayer.getName());
        //Log.i("Current Game State Info", currentGameState.getDifficulty().toString());
        solist = new ArrayList<>();
        for(SolarSystem sol : solarSystems) {
            Log.i("Solar System: ", sol.toString());
            solist.add(sol);
        }
        boolean configured = configurationViewModel.updateInfo(currentPlayer, solist, token, this);
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("player", currentPlayer);
        intent.putExtra("universe", solist);
        intent.putExtra("token", token);
        startActivity(intent);
    }

    /**
     * updates current point dispalys
     */
    private void updatePointDisplays() {
        Log.i("Logged to", "Config Activity");
        pilotDisplay.setText(Integer.toString(pointValues.get(PointTypes.PILOT)));
        engineerDisplay.setText(Integer.toString(pointValues.get(PointTypes.ENGINEER)));
        traderDisplay.setText(Integer.toString(pointValues.get(PointTypes.TRADER)));
        fighterDisplay.setText(Integer.toString(pointValues.get(PointTypes.FIGHTER)));
        remPointsDisplay.setText(remPoints + "");
    }

    /**
     *
     * @param view current view
     */
    public void decFighter(View view) {
        if (pointValues.get(PointTypes.FIGHTER) > 0) {
            pointValues.put(PointTypes.FIGHTER, pointValues.get(PointTypes.FIGHTER) - 1);
            remPoints++;
        }
        updatePointDisplays();
    }

    /**
     * increments appropriate value
     * @param view current view
     */
    public void incrementValues(View view) {
        if (remPoints > 0) {
            switch (view.getId()){
                case R.id.pilotPointsPlus:
                    pointValues.put(PointTypes.PILOT, pointValues.get(PointTypes.PILOT) + 1);
                    break;
                case R.id.fighterPointsPlus:
                    pointValues.put(PointTypes.FIGHTER, pointValues.get(PointTypes.FIGHTER) + 1);
                    break;
                case R.id.engineerPointsPlus:
                    pointValues.put(PointTypes.ENGINEER, pointValues.get(PointTypes.ENGINEER) + 1);
                    break;
                case R.id.traderPointsPlus:
                    pointValues.put(PointTypes.TRADER, pointValues.get(PointTypes.TRADER) + 1);
                    break;
            }
            remPoints--;
        }
        updatePointDisplays();
    }

    /**
     * decrements appropriate value
     * @param view current view
     */
    public void decrementValues(View view) {

        if ((view.getId() == R.id.pilotPointsMinus) && (pointValues.get(PointTypes.PILOT) > 0)) {
            pointValues.put(PointTypes.PILOT, pointValues.get(PointTypes.PILOT) - 1);
            remPoints++;
        } else if ((view.getId() == R.id.fighterPointsMinus) &&
                (pointValues.get(PointTypes.FIGHTER) > 0)) {
            pointValues.put(PointTypes.FIGHTER, pointValues.get(PointTypes.FIGHTER) - 1);
            remPoints++;
        } else if ((view.getId() == R.id.engineerPointsMinus) &&
                (pointValues.get(PointTypes.ENGINEER) > 0)) {
            pointValues.put(PointTypes.ENGINEER, pointValues.get(PointTypes.ENGINEER) - 1);
            remPoints++;
        } else if ((view.getId() == R.id.traderPointsMinus) &&
                (pointValues.get(PointTypes.TRADER) > 0)) {
            pointValues.put(PointTypes.TRADER, pointValues.get(PointTypes.TRADER) - 1);
            remPoints++;
        }

        updatePointDisplays();
    }

}