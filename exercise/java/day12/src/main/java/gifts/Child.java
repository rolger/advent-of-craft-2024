package gifts;

public class Child {

    private final String name;
    private final ChildBehavior behavior;

    public Child(String name, String behavior, ToyWishList wishlist) {
        this.name = name;
        this.behavior = ChildBehavior.create(behavior, wishlist);
    }

    public Toy computeWish() {
        return behavior.wish();
    }

    public String getName() {
        return name;
    }

}
