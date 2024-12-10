package delivery;

import java.util.function.Function;

public class Building {
    public static int whichFloor(String instructions) {
        Function<Character, Integer> calculateFloor = getCalculateFloorFunction(instructions);

        return instructions.chars()
                .map(c -> calculateFloor.apply((char) c))
                .sum();
    }

    private static Function<Character, Integer> getCalculateFloorFunction(String instructions) {
        return instruction -> {
            if (instructions.contains("🧝")) {
                return calculateFloorWithElf(instruction);
            } else {
                return calculateFloorWithoutElf(instruction);
            }
        };
    }

    private static Integer calculateFloorWithoutElf(char instruction) {
        return instruction == '(' ? 1 : -1;
    }

    private static int calculateFloorWithElf(char instruction) {
        return switch (instruction) {
            case ')' -> 3;
            case '(' -> -2;
            default -> 0;
        };
    }
}
