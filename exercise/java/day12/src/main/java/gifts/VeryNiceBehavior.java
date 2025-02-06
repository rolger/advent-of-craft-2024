package gifts;

public class VeryNiceBehavior extends ChildBehavior {
    public VeryNiceBehavior(ToyWishList wishlist) {
        super(wishlist);
    }

    @Override
    public Toy wish() {
        return wishlist.getFirstWish();
    }
}
