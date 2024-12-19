package game;

import java.util.Optional;

public enum Choice {
    ROCK("🪨") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return Optional.empty();
        }
    },
    PAPER("📄") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return Optional.empty();
        }
    },
    SCISSORS("✂️") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return Optional.empty();
        }
    },
    LIZARD("🦎") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return Optional.empty();
        }
    },
    SPOCK("🖖") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return Optional.empty();
        }
    };

    private final String symbol;

    Choice(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    abstract public Optional<String> beatsWithMessage(Choice other);

}