package game;

public enum Choice {
    ROCK("🪨"),
    PAPER("📄"),
    SCISSORS("✂️"),
    LIZARD("🦎"),
    SPOCK("🖖");

    private final String symbol;

    Choice(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}