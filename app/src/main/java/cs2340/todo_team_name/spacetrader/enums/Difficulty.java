package cs2340.todo_team_name.spacetrader.enums;

/**
 * Difficulties available in game
 */
public enum Difficulty {
    BEGINNER("Beginner"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");

    private String diff;

    Difficulty(String d) {
        diff = d;
    }
}