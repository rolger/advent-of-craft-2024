package game;

import java.util.Optional;

public enum Choice {
    ROCK("🪨") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            if (other == SCISSORS)
                return Optional.of("rock crushes scissors");
            if (other == LIZARD)
                return Optional.of("rock crushes lizard");
            return Optional.empty();
        }
    },
    PAPER("📄") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            if (other == ROCK)
                return Optional.of("paper covers rock");
            if (other == SPOCK)
                return Optional.of("paper disproves Spock");
            return Optional.empty();
        }
    },
    SCISSORS("✂️") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            if (other == PAPER)
                return Optional.of("scissors cuts paper");
            if (other == LIZARD)
                return Optional.of("scissors decapitates lizard");
            return Optional.empty();
        }
    },
    LIZARD("🦎") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            if (other == PAPER)
                return Optional.of("lizard eats paper");
            if (other == SPOCK)
                return Optional.of("lizard poisons Spock");
            return Optional.empty();
        }
    },
    SPOCK("🖖") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            if (other == ROCK)
                return Optional.of("spock vaporizes rock");
            if (other == SCISSORS)
                return Optional.of("spock smashes scissors");
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