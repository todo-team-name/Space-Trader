package cs2340.todo_team_name.spacetrader.model;
import cs2340.todo_team_name.spacetrader.enums.Difficulty;

public class GameState {
    private Difficulty difficulty;
    private Player player;
    public GameState(Player player, Difficulty difficulty) {
        this.player = player;
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Player getPlayer() {
        return player;
    }


}
