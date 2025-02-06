package gifts;

public class Child {

    private final String name;
    private final Behavior behavior;
    private ToyWishList wishlist;

    public Child(String name, String behavior, ToyWishList wishlist) {
        this.name = name;
        this.wishlist = wishlist;
        this.behavior = Behavior.create(behavior);
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public String getName() {
        return name;
    }

    public Toy getLastWish() {
        return wishlist.getLastWish();
    }

    public Toy getSecondWish() {
        return wishlist.getSecondWish();
    }

    public Toy getFirstWish() {
        return wishlist.getFirstWish();
    }
}
