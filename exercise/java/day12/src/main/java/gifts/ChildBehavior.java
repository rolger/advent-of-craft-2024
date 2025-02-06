package gifts;

public abstract class ChildBehavior {

    protected final ToyWishList wishlist;

    public ChildBehavior(ToyWishList wishlist) {
        this.wishlist = wishlist;
    }

    public static ChildBehavior create(String behavior, ToyWishList wishlist) {
        return switch (behavior) {
            case "naughty" -> new NaughtyBehavior(wishlist);
            case "nice" -> new NiceBehavior(wishlist);
            case "very nice" -> new VeryNiceBehavior(wishlist);
            default -> throw new IllegalArgumentException("Unknown behavior: " + behavior);
        };
    }

    public abstract Toy wish();
}
