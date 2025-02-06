package gifts;

public enum Behavior {

    NAUGHTY {
        @Override
        public Toy wish(Child child) {
            return child.getLastWish();
        }
    }, NICE {
        @Override
        public Toy wish(Child child) {
            return child.getSecondWish();
        }
    }, VERY_NICE {
        @Override
        public Toy wish(Child child) {
            return child.getFirstWish();
        }
    };



    public abstract Toy wish(Child child);

    public static Behavior create(String behavior) {
        return switch (behavior) {
            case "naughty" -> NAUGHTY;
            case "nice" -> NICE;
            case "very nice" -> VERY_NICE;
            default -> throw new IllegalArgumentException("Unknown behavior: " + behavior);
        };
    }
}
