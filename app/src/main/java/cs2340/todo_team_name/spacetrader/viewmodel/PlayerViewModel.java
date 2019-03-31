package cs2340.todo_team_name.spacetrader.viewmodel;

import android.app.Application;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import cs2340.todo_team_name.spacetrader.R;
import cs2340.todo_team_name.spacetrader.enums.Resources;
import cs2340.todo_team_name.spacetrader.model.Market;
import cs2340.todo_team_name.spacetrader.model.Planet;
import cs2340.todo_team_name.spacetrader.model.Player;

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

    public HashMap<Resources, String> getAvailableItems(Market market) {
        Resources possible[] = Resources.values();
        HashMap<Resources, String> output = new HashMap<>();
        for (Resources res: possible) {
            String s = "";
            if (market.contains(res)) {
                s = res.getName() + ": " + market.getPriceOfGood(res);
            } else {
                s = "N/A";
            }
            output.put(res, s);
        }
        return output;
    }
}
