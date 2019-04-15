package cs2340.todo_team_name.spacetrader.model;
import cs2340.todo_team_name.spacetrader.enums.Difficulty;

/**
 * GameState for the game
 */
public class GameState {
    private final Difficulty difficulty;
    private final Player player;

    /**
     * Constructor for class
     * @param player current player for game state
     * @param difficulty difficulty of gamestate
     */
    public GameState(Player player, Difficulty difficulty) {
        this.player = player;
        this.difficulty = difficulty;
    }

    /**
     *
     * @return returns current gamestate
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     *
     * @return current player of gamestate
     */
    public Player getPlayer() {
        return player;
    }


}
