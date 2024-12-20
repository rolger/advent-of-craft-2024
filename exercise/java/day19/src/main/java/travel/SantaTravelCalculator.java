package travel;

public class SantaTravelCalculator {
    private SantaTravelCalculator() {
    }

    public static long calculateTotalDistanceRecursively(int numberOfReindeers) throws ArithmeticException {
        if (numberOfReindeers == 1)
            return 1;

        var result = 2 * calculateTotalDistanceRecursively(numberOfReindeers - 1) + 1;

        if (result == -1)
            throw new ArithmeticException("Integer overflow");

        return result;
    }

    public static long calculateTotalDistance(int numberOfReindeers) throws ArithmeticException {
        long distance = 0;

        for (int i = 1; i <= numberOfReindeers; i++) {
            if (i == 1) {
                distance = 1;
            } else {
                distance = distance * 2 + 1;
            }
        }

        if (distance == -1)
            throw new ArithmeticException("Integer overflow");

        return distance;
    }

    public static long calculateTotalDistanceWithBitOps(int numberOfReindeers) throws ArithmeticException {
        long distance = 0;

        for (int i = 1; i <= numberOfReindeers; i++) {
            if (i == 1) {
                distance = 1;
            } else {
                distance = distance << 1 | 1;
            }
        }

        if (distance == -1)
            throw new ArithmeticException("Integer overflow");

        return distance;
    }
}