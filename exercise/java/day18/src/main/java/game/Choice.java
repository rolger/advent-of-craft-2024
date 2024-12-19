package game;

import java.util.Optional;

public enum Choice {
    ROCK("🪨") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return switch (other) {
                case SCISSORS -> Optional.of("rock crushes scissors");
                case LIZARD -> Optional.of("rock crushes lizard");
                default -> Optional.empty();
            };
        }
    },
    PAPER("📄") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return switch (other) {
                case ROCK -> Optional.of("paper covers rock");
                case SPOCK -> Optional.of("paper disproves spock");
                default -> Optional.empty();
            };
        }
    },
    SCISSORS("✂️") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return switch (other) {
                case PAPER -> Optional.of("scissors cuts paper");
                case LIZARD -> Optional.of("scissors decapitates lizard");
                default -> Optional.empty();
            };
        }
    },
    LIZARD("🦎") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return switch (other) {
                case PAPER -> Optional.of("lizard eats paper");
                case SPOCK -> Optional.of("lizard poisons spock");
                default -> Optional.empty();
            };
        }
    },
    SPOCK("🖖") {
        @Override
        public Optional<String> beatsWithMessage(Choice other) {
            return switch (other) {
                case ROCK -> Optional.of("spock vaporizes rock");
                case SCISSORS -> Optional.of("spock smashes scissors");
                default -> Optional.empty();
            };
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