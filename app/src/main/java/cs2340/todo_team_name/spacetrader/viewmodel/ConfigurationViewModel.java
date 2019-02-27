package cs2340.todo_team_name.spacetrader.viewmodel;


import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;

import cs2340.todo_team_name.spacetrader.model.Player;

public class ConfigurationViewModel extends AndroidViewModel {
    private Player currentPlayer;

    public ConfigurationViewModel (@NonNull Application application) {
        super(application);
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;

    }
}
