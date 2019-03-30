package cs2340.todo_team_name.spacetrader.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;

public class PlayerViewModel extends ViewModel {
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    //from point of view of buyer
    public void handleBuyItem(String res, Planet current) {
        Resources resource = Resources.valueOf(res);
        current.updatePlayerMarket(player);
        player.purchase(resource);
    }

    //From point of view of buyer
    public void handleSellItem(String res, Planet current) {
        Resources resource = Resources.valueOf(res);
        current.updatePlayerMarket(player);
        player.sell(resource);
    }

    public void updateLocation(SolarSystem system) {
        player.setCurrentSolarSystem(system);
    }
}
