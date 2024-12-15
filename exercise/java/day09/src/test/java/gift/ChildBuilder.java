package gift;

public class ChildBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private Behavior behavior;
    private GiftRequest giftRequest;

    public static ChildBuilder aNiceChild() {
        return new ChildBuilder().setBehavior(Behavior.NICE);
    }

    public static ChildBuilder aNaughtyChild() {
        return new ChildBuilder().setBehavior(Behavior.NAUGHTY);
    }

    public ChildBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ChildBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ChildBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public ChildBuilder setBehavior(Behavior behavior) {
        this.behavior = behavior;
        return this;
    }

    public ChildBuilder setGiftRequest(GiftRequest giftRequest) {
        this.giftRequest = giftRequest;
        return this;
    }

    public Child createChild() {
        return new Child(firstName, lastName, age, behavior, giftRequest);
    }
}