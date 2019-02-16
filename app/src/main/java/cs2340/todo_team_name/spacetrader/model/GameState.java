package cs2340.todo_team_name.spacetrader.model;
import cs2340.todo_team_name.spacetrader.enums.Difficulty;

public class GameState {
    public Difficulty difficulty;
    public Player player;
    public GameState(Player player, Difficulty difficulty) {
        this.player = player;
        this.difficulty = difficulty;
    }
}
