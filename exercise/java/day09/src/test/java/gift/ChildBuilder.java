package gift;

public class ChildBuilder {
    private static final int DEFAULT_AGE = 6;

    private String firstName = "John";
    private String lastName = "Doe";
    private int age = DEFAULT_AGE;
    private Behavior behavior;
    private GiftRequest giftRequest;

    public static ChildBuilder aNiceChild() {
        ChildBuilder childBuilder = new ChildBuilder();
        childBuilder.behavior = Behavior.NICE;
        return childBuilder;
    }

    public static ChildBuilder aNaughtyChild() {
        ChildBuilder childBuilder = new ChildBuilder();
        childBuilder.behavior = Behavior.NAUGHTY;
        return childBuilder;
    }

    public ChildBuilder withFeasibleGift() {
        this.giftRequest = new GiftRequest("Any gift", true, Priority.NICE_TO_HAVE);
        return this;
    }

    public ChildBuilder withInfeasibleGift() {
        this.giftRequest = new GiftRequest("Any gift", false, Priority.DREAM);
        return this;
    }

    public Child createChild() {
        return new Child(firstName, lastName, age, behavior, giftRequest);
    }

}