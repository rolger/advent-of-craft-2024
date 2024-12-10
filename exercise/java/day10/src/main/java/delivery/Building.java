package delivery;

public class Building {
    public static final String ELF = "🧝";

    public static final char DOWN_INSTRUCTION = ')';
    public static final char UP_INSTRUCTION = '(';

    private interface FloorStrategy {
        Integer calculateFloor(int instruction);
    }

    private static final FloorStrategy secret = Building::calculateFloorWithElf;
    private static final FloorStrategy standard = Building::calculateFloorWithoutElf;

    public static int whichFloor(String instructions) {
        FloorStrategy floorStrategy = createFloorStrategy(instructions);

        return instructions.chars()
                .map(floorStrategy::calculateFloor)
                .sum();
    }

    private static FloorStrategy createFloorStrategy(String instructions) {
        return instructions.contains(ELF) ? secret : standard;
    }

    private static Integer calculateFloorWithoutElf(int instruction) {
        return switch ((char) instruction) {
            case UP_INSTRUCTION -> 1;
            case DOWN_INSTRUCTION -> -1;
            // don't change the floor for unknown instructions
            default -> 0;
        };
    }

    private static Integer calculateFloorWithElf(int instruction) {
        return switch ((char) instruction) {
            case UP_INSTRUCTION -> -2;
            case DOWN_INSTRUCTION -> 3;
            // don't change the floor for unknown instructions
            default -> 0;
        };
    }
}
