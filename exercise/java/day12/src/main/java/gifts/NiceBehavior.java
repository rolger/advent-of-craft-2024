package gifts;

public class NiceBehavior extends ChildBehavior {
    public NiceBehavior(ToyWishList wishlist) {
        super(wishlist);
    }

    @Override
    public Toy wish() {
        return wishlist.getSecondWish();
    }

}
