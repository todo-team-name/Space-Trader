package cs2340.todo_team_name.spacetrader.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;

import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.enums.Difficulty;
import cs2340.todo_team_name.spacetrader.enums.PointTypes;
import cs2340.todo_team_name.spacetrader.model.GameState;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.viewmodel.ConfigurationViewModel;

public class ConfigureCommanderFragment extends Fragment {
    private ConfigurationViewModel configurationViewModel;
    private static final int MAX_POINTS = 16;
    private int remPoints = MAX_POINTS;

    private HashMap<PointTypes, Integer> pointValues;

    private Spinner difficultySpinner;
    private TextView pilotName;
    private TextView pilotDisplay;
    private TextView remPointsDisplay;
    private TextView fighterDisplay;
    private TextView traderDisplay;
    private TextView engineerDisplay;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.configure_commander_fragment, container, false);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.difficulty_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner) view.findViewById(R.id.difficultySpinner);
        materialDesignSpinner.setAdapter(adapter);
        pilotName = (TextView) view.findViewById(R.id.nameInput);


        pointValues = new HashMap<>();
        pilotDisplay = (TextView) view.findViewById(R.id.pilotPointsDisplay);
        traderDisplay = view.findViewById(R.id.traderPointsDisplay);
        engineerDisplay = view.findViewById(R.id.engineerPointsDisplay);
        fighterDisplay = view.findViewById(R.id.fighterPointsDisplay);
        remPointsDisplay = (TextView) view.findViewById(R.id.remainingPointsDisplay);

        for (PointTypes pointType : PointTypes.values()) {
            pointValues.put(pointType, 0);
        }
        return view;
    }

    public void createGameState(View view) {
        Player currentPlayer = new Player(pilotName.getText().toString(), pointValues);
        GameState currentGameState = new GameState(currentPlayer, (Difficulty) difficultySpinner.getSelectedItem());
        Log.i("Player Name", currentPlayer.getName());
        Log.i("Current Game State Info", currentGameState.getDifficulty().toString());
    }

    private void updatePointDisplays() {
        pilotDisplay.setText(pointValues.get(PointTypes.PILOT).toString());
        engineerDisplay.setText(pointValues.get(PointTypes.ENGINEER).toString());
        traderDisplay.setText(pointValues.get(PointTypes.TRADER).toString());
        fighterDisplay.setText(pointValues.get(PointTypes.FIGHTER).toString());
        remPointsDisplay.setText(remPoints + "");
    }

    public void decFighter(View view) {
        if (pointValues.get(PointTypes.FIGHTER) > 0) {
            pointValues.put(PointTypes.FIGHTER, pointValues.get(PointTypes.FIGHTER) - 1);
            remPoints++;
        }
        updatePointDisplays();
    }

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

    public void decrementValues(View view) {

        if (view.getId() == R.id.pilotPointsMinus && pointValues.get(PointTypes.PILOT) > 0) {
            pointValues.put(PointTypes.PILOT, pointValues.get(PointTypes.PILOT) - 1);
            remPoints++;
        } else if (view.getId() == R.id.fighterPointsMinus && pointValues.get(PointTypes.FIGHTER) > 0) {
            pointValues.put(PointTypes.FIGHTER, pointValues.get(PointTypes.FIGHTER) - 1);
            remPoints++;
        } else if (view.getId() == R.id.engineerPointsMinus && pointValues.get(PointTypes.ENGINEER) > 0) {
            pointValues.put(PointTypes.ENGINEER, pointValues.get(PointTypes.ENGINEER) - 1);
            remPoints++;
        } else if (view.getId() == R.id.traderPointsMinus && pointValues.get(PointTypes.TRADER) > 0) {
            pointValues.put(PointTypes.TRADER, pointValues.get(PointTypes.TRADER) - 1);
            remPoints++;
        }

        updatePointDisplays();
    }
}
