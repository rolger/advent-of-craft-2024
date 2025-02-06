package gifts;

public enum Behavior {
    NAUGHTY, NICE, VERY_NICE;

    static public Behavior create(String behavior) {
        switch (behavior) {
            case "naughty":
                return NAUGHTY;
            case "nice":
                return NICE;
            case "very nice":
                return VERY_NICE;
        }
        return null;
    }
}
